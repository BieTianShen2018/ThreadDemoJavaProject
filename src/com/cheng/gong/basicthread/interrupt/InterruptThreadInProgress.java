package com.cheng.gong.basicthread.interrupt;

/**
 * @author
 */
public class InterruptThreadInProgress extends Thread {
    private volatile boolean isStop = false;

    @Override
    public void run() {
        int i = 0;
        System.out.println("isInterrupted: " + isInterrupted());
        while (!isInterrupted() && i < Integer.MAX_VALUE) {
            System.out.println(i + " while循环" + "Integer.MAX_VALUE: " + Integer.MAX_VALUE);
            i++;
        }
    }

//    @Override
//    public void run() {
//        int i = 0;
//        while(!isStop){
//            i++;
//        }
//    }

    public void setStop(boolean stop) {
        this.isStop = stop;
    }
}
