package org.muyun.rabbitconsumer.collection;

import java.util.ArrayList;
import java.util.List;

// 按插入顺序排列、可重复 查询快
public class ArrayListPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        // ctrl + alt 看方法的具体实现
        list.add(101);
        list.add(102);
        list.add(103);
        list.add(104);
        list.add(105);
        list.add(101);
        list.remove(3);
        list.remove((Integer) 105);
        System.out.println(list);

        list.set(2, 1003);
        System.out.println(list);

        list.get(2);
        System.out.println(list);

        int index = list.indexOf(101);
        int lastIndex = list.lastIndexOf(101);
        System.out.println("index: " + index + ", lastIndex: " + lastIndex);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(106);
        secondList.add(107);

        list.addAll(secondList);
        System.out.println(list);

        List<Integer> threeList = new ArrayList<>();
        threeList.add(106);
        list.removeAll(threeList);
        System.out.println(list);

        System.out.println(list.isEmpty() + "-----size: " + list.size());

        list.clear();
        System.out.println(list.isEmpty() + "-----size: " + list.size());

    }
}
