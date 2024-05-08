package org.muyun.rabbitconsumer.thread.practice;

// 多线程打印100之内的奇数
public class PrintNumber extends Thread {
    static int counter = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (PrintNumber.class) {
                if ( counter == 0 ) {
                    break;
                } else if ( counter == 100) {
                    counter--;
                    System.out.println(counter);
                } else if (counter == 3) {
                    counter = 0;
                    System.out.println(1);
                } else {
                    counter = counter - 2;
                    System.out.println(counter);
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();
        p.start();
        PrintNumber p2 = new PrintNumber();
        p2.start();
    }
}
