package emu.lunarcore.server.http.objects;

public class GetConfigResJson {
    public int retcode;
    public String message;
    public Data data;

    public static class Data {
        public boolean protocol;
        public boolean qr_enabled;
        public String log_level;
        public String announce_url;
        public int push_alias_type;
        public boolean disable_ysdk_guard;
        public boolean enable_announce_pic_popup;
        public String app_name;
        public QREnabledApps qr_enabled_apps;
        public QREnabledAppsIcons qr_app_icons;
        public String qr_cloud_display_name;
        public boolean enable_user_center;
        public FunctionalSwitchConfigs functional_switch_configs;
    }

    public static class QREnabledApps {
        public boolean bbs;
        public boolean cloud;
    }

    public static class QREnabledAppsIcons {
        public String app;
        public String bbs;
        public String cloud;
    }

    public static class FunctionalSwitchConfigs {
        // ?
    }
}
