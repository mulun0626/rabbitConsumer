package org.muyun.rabbitconsumer.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程的第一种方式 extend Thread
        /*
            1、自己定义一个类extend Thread
            2、重写run方法
            3、创建自己定义的Thread继承类
            4、启动线程
         */
//        MyThread myThread = new MyThread();
//        myThread.setName("ThreadFir");
//        myThread.start();
//        MyThread otherThread = new MyThread();
//        otherThread.setName("ThreadSec");
//        otherThread.start();

        // 线程的第二种方式 implement Runnable接口
        /*
         1、自己定义一个类实现Runnable接口
         2、重写里面的run方法
         3、创建自己类的对象
         4、创建一个Thread类对象、并启动线程
         */

//        // 创建自己实现Runnable接口类的对象
//        RunnableThread rt = new RunnableThread();
//
//        // 创建线程对象
//        Thread t1 = new Thread(rt);
//        Thread t2 = new Thread(rt);
//
//        // 给线程设置名字
//        t1.setName("RunnableThreadFir");
//        t2.setName("RunnableThreadSec");
//
//        // 开启线程
//        t1.start();
//        t2.start();

        // 线程的第三种实现方式、前两种多线程都没有返回结果 实现Callable
        /*
            1、自定义CallableThread类、实现Callable
            2、重写call()方法
            3、创建CallableThread对象（表示多线程要执行的任务）
            4、创建FutureTask对象（管理多线程返回的结果）
            5、创建Thread对象并启动
         */
//        CallableThread callableThread = new CallableThread();
//        FutureTask<Integer> futureTask = new FutureTask<>(callableThread);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        int count = futureTask.get();
//        System.out.println("callableThread的结果----" + count);

        // 线程的常用方法 给线程赋名字 可以用setName和构造器的方法、线程等待
        MyThread threadFir = new MyThread("女神");
        MyThread threadSec = new MyThread("舔狗");
//        System.out.println(threadFir.getName());
//        System.out.println(threadSec.getName());
//        System.out.println("线程等待" + System.currentTimeMillis());
//        threadSec.sleep(2000);
//        System.out.println("线程等待结束" + System.currentTimeMillis());


        // 线程的优先级 最低1 最高10 默认5 setPriority
//        threadFir.setPriority(1);
//        threadSec.setPriority(10);
//        System.out.println(threadFir.getPriority());
//        System.out.println(threadSec.getPriority());
//        threadFir.start();
//        threadSec.start();

        // 线程守护 setDaemon 当其它非守护线程执行结束之后守护线程会陆续结束（并不会一下子结束）
//        threadSec.setDaemon(true);
//        threadFir.start();
//        threadSec.start();

        // 出让线程抢到cpu之后让出去重新抢
//        threadFir.yield();
//        threadSec.yield();

        // 插入线程(插队) 先start() 在join()才生效
//        threadFir.start();
//        threadFir.join();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main-thread---" + i);
//        }

    }
}
