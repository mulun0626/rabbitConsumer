package org.muyun.rabbitconsumer.collection.map;

import java.util.TreeMap;

// 底层红黑树 红黑树经过两个过程  存值和修复
// root杰点为黑、红子为黑、黑高相同 修复情况分为两种、染色、旋转 修复的场景分为七种
public class TreeMapPractive {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1, "1");
    }
}
