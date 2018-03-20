package com.angelmsger.wings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawerMenuContent {

    public static final List<DrawerMenuItem> ITEMS = new ArrayList<DrawerMenuItem>();

    public static final Map<String, DrawerMenuItem> ITEM_MAP = new HashMap<String, DrawerMenuItem>();

    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDrawerMenuItem(i));
        }
    }

    private static void addItem(DrawerMenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DrawerMenuItem createDrawerMenuItem(int position) {
        return new DrawerMenuItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class DrawerMenuItem {
        public final String id;
        public final String content;
        public final String details;

        public DrawerMenuItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
