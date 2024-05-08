package org.muyun.rabbitconsumer.collection;

import java.util.LinkedList;
import java.util.Queue;

// 单向队列
public class QueuePractive {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.offer("Fir");
        queue.offer("Sec");
        queue.offer("Deux");

        System.out.println(queue);

        // 出队
        queue.poll();
        System.out.println(queue);
    }
}
