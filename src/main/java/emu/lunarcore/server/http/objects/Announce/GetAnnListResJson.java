package emu.lunarcore.server.http.objects.Announce;
import java.util.List;

public class GetAnnListResJson {
    public int retcode;
    public String message;
    public Data data;

    public static class Data {
        public List<AnnouncementList> list;
        public int total;
        public List<AnnouncementType> type_list;
        public boolean alert;
        public int alert_id;
        public int timezone;
        public String t;
        public List<PicList> pic_list;
        public int pic_total;
        public List<PicType> pic_type_list;
        public boolean pic_alert;
        public int pic_alert_id;
        public String static_sign;
    }

    public static class AnnouncementList {
        public List<InnerAnnouncement> list;
        public int type_id;
        public String type_label;
    }

    public static class InnerAnnouncement {
        public int ann_id;
        public String title;
        public String subtitle;
        public String banner;
        public String content;
        public String type_label;
        public String tag_label;
        public String tag_icon;
        public int login_alert;
        public String lang;
        public String start_time;
        public String end_time;
        public int type;
        public int remind;
        public int alert;
        public String tag_start_time;
        public String tag_end_time;
        public int remind_ver;
        public boolean has_content;
        public int extra_remind;
    }

    public static class AnnouncementType {
        public int id;
        public String name;
        public String mi18n_name;
    }

    public static class PicList {
        public List<InnerPic> type_list;
    }

    public static class InnerPic {
        public List<PicAnnouncement> list;
        public int pic_type;
    }

    public static class PicAnnouncement {
        public int ann_id;
        public String title;
        public String subtitle;
        public String banner;
        public String content;
        public String type_label;
        public String tag_label;
        public String tag_icon;
        public int login_alert;
        public String lang;
        public String start_time;
        public String end_time;
        public int type;
        public int remind;
        public int alert;
        public String tag_start_time;
        public String tag_end_time;
        public int remind_ver;
        public boolean has_content;
        public int pic_type;
        public int content_type;
        public String img;
        public int href_type;
        public String href;
        public List<Object> pic_list;
        public int extra_remind;
    }

    public static class PicType {
        public int id;
        public String name;
        public String mi18n_name;
    }
}
