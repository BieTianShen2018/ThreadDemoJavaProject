package com.cheng.gong.basicthread.join;

/**
 * @author cheng gong
 */
public class AsThread extends Thread {
    private BsThread bt;

    public AsThread(BsThread bt) {
        super("[AsThread] Thread");
        this.bt = bt;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            bt.join();////线程at启动，因为调用bt.join()，等到bt结束了才向下执行。
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
