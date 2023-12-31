package emu.lunarcore.server.http.objects.Config;
import java.util.List;
import java.util.Map;
public class LoadConfigResJson {
    public int retcode;
    public String message;
    public Data data;

    public static class Data {
        public int id;
        public String game_key;
        public String client;
        public String identity;
        public boolean guest;
        public String ignore_versions;
        public String scene;
        public String name;
        public boolean disable_regist;
        public boolean enable_email_captcha;
        public List<String> thirdparty;
        public boolean disable_mmt;
        public boolean server_guest;
        public Map<String, Object> thirdparty_ignore;
        public boolean enable_ps_bind_account;
        public Map<String, ThirdpartyLoginConfig> thirdparty_login_configs;
        public boolean initialize_firebase;
        public boolean bbs_auth_login;
        public List<Object> bbs_auth_login_ignore;
        public boolean fetch_instance_id;
        public boolean enable_flash_login;
    }

    public static class ThirdpartyLoginConfig {
        public String token_type;
        public int game_token_expires_in;
    }
}
