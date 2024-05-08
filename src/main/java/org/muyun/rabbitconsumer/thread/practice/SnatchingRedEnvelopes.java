package org.muyun.rabbitconsumer.thread.practice;

import org.muyun.rabbitconsumer.thread.DeadThread;

import java.util.Random;

// 多线程、五个人抢三个红包  100随机分成三个红包
public class SnatchingRedEnvelopes extends Thread {
    static double money = 100;
    static int counter = 3;

    @Override
    public void run() {
        while (true) {
            String threadName = Thread.currentThread().getName();
            synchronized (SnatchingRedEnvelopes.class) {
                if (counter == 0) {
                    System.out.println(threadName + "没抢到红包");
                    break;
                } else {
                    if (counter == 1) {
                        System.out.println(threadName + "抢到了" + money + "元");
                        counter--;
                        money = 0 ;
                        break;
                    } else {
                        Random random = new Random();
                        Double randomDouble = random.nextDouble();
                        System.out.println(threadName + "抢到了" + randomDouble + "元");
                        money = (money - randomDouble);
                        counter --;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SnatchingRedEnvelopes snatchingRedEnvelopes = new SnatchingRedEnvelopes();
        SnatchingRedEnvelopes snatchingRedEnvelopes1 = new SnatchingRedEnvelopes();
        SnatchingRedEnvelopes snatchingRedEnvelopes2 = new SnatchingRedEnvelopes();
        SnatchingRedEnvelopes snatchingRedEnvelopes3 = new SnatchingRedEnvelopes();
        SnatchingRedEnvelopes snatchingRedEnvelopes4 = new SnatchingRedEnvelopes();

        snatchingRedEnvelopes.start();
        snatchingRedEnvelopes1.start();
        snatchingRedEnvelopes2.start();
        snatchingRedEnvelopes3.start();
        snatchingRedEnvelopes4.start();

    }
}
