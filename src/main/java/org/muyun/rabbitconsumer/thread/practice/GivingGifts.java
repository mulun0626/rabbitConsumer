package org.muyun.rabbitconsumer.thread.practice;

public class GivingGifts extends Thread {
    static int count = 100;

    static Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            String threadName = Thread.currentThread().getName();
            synchronized (lock) {
                if (count < 10) {
                    break;
                } else {
                    count--;
                    System.out.println(threadName + "送出了一份礼物,剩余" + count + "份");
                }
            }
        }
    }

    public static void main(String[] args) {
        GivingGifts g = new GivingGifts();
        GivingGifts g2 = new GivingGifts();
        g.setName("小明");
        g2.setName("小白");
        g.start();
        g2.start();
    }
}
