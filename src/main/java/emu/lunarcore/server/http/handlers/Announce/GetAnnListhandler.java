package emu.lunarcore.server.http.handlers.Announce;

import emu.lunarcore.server.http.objects.Announce.GetAnnListResJson;
import emu.lunarcore.util.JsonUtils;
import io.javalin.http.*;
import org.jetbrains.annotations.NotNull;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import emu.lunarcore.server.http.objects.Announce.GetAnnListResJson.*;

import java.util.Collections;
import java.util.List;

public class GetAnnListhandler implements Handler {
    public GetAnnListhandler(){

    }

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        GetAnnListResJson res = new GetAnnListResJson();
        res.retcode = 0;
        res.message = "OK";
        res.data = new GetAnnListResJson.Data();
        res.data.list = Collections.singletonList(new GetAnnListResJson.AnnouncementList());
        res.data.total = 0;
        res.data.type_list = Collections.singletonList(new GetAnnListResJson.AnnouncementType());
        res.data.alert = false;
        res.data.alert_id = 0;
        res.data.timezone = 8; // Set timezone to an appropriate default value
        res.data.t = "";
        res.data.pic_list = Collections.singletonList(new GetAnnListResJson.PicList());
        res.data.pic_total = 0;
        res.data.pic_type_list = Collections.singletonList(new GetAnnListResJson.PicType());
        res.data.pic_alert = false;
        res.data.pic_alert_id = 0;
        res.data.static_sign = "";

        GetAnnListResJson.AnnouncementList emptyAnnouncementList = res.data.list.get(0);
        emptyAnnouncementList.list = Collections.singletonList(new GetAnnListResJson.InnerAnnouncement());
        emptyAnnouncementList.type_id = 0; // Set type_id to 0 or any appropriate default value
        emptyAnnouncementList.type_label = "";

        GetAnnListResJson.InnerAnnouncement emptyInnerAnnouncement = emptyAnnouncementList.list.get(0);
        emptyInnerAnnouncement.ann_id = 0;
        emptyInnerAnnouncement.title = "";
        emptyInnerAnnouncement.subtitle = "";
        emptyInnerAnnouncement.banner = "";
        emptyInnerAnnouncement.content = "";
        emptyInnerAnnouncement.type_label = "";
        emptyInnerAnnouncement.tag_label = "";
        emptyInnerAnnouncement.tag_icon = "";
        emptyInnerAnnouncement.login_alert = 0;
        emptyInnerAnnouncement.lang = "";
        emptyInnerAnnouncement.start_time = "";
        emptyInnerAnnouncement.end_time = "";
        emptyInnerAnnouncement.type = 0;
        emptyInnerAnnouncement.remind = 0;
        emptyInnerAnnouncement.alert = 0;
        emptyInnerAnnouncement.tag_start_time = "";
        emptyInnerAnnouncement.tag_end_time = "";
        emptyInnerAnnouncement.remind_ver = 0;
        emptyInnerAnnouncement.has_content = false;
        emptyInnerAnnouncement.extra_remind = 0;

        GetAnnListResJson.AnnouncementType emptyAnnouncementType = res.data.type_list.get(0);
        emptyAnnouncementType.id = 0;
        emptyAnnouncementType.name = "";
        emptyAnnouncementType.mi18n_name = "";

        GetAnnListResJson.PicList emptyPicList = res.data.pic_list.get(0);
        emptyPicList.type_list = Collections.singletonList(new GetAnnListResJson.InnerPic());

        GetAnnListResJson.InnerPic emptyInnerPic = emptyPicList.type_list.get(0);
        emptyInnerPic.list = Collections.singletonList(new GetAnnListResJson.PicAnnouncement());
        emptyInnerPic.pic_type = 0; // Set pic_type to 0 or any appropriate default value

        GetAnnListResJson.PicAnnouncement emptyPicAnnouncement = emptyInnerPic.list.get(0);
        emptyPicAnnouncement.ann_id = 0;
        emptyPicAnnouncement.title = "";
        emptyPicAnnouncement.subtitle = "";
        emptyPicAnnouncement.banner = "";
        emptyPicAnnouncement.content = "";
        emptyPicAnnouncement.type_label = "";
        emptyPicAnnouncement.tag_label = "";
        emptyPicAnnouncement.tag_icon = "";
        emptyPicAnnouncement.login_alert = 0;
        emptyPicAnnouncement.lang = "";
        emptyPicAnnouncement.start_time = "";
        emptyPicAnnouncement.end_time = "";
        emptyPicAnnouncement.type = 0;
        emptyPicAnnouncement.remind = 0;
        emptyPicAnnouncement.alert = 0;
        emptyPicAnnouncement.tag_start_time = "";
        emptyPicAnnouncement.tag_end_time = "";
        emptyPicAnnouncement.remind_ver = 0;
        emptyPicAnnouncement.has_content = false;
        emptyPicAnnouncement.pic_type = 0; // Set pic_type to 0 or any appropriate default value
        emptyPicAnnouncement.content_type = 0; // Set content_type to 0 or any appropriate default value
        emptyPicAnnouncement.img = "";
        emptyPicAnnouncement.href_type = 0; // Set href_type to 0 or any appropriate default value
        emptyPicAnnouncement.href = "";
        emptyPicAnnouncement.pic_list = Collections.emptyList(); // Create an empty list for pic items
        emptyPicAnnouncement.extra_remind = 0;

        GetAnnListResJson.PicType emptyPicType = res.data.pic_type_list.get(0);
        emptyPicType.id = 0;
        emptyPicType.name = "";
        emptyPicType.mi18n_name = "";

        ctx.status(200);
        ctx.contentType(ContentType.APPLICATION_JSON);
        ctx.result(JsonUtils.encode(res));
    }

}
