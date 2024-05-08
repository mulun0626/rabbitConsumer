package org.muyun.rabbitconsumer.thread;

public class DeadThread extends Thread{
    // 鎖A
    static Object lockA = new Object();
    // 锁B
    static Object lockB = new Object();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("threadA")) {
            synchronized (lockA) {
                System.out.println("获得锁lockA,等待锁lockB");
                synchronized (lockB) {
                    System.out.println("获得锁lockB");
                }
            }
        }
        if (threadName.equals("threadB")) {
            synchronized (lockB) {
                System.out.println("获得锁lockB,等待锁lockA");
                synchronized (lockA) {
                    System.out.println("获得锁lockA");
                }
            }
        }
    }
}
