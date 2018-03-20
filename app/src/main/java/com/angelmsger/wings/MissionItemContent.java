package com.angelmsger.wings;

import java.util.ArrayList;
import java.util.List;

public class MissionItemContent {

    public static final List<MissionItemItem> ITEMS = new ArrayList<MissionItemItem>();

    static {
        for (int i = 0; i < 15 ; i++) {
            MissionItemItem missionItemItem = new MissionItemItem(0,
                    "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4027772375,3612334516&fm=58",
                    "迪迦奥特曼", "本部西门", "本16-305", "123456789", "中午1点", "￥3");
            ITEMS.add(missionItemItem);
        }
    }

    public static class MissionItemItem {
        public final int id;
        public final String avataruri;
        public final String username;
        public final String request;
        public final String response;
        public final String phone;
        public final String deadline;
        public final String charge;

        public MissionItemItem(int id, String avataruri, String username, String request,
                               String response, String phone, String deadline, String charge) {
            this.id = id;
            this.avataruri = avataruri;
            this.username = username;
            this.request = request;
            this.response = response;
            this.phone = phone;
            this.deadline = deadline;
            this.charge = charge;
        }
    }
}
