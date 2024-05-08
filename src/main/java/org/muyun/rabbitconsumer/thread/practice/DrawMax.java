package org.muyun.rabbitconsumer.thread.practice;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DrawMax implements Callable<Integer> {

    static Set<Integer> set = new HashSet<Integer>();


    public DrawMax(Set<Integer> set) {
        this.set = set;
    }

    @Override
    public Integer call() throws Exception {
        List<Integer> list = new ArrayList<>();
        while (true) {
            synchronized (DrawMax.class) {
                if (set.size() == 0 || set.isEmpty()) {
                    System.out.println(list);
                    break;
                } else {
                    int money = set.iterator().next();
                    list.add(money);
                    set.remove(money);
                }
            }
            Thread.sleep(100);
        }
        return Collections.max(list);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(50);
        set.add(100);
        set.add(200);
        set.add(500);
        set.add(800);
        set.add(2);
        set.add(80);
        set.add(300);
        set.add(700);
        DrawMax d = new DrawMax(set);
        FutureTask<Integer> ft = new FutureTask<>(d);
        FutureTask<Integer> ft2 = new FutureTask<>(d);
        Thread t = new Thread(ft);
        Thread t2 = new Thread(ft2);
        t.start();
        t2.start();
        System.out.println(ft.get());
        System.out.println(ft2.get());

    }
}
