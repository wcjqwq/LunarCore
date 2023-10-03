package emu.lunarcore.game.battle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.MazeBuffExcel;
import emu.lunarcore.data.excel.StageExcel;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.enums.StageType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.game.player.PlayerLineup;
import emu.lunarcore.game.scene.entity.EntityMonster;
import emu.lunarcore.proto.SceneBattleInfoOuterClass.SceneBattleInfo;
import emu.lunarcore.proto.SceneMonsterOuterClass.SceneMonster;
import emu.lunarcore.proto.SceneMonsterWaveOuterClass.SceneMonsterWave;
import emu.lunarcore.util.Utils;

import it.unimi.dsi.fastutil.ints.IntList;
import lombok.Getter;

@Getter
public class Battle {
    private final int id;
    private final Player player;
    private final PlayerLineup lineup;
    private final List<EntityMonster> npcMonsters;
    private final List<MazeBuff> buffs;
    private final List<StageExcel> stages;
    private final long timestamp;
    
    private Battle(Player player, PlayerLineup lineup) {
        this.id = player.getNextBattleId();
        this.player = player;
        this.lineup = lineup;
        this.npcMonsters = new ArrayList<>();
        this.buffs = new ArrayList<>();
        this.stages = new ArrayList<>();
        this.timestamp = System.currentTimeMillis();
    }
    
    public Battle(Player player, PlayerLineup lineup, StageExcel stage) {
        this(player, lineup);
        this.stages.add(stage);
    }
    
    public Battle(Player player, PlayerLineup lineup, Collection<StageExcel> stages) {
        this(player, lineup);
        this.stages.addAll(stages);
    }
    
    public StageType getStageType() {
        StageExcel stage = this.getFirstStage();
        if (stage != null) {
            return stage.getStageType();
        }
        return StageType.Unknown;
    }

    public StageExcel getFirstStage() {
        if (this.getStages().size() > 0) {
            return this.getStages().get(0);
        } else {
            return null;
        }
    }
    
    public int getStageId() {
        if (this.getStages().size() > 0) {
            return this.getStages().get(0).getId();
        } else {
            return 0;
        }
    }
    
    public MazeBuff addBuff(int buffId, int ownerIndex) {
        return addBuff(buffId, ownerIndex, 0xffffffff);
    }
    
    public MazeBuff addBuff(int buffId, int ownerIndex, int waveFlag) {
        MazeBuffExcel excel = GameData.getMazeBuffExcel(buffId, 1);
        if (excel == null) return null;
        
        MazeBuff buff = new MazeBuff(excel, ownerIndex, waveFlag);
        this.buffs.add(buff);
        
        return buff;
    }
    
    public void clearBuffs() {
        this.buffs.clear();
    }
    
    public SceneBattleInfo toProto() {
        // Build battle info
        var proto = SceneBattleInfo.newInstance()
                .setBattleId(this.getId())
                .setLogicRandomSeed(Utils.randomRange(1, Short.MAX_VALUE))
                .setWorldLevel(player.getWorldLevel());
        
        // Init variables
        int waveId = 0;
        
        // Add monster waves from stages
        for (StageExcel stage : stages) {
            // Build monster waves
            for (IntList sceneMonsterWave : stage.getMonsterWaves()) {
                var wave = SceneMonsterWave.newInstance()
                        .setWaveId(++waveId)
                        .setStageId(stage.getId());
                
                for (int monsterId : sceneMonsterWave) {
                    var monster = SceneMonster.newInstance().setMonsterId(monsterId);
                    wave.addMonsterList(monster);
                }
                
                proto.addMonsterWaveList(wave);
            }
            
            // Set stage for the battle
            if (proto.getStageId() == 0) {
                proto.setStageId(stage.getId());
            }
        }
        
        // Avatars
        for (int i = 0; i < lineup.getAvatars().size(); i++) {
            GameAvatar avatar = getPlayer().getAvatarById(lineup.getAvatars().get(i));
            if (avatar == null) continue;
            
            // Add to proto
            proto.addBattleAvatarList(avatar.toBattleProto(i));
            
            // Add buffs from avatars
            if (avatar.getBuffs().size() > 0) {
                for (var buffEntry : avatar.getBuffs().int2LongEntrySet()) {
                    // Check expiry for buff
                    if (buffEntry.getLongValue() < this.timestamp) {
                        continue;
                    }
                    
                    MazeBuff buff = this.addBuff(buffEntry.getIntKey(), i);
                    if (buff != null) {
                        buff.addTargetIndex(i);
                    }
                }
            }
        }
        
        // Buffs
        for (MazeBuff buff : this.getBuffs()) {
            proto.addBuffList(buff.toProto());
        }
        
        return proto;
    }
}
