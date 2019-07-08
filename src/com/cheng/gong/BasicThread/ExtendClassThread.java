package com.cheng.gong.BasicThread;

public class ExtendClassThread extends Thread{

    //类成员变量
    private  int i = 10;
    private  Object object = new Object();
    private String threadName= Thread.currentThread().getName();

    @Override
    public void run() {
        synchronized (object) {
            i++;
            System.out.println("i:"+i);
            try {
                System.out.println("线程"+ Thread.currentThread().getName()+"进入睡眠状态------");
                sleep(10000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束=====");
            i++;
            System.out.println("i:"+i);
        }
    }
}
