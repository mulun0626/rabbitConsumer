package org.muyun.rabbitconsumer.utils;

import java.util.*;

// 哪些可以用到迭代器 1、
// List、Set可以 Map不行
// 提供iterator()方法的就可以讲元素提供给iterator
// 实现Iterable接口的集合类可以

// for each可以遍历数组
// for each遍历时删除或增加集合的内容，会报错ConcurrentModificationException  迭代器遍历时用iteratorSet.remove()删除数据

public class IteratorPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> iteratorList = list.iterator();
        while (iteratorList.hasNext()) {
            System.out.println(iteratorList.next());
        }

        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("a");
        set.add("b");
        Iterator<String> iteratorSet = set.iterator();
        while (iteratorSet.hasNext()) {
            System.out.println(iteratorSet.next());
            // 注意在迭代时进行插入或删除操作会报异常 ConcurrentModificationException  除了iteratorSet.remove()
        }
    }
}
