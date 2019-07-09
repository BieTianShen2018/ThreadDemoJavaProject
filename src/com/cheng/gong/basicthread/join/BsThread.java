package com.cheng.gong.basicthread.join;

/**
 * @author cheng gong
 */
public class BsThread extends Thread {
    public BsThread() {
        super("[BsThread] Thread");
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        int loop = 5, start = 0;
        try {
            for (int i = start; i < loop; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}