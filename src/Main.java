import com.cheng.gong.basicthread.ExtendClassThread;
import com.cheng.gong.basicthread.join.AsThread;
import com.cheng.gong.basicthread.join.BsThread;
import com.cheng.gong.basicthread.wait_notify.TheadNotify;
import com.cheng.gong.basicthread.wait_notify.ThreadWait;

/**
 * @author cheng gong
 */
public class Main {
    private static final Object object = new Object();
    /**
     * Global variable
     */
    private int i = 10;

    public static void main(String[] args) {
        //testVariable();
        //testJoinOne();
        testWaitNotify();

    }

    private static void testWaitNotify() {
        Thread t1 = new Thread(new ThreadWait(object));
        Thread t2 = new Thread(new TheadNotify(object));
        t1.start();
        t2.start();
    }
    private static void testJoinOne() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BsThread bt = new BsThread();
        AsThread at = new AsThread(bt);
        try {
            bt.start();
            at.start();
            at.join();//主线程起动，因为调用了at.join()，要等到at结束了，此线程才能向下执行。
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }

    private static void testVariable() {
        Main test = new Main();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();

        ExtendClassThread thread3 = new ExtendClassThread();
        ExtendClassThread thread4 = new ExtendClassThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
