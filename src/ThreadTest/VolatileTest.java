package ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    private static Object lock=new Object();

    static VolatileExample volatileExample=new VolatileExample();
    static VolatileExample2 volatileExample2=new VolatileExample2();

    static class ThreadA implements Runnable{

        @Override
        public void run() {
//            synchronized (lock) {
                volatileExample.write();
//                lock.notify();
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
 ///           }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            //synchronized (lock) {
                volatileExample.reader();
            //}
        }
    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            volatileExample2.Method1();
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            volatileExample2.changeGo();
        }
    }

    public static void main(String[] args) throws InterruptedException {

       // new Thread(new ThreadA()).start();
        //new Thread(new ThreadB()).start();
        //Thread.sleep(1000);

       // Thread t=new Thread(new Thread1());
       // t.start();
        //t.join();
        //new Thread(new Thread2()).start();

        AtomicInteger atomicInteger=new AtomicInteger(10);
        atomicInteger.getAndAdd(20);
        System.out.println(atomicInteger);

    }
}
