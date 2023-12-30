package emu.lunarcore.server.http.handlers.Config;

import emu.lunarcore.LunarCore;
import emu.lunarcore.server.http.objects.ComboTokenResJson;
import emu.lunarcore.server.http.objects.GetConfigResJson;
import emu.lunarcore.util.JsonUtils;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetConfigHandler implements Handler {
    public GetConfigHandler() {

    }
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        GetConfigResJson res = new GetConfigResJson();
        res.retcode = 0;
        res.message = "OK";
        res.data.protocol = true;
        res.data.qr_enabled = false;
        res.data.log_level = "INFO";
        res.data.announce_url = "";
        res.data.push_alias_type = 0;
        res.data.disable_ysdk_guard = true;
        res.data.enable_announce_pic_popup = false;
        res.data.app_name = "BHRPG";
        res.data.qr_enabled_apps.bbs = false;
        res.data.qr_enabled_apps.cloud = false;
        res.data.qr_app_icons.app = "";
        res.data.qr_app_icons.bbs = "";
        res.data.qr_app_icons.cloud = "";
        res.data.qr_cloud_display_name = "";
        res.data.enable_user_center = true;
        res.data.functional_switch_configs = null;
        ctx.status(200);
        ctx.contentType(ContentType.APPLICATION_JSON);
        ctx.result(JsonUtils.encode(res));
    }
}
