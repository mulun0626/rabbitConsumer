package org.muyun.rabbitconsumer.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

    // static 当前类的静态资源共享
    static int ticket = 0;

    // 该锁对象一定要是唯一的
    static Object synch = new Object();

    // lock锁
    static Lock lock = new ReentrantLock();

    public MyThread() {
        super();
    }

    public MyThread(String myname) {
        super(myname);
    }

//    @Override
//    public void run() {
//        while (true) {
//            // 同步代码块
//            synchronized (synch) {
//                if (ticket < 100) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    ticket++;
//                    System.out.println(getName() + "正在卖第" + ticket + "张票");
//                } else {
//                    break;
//                }
//            }
//        }
//    }

    // lock锁
    @Override
    public void run() {
        while (true) {
            // 同步代码块
            lock.lock();
            try {
                if (ticket == 100) {
                    break;
                } else {
                    Thread.sleep(100);
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
