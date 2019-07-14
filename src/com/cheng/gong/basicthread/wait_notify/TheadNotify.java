package com.cheng.gong.basicthread.wait_notify;

import java.util.concurrent.TimeUnit;

public class TheadNotify implements Runnable {
    private final Object lock;

    public TheadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("thread B is waiting to get lock");
        synchronized (lock) {
            System.out.println("thread B get lock");
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
            System.out.println("thread B do notify method");
        }
    }

}
