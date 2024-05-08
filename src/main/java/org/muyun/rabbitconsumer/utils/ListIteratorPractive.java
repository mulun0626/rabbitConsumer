package org.muyun.rabbitconsumer.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// 只能遍历List和子类的集合
public class ListIteratorPractive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println("iterator迭代顺序输出:   " + integerListIterator.next());
        }

        // 倒序输出(使用前提必须先顺序输出一遍,否则无法进入方法)
        while (integerListIterator.hasPrevious()) {
            System.out.println("iterator迭代倒序输出:   " + integerListIterator.previous());
        }

    }
}
