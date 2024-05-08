package org.muyun.rabbitconsumer.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cook (ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put("面条");
                System.out.println("厨师放入面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
