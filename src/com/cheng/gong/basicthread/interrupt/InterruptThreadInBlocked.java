package com.cheng.gong.basicthread.interrupt;

/**
 * @author
 */
public class InterruptThreadInBlocked extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("进入睡眠状态");
            Thread.sleep(10000);
            System.out.println("睡眠完毕");
        } catch (InterruptedException e) {
            System.out.println("得到中断异常");
        }
        System.out.println("run方法执行完毕");
    }
}
