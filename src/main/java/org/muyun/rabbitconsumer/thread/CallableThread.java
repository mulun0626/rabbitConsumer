package org.muyun.rabbitconsumer.thread;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 15; i++) {
            count = count + i;
        }
        return count;
    }
}
