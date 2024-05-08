package org.muyun.rabbitconsumer.thread;

import java.util.concurrent.*;

public class ThreadPoolConfig {
    // 获取当前系统可用的处理器数量Runtime.getRuntime().availableProcessors()
    private static final int fullPool = Runtime.getRuntime().availableProcessors();

    private static volatile ThreadPoolExecutor threadPool;

    private ThreadPoolConfig () {

    }

    public static ThreadPoolExecutor getThreadPool () {
        if (threadPool == null) {
            synchronized (ThreadPoolConfig.class) {
                if (threadPool == null) {
                    threadPool = newThreadPool();
                }
            }
        }
        return threadPool;
    }

    private static ThreadPoolExecutor newThreadPool() {
        return new ThreadPoolExecutor(
                4, //核心线程数量
                fullPool, //最大线程数量
                60, // 空闲线程最大存活时间
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(100), // 阻塞队列长度
                Executors.defaultThreadFactory(), // 创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()); // 任务的拒绝策略（当所有的线程都在运行且排队队列已满时对剩下的处理策略）
    }

    public static void main(String[] args) {

    }
}
