package com.cheng.gong.basicthread.wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class TheadNotify implements Runnable {
    private final Object lock;

    public TheadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("thread notify 2 is waiting to get lock");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            System.out.println("thread notify 2 get lock");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notify();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread notify 2 do notify method ==== end");
        }
    }

}
