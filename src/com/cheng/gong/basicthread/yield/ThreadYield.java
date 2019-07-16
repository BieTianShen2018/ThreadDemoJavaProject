package com.cheng.gong.basicthread.yield;

/**
 * @author Administrator
 */
public class ThreadYield extends Thread {
    int i = 1;

    @Override
    public void run() {
        int num = 11, yieldNum = 5;
        while (i < num) {
            System.out.println("*******  " + Thread.currentThread().getName() + " **********: " + i++);
            if (yieldNum == i) {
                Thread.yield();
            }
        }
        System.out.println(i + "   currentThread: " + Thread.currentThread() + "=====" + Thread.currentThread().getName());
    }
}