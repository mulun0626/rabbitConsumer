package org.muyun.rabbitconsumer.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// HashMap 底层是hash表  entry(键值对 key-value),key唯一、value可以多个
// jdk1.7 数组和链表头插 1.8及以后 数组链表和红黑树 当数组的长度大于等于64且链表的长度大于8 链表转换为红黑树、否则数组扩容 。当红黑树的长度<6时、转换为链表 尾插
public class HashMapPractive {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();

        //map的常用方法
        // 添加元素
        map.put(1, "Fir");
        map.put(1, "Sec");
        map.put(2, "Mir");
        // 获得元素 通过key获得value
        String value = map.get(1);
        System.out.println(value);
        // 剔除元素
        String boolKey = map.remove(1);
        boolean bool = map.remove(1, "Fir");
        map.clear();
        // 元素的替换
        map.replace(1, "replace");
        System.out.println(map);

        // 保存值 HashMap的key可以为null、treeMap不能为空、key相同、value值会被覆盖
        map.put(1, "Fir");
        map.put(1, "Sec");
        map.put(2, "Mir");
        map.put(null, "Thir");
        System.out.println(map);

        // map的遍历
        // 获取到key集合
        Set<Integer> integerSet = map.keySet();
        for (Integer in : integerSet) {
            System.out.println(in + " : " + map.get(in));
        }

        // 获取到value集合
        Collection<String> list = map.values();
        for (String str : list) {
            System.out.println(str);
        }

        // 获取到entry集合
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
