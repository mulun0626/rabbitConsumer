package org.muyun.rabbitconsumer.collection;

import java.util.ArrayDeque;
import java.util.Deque;

// 双端队列
public class DequePractive {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();

        deque.offerFirst("A");
        deque.offerLast("B");

        System.out.println(deque);


        deque.pollFirst();
        System.out.println(deque);

        deque.offerFirst("A");
        deque.pollLast();
        System.out.println(deque);
    }
}
