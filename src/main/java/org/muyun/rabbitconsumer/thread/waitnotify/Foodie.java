package org.muyun.rabbitconsumer.thread.waitnotify;

public class Foodie extends Thread {
    @Override
    public void run() {

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.foodFlag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 吃的总数见一
                        Desk.count--;
                        System.out.println("吃货在吃面条，还能在吃" + Desk.count + "碗");
                        // 桌子食物状态改为0
                        Desk.foodFlag = 0;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
