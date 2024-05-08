package org.muyun.rabbitconsumer.thread;

public class RunnableThread implements Runnable{
    int ticket = 0;
    @Override
    public void run() {
        // 开启循环
        while (true) {
            if (sellTicket()) break;
        }
    }

    private synchronized boolean sellTicket() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在售卖第" + ticket + "张票!!!");
        }
        return false;
    }
}
