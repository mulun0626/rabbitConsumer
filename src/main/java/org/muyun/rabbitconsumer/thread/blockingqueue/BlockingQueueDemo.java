package org.muyun.rabbitconsumer.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        // 阻塞消息队列实现做面吃面
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);
        cook.start();
        foodie.start();
    }
}
