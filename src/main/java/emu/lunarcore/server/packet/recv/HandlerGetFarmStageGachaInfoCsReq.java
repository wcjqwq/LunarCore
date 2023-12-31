package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.GetFarmStageGachaInfoCsReqOuterClass.GetFarmStageGachaInfoCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketGetFarmStageGachaInfoScRsp;

@Opcodes(CmdId.GetFarmStageGachaInfoCsReq)
public class HandlerGetFarmStageGachaInfoCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = GetFarmStageGachaInfoCsReq.parseFrom(data);
        
        session.send(new PacketGetFarmStageGachaInfoScRsp(req.getFarmStageGachaIdList()));
    }

}
