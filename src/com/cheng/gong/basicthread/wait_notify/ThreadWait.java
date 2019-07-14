package com.cheng.gong.basicthread.wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class ThreadWait implements Runnable {

    private final Object lock;

    public ThreadWait(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("thread wait 1 is waiting to get lock");
        synchronized (lock) {
            try {
                System.out.println("thread 1 wait get lock");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("thread 1 wait do wait method");
                lock.wait();
                System.out.println("thread 1 wait end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
