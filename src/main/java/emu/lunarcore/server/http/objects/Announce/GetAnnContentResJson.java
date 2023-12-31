package emu.lunarcore.server.http.objects.Announce;

import java.util.List;

public class GetAnnContentResJson {
    public int retcode;
    public String message;
    public Data data;

    public static class Data {
        public List<Announcement> list;
        public int total;
        public List<PicAnnouncement> pic_list;
        public int pic_total;
    }

    public static class Announcement {
        public int ann_id;
        public String title;
        public String subtitle;
        public String banner;
        public String content;
        public String lang;
    }

    public static class PicAnnouncement {
        public int ann_id;
        public int content_type;
        public String title;
        public String subtitle;
        public String banner;
        public String content;
        public String lang;
        public String img;
        public int href_type;
        public String href;
        public List<PicItem> pic_list;
    }

    public static class PicItem {
        public String title;
        public String img;
        public int href_type;
        public String href;
    }
}
