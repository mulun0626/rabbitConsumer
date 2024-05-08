package org.muyun.rabbitconsumer.thread.practice;

// 两个窗口卖一千张票
public class sellTicket extends Thread {
    static int ticketCount = 1000;

    static Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            String threadName = Thread.currentThread().getName();
            synchronized (lock) {
                if (ticketCount == 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticketCount--;
                    System.out.println(threadName + "卖出了一张票，剩余" + ticketCount + "张");
                }
            }
        }
    }

    public static void main(String[] args) {
        sellTicket ticket = new sellTicket();
        sellTicket ticketsec = new sellTicket();
        ticket.setName("窗口一:");
        ticketsec.setName("窗口二:");
        ticket.start();
        ticketsec.start();

    }
}
