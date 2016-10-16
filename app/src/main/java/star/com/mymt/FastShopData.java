package star.com.mymt;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class FastShopData {

    /**
     * stid : 504525329082004736
     * data : [{"typeface_color":"#4c4c4c","position":1,"module":false,"maintitle":"吃喝玩乐1元享","type":1,"deputytitle":"新用户特权","solds":0,"id":3972,"share":{"message":"拉上小伙伴，吃喝玩乐嗨翻天","url":"http://i.meituan.com/firework/1yuanqi"},"title":"吃喝玩乐1元享","deputy_typeface_color":"#fd8066","tplurl":"imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/1yuanqi","imageurl":"http://p1.meituan.net/w.h/feop/d151a2b0f804385b74f455db55e6441659261.jpg"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"新人特权","type":1,"deputytitle":"首单最高减30","solds":0,"id":4070,"share":{"message":"第一次，吃壕点！外卖最高立减30元","url":"http://i.meituan.com/firework/xinyonghushoujian?activity_id=6641"},"title":"新人特权","deputy_typeface_color":"#21c0ae","tplurl":"imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/xinyonghushoujian?activity_id=6641","imageurl":"http://p0.meituan.net/w.h/feop/613bd080f9ceff66db312dc9cb8b5da421851.png"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"9.9元KTV","type":1,"deputytitle":"呼朋唤友唱K","solds":0,"id":4033,"share":{"message":"本地便宜实惠的KTV都在这啦~","url":"http://i.meituan.com/firework/helloktv"},"title":"9.9元KTV","deputy_typeface_color":"#c280fc","tplurl":"imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/helloktv","imageurl":"http://p0.meituan.net/w.h/feop/b48f4d861d689810af1012bec1e9bc5625498.png"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"19.9元起","type":1,"deputytitle":"特惠观影","solds":0,"id":4031,"share":{"message":"猫眼派对，一期一惠，19.9元起观影不落单！","url":"http://i.meituan.com/firework/movie101meituan"},"title":"19.9元起","deputy_typeface_color":"#fc6a56","tplurl":"imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/movie101meituan","imageurl":"http://p1.meituan.net/w.h/feop/0ffd6ff77e8cba71d91d6f3b9f0bce9731382.png"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"领5元券","type":1,"deputytitle":"秋游好去处","solds":0,"id":4134,"share":{"message":"美团推荐，醉美秋景好去处","url":"http://i.meituan.com/firework/qiuyou"},"title":"领5元券","deputy_typeface_color":"#fdb32b","tplurl":"imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/qiuyou","imageurl":"http://p0.meituan.net/w.h/feop/9175e0b1480bf8dd1af2aa4fe90a29f120097.png"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"1元抽奖","type":1,"deputytitle":"惊喜超乎想象","solds":0,"id":4113,"share":{"message":"我在美团一元抢吧参与了抽奖，你也快来吧","url":"http://npay.meituan.com/resource/oneyuan/index.html?entry=home#deal-list"},"title":"1元抽奖","deputy_typeface_color":"#4f9dfc","tplurl":"imeituan://www.meituan.com/web?url=http://npay.meituan.com/resource/oneyuan/index.html?entry=home#deal-list","imageurl":"http://p1.meituan.net/w.h/feop/1250ab90db5ea0b55c3db7006192e17e31769.png"},{"typeface_color":"#4c4c4c","position":0,"module":false,"maintitle":"今日推荐","type":1,"deputytitle":"品质生活指南","solds":0,"id":3283,"share":{"message":"吃喝玩乐全都有，尽在美团网！","url":"http://api.mobile.meituan.com/group/v1/re/p"},"title":"今日推荐","deputy_typeface_color":"#fc6a56","tplurl":"imeituan://www.meituan.com/recommend?url=http://api.mobile.meituan.com/group/v1/re/p","imageurl":"http://p1.meituan.net/w.h/feop/56fbe07ded8500d8eaf93cfd502b42d347768.png"}]
     * server : {"time":1476532002}
     * paging : {"count":7}
     */

    private String stid;
    /**
     * time : 1476532002
     */

    private ServerBean server;
    /**
     * count : 7
     */

    private PagingBean paging;
    /**
     * typeface_color : #4c4c4c
     * position : 1
     * module : false
     * maintitle : 吃喝玩乐1元享
     * type : 1
     * deputytitle : 新用户特权
     * solds : 0
     * id : 3972
     * share : {"message":"拉上小伙伴，吃喝玩乐嗨翻天","url":"http://i.meituan.com/firework/1yuanqi"}
     * title : 吃喝玩乐1元享
     * deputy_typeface_color : #fd8066
     * tplurl : imeituan://www.meituan.com/web?url=http://i.meituan.com/firework/1yuanqi
     * imageurl : http://p1.meituan.net/w.h/feop/d151a2b0f804385b74f455db55e6441659261.jpg
     */

    private List<DataBean> data;

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public ServerBean getServer() {
        return server;
    }

    public void setServer(ServerBean server) {
        this.server = server;
    }

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ServerBean {
        private int time;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class PagingBean {
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class DataBean {
        private String typeface_color;
        private int position;
        private boolean module;
        private String maintitle;
        private int type;
        private String deputytitle;
        private int solds;
        private int id;
        /**
         * message : 拉上小伙伴，吃喝玩乐嗨翻天
         * url : http://i.meituan.com/firework/1yuanqi
         */

        private ShareBean share;
        private String title;
        private String deputy_typeface_color;
        private String tplurl;
        private String imageurl;

        public String getTypeface_color() {
            return typeface_color;
        }

        public void setTypeface_color(String typeface_color) {
            this.typeface_color = typeface_color;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isModule() {
            return module;
        }

        public void setModule(boolean module) {
            this.module = module;
        }

        public String getMaintitle() {
            return maintitle;
        }

        public void setMaintitle(String maintitle) {
            this.maintitle = maintitle;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDeputytitle() {
            return deputytitle;
        }

        public void setDeputytitle(String deputytitle) {
            this.deputytitle = deputytitle;
        }

        public int getSolds() {
            return solds;
        }

        public void setSolds(int solds) {
            this.solds = solds;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDeputy_typeface_color() {
            return deputy_typeface_color;
        }

        public void setDeputy_typeface_color(String deputy_typeface_color) {
            this.deputy_typeface_color = deputy_typeface_color;
        }

        public String getTplurl() {
            return tplurl;
        }

        public void setTplurl(String tplurl) {
            this.tplurl = tplurl;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public static class ShareBean {
            private String message;
            private String url;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
