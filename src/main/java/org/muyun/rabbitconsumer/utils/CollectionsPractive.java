package org.muyun.rabbitconsumer.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Collections集合工具类
public class CollectionsPractive {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "a", "c", "b");
        System.out.println(list);

        // 集合排序
        Collections.sort(list);
        System.out.println(list);

        // 排序之后可以使用工具类的二分查找
        int index = Collections.binarySearch(list, "c");
        System.out.println(index);

        // 可以查询出最大最新值
        String min = Collections.min(list);
        String max = Collections.max(list);
        System.out.println("min = " + min + ", max = " + max);

        // 集合的复制
        List<String> copyList = new ArrayList<>();
        Collections.addAll(copyList, "d", "a", "c", "b");
        Collections.copy(copyList, list); //将list的值复制到copyList(前提copyList.size() > list.size())
        System.out.println(copyList);

        // 集合线程安全
        Collections.synchronizedCollection(copyList);
    }
}
