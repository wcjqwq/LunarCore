package emu.lunarcore.server.http.handlers.Announce;

import emu.lunarcore.server.http.objects.Announce.GetAnnContentResJson;
import emu.lunarcore.util.JsonUtils;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class GetAnnContentHandler implements Handler {
    public GetAnnContentHandler(){

    }
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        GetAnnContentResJson res = new GetAnnContentResJson();
        res.retcode = 0;
        res.message = "OK";
        res.data = new GetAnnContentResJson.Data();
        res.data.list = Collections.singletonList(new GetAnnContentResJson.Announcement());
        res.data.total = 0;
        res.data.pic_list = Collections.singletonList(new GetAnnContentResJson.PicAnnouncement());
        res.data.pic_total = 0;

        GetAnnContentResJson.Announcement emptyAnnouncement = res.data.list.get(0);
        emptyAnnouncement.ann_id = 0;
        emptyAnnouncement.title = "";
        emptyAnnouncement.subtitle = "";
        emptyAnnouncement.banner = "";
        emptyAnnouncement.content = "";
        emptyAnnouncement.lang = "";

        GetAnnContentResJson.PicAnnouncement emptyPicAnnouncement = res.data.pic_list.get(0);
        emptyPicAnnouncement.ann_id = 0;
        emptyPicAnnouncement.content_type = 0;
        emptyPicAnnouncement.title = "";
        emptyPicAnnouncement.subtitle = "";
        emptyPicAnnouncement.banner = "";
        emptyPicAnnouncement.content = "";
        emptyPicAnnouncement.lang = "";
        emptyPicAnnouncement.img = "";
        emptyPicAnnouncement.href_type = 0;
        emptyPicAnnouncement.href = "";
        emptyPicAnnouncement.pic_list = Collections.singletonList(new GetAnnContentResJson.PicItem());

        GetAnnContentResJson.PicItem emptyPicItem = emptyPicAnnouncement.pic_list.get(0);
        emptyPicItem.title = "";
        emptyPicItem.img = "";
        emptyPicItem.href_type = 0;
        emptyPicItem.href = "";

        ctx.status(200);
        ctx.contentType(ContentType.APPLICATION_JSON);
        ctx.result(JsonUtils.encode(res));
    }
}
