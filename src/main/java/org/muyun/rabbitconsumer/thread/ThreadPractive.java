package org.muyun.rabbitconsumer.thread;

public class ThreadPractive {
    public static void main(String[] args) {
        // 电影院三个窗口卖一百张票 同步代码块
//        MyThread sellFirst = new MyThread("窗口一:");
//        MyThread sellSecond = new MyThread("窗口二:");
//        MyThread sellThird = new MyThread("窗口三:");
//        sellFirst.start();
//        sellSecond.start();
//        sellThird.start();

        // 同步方法
        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread, "窗口一");
        Thread thread2 = new Thread(runnableThread, "窗口二");
        Thread thread3 = new Thread(runnableThread, "窗口三");
        thread.start();
        thread2.start();
        thread3.start();

        // 死鎖（嵌套锁导致）
        DeadThread threadA = new DeadThread();
        DeadThread threadB = new DeadThread();
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadA.start();
        threadB.start();

    }
}
