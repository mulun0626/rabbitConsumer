package org.muyun.rabbitconsumer.collection;

import java.util.LinkedList;

// 按插入顺序排列、可重复 增删改快
public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

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

        LinkedList<Integer> secondList = new LinkedList<>();
        secondList.add(106);
        secondList.add(107);

        list.addAll(secondList);
        System.out.println(list);

        LinkedList<Integer> threeList = new LinkedList<>();
        threeList.add(106);
        list.removeAll(threeList);
        System.out.println(list);

        System.out.println(list.isEmpty() + "-----size: " + list.size());

        list.clear();
        System.out.println(list.isEmpty() + "-----size: " + list.size());


        // LinkdeList集合特有方法  头插、尾插、头删、尾删 获取头尾元素的方法
        list.addFirst(1);
        list.addLast(2);
        System.out.println("分别头插尾插一次之后的数据-----" + list);

        list.getFirst();
        list.getLast();

        list.removeFirst();
        list.removeLast();

        list.pollFirst();
        list.pollLast();
    }
}
