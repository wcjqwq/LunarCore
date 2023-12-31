package emu.lunarcore.server.http.handlers.config;

import emu.lunarcore.server.http.objects.config.LoadConfigResJson;
import emu.lunarcore.util.JsonUtils;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class LoadConfigHandler implements Handler {
    public LoadConfigHandler(){

    }
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        LoadConfigResJson res = new LoadConfigResJson();
        res.retcode = 0;
        res.message = "OK";
        res.data = new LoadConfigResJson.Data();
        res.data.id = 24;
        res.data.game_key = "hkrpg_global";
        res.data.client = "PC";
        res.data.identity = "I_IDENTITY";
        res.data.guest = false;
        res.data.ignore_versions = "";
        res.data.scene = "S_NORMAL";
        res.data.name = "BHRPG";
        res.data.disable_regist = false;
        res.data.enable_email_captcha = false;
        res.data.thirdparty = List.of("fb", "tw", "gl", "ap");
        res.data.disable_mmt = false;
        res.data.server_guest = false;
        res.data.thirdparty_ignore = Map.of();
        res.data.enable_ps_bind_account = false;

/*        res.data.thirdparty_login_configs = List.of(
            new AbstractMap.SimpleEntry<>("tw", new LoadConfigResJson.ThirdpartyLoginConfig().token_type = "")
        ).stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/

        res.data.initialize_firebase = false;
        res.data.bbs_auth_login = false;
        res.data.bbs_auth_login_ignore = List.of();
        res.data.fetch_instance_id = false;
        res.data.enable_flash_login = false;
        ctx.status(200);
        ctx.contentType(ContentType.APPLICATION_JSON);
        ctx.result(JsonUtils.encode(res));
    }
}
