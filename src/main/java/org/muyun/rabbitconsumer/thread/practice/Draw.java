package org.muyun.rabbitconsumer.thread.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 抽奖箱随机抽奖
@Slf4j
public class Draw implements Runnable {
    static Set<Integer> set = new HashSet<Integer>();

    static int maxMoneyFir = 0;

    static int maxMoneySec = 0;

    static int countMoneyFir = 0;

    static int countMoneySec = 0;

    static List<Integer> listFir = new ArrayList<Integer>();

    static List<Integer> listSec = new ArrayList<Integer>();

    public Draw(Set<Integer> set) {
        this.set = set;
    }

//    @Override
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        while (true) {
//            synchronized (Draw.class) {
//                if (set.size() == 0 || set.isEmpty()) {
//                    break;
//                } else {
//                    int money = set.iterator().next();
//                    System.out.println(threadName + "又产生了一个" + money + "元大奖");
//                    set.remove(money);
//                }
//            }
//        }
//    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            synchronized (Draw.class) {
                if (set.size() == 0 || set.isEmpty()) {
                    if (threadName.equals("抽奖箱1")) {
                        int sise = listFir.size();
                        log.info(String.format("在此次抽奖过程中,%s一共产生了%d个奖项", threadName, sise));
                        StringBuffer strBuf = new StringBuffer();
                        if (sise == 0) {
                            break;
                        }
                        for (Integer in : listFir) {
                            strBuf.append(in).append(",");
                        }
                        strBuf.deleteCharAt(strBuf.length() - 1);
                        log.info(String.format("  分别为:%s最高奖项为%d元,总计金额为%d元", strBuf.toString(), maxMoneyFir, countMoneyFir));
                        break;
                    } else {
                        int sise = listSec.size();
                        log.info(String.format("在此次抽奖过程中,%s一共产生了%d个奖项", threadName, sise));
                        StringBuffer strBuf = new StringBuffer();
                        if (sise == 0) {
                            break;
                        }
                        for (Integer in : listSec) {
                            strBuf.append(in).append(",");
                        }
                        strBuf.deleteCharAt(strBuf.length() - 1);
                        log.info(String.format("  分别为:%s最高奖项为%d元,总计金额为%d元", strBuf.toString(), maxMoneySec, countMoneySec));
                        break;
                    }
                } else {
                    if (threadName.equals("抽奖箱1")) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        int money = set.iterator().next();
                        listFir.add(money);
                        maxMoneyFir = Math.max(money, maxMoneyFir);
                        countMoneyFir = countMoneyFir + money;
                        set.remove(money);
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        int money = set.iterator().next();
                        listSec.add(money);
                        maxMoneySec = Math.max(money, maxMoneySec);
                        countMoneySec = countMoneySec + money;
                        set.remove(money);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
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
        Draw draw = new Draw(set);
        Thread drawFir = new Thread(draw);
        drawFir.setName("抽奖箱1");
        Thread drawSec = new Thread(draw);
        drawSec.setName("抽奖箱2");
        drawFir.start();
        drawSec.start();
    }
}
