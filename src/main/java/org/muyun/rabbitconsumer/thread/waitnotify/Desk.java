package org.muyun.rabbitconsumer.thread.waitnotify;

public class Desk {
    static int foodFlag = 0; // 座子上是否有面条 0没有、1有
    static int count = 10;  // 食客最多吃10碗
    static Object lock = new Object(); // 桌子锁
}
