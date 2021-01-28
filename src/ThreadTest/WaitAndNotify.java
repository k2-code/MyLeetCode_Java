package ThreadTest;

/**
 * 线程的等待通知机制
 */
public class WaitAndNotify {

    //对象锁
    private static Object lock=new Object();

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                for (int i=0;i<5;i++){
                    try{
                        System.out.println("ThreadA:" + i);
                        lock.notify();//随机叫醒一个正在等待的线程，不会释放锁
                        lock.wait();//让自己进入等待状态，释放锁
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
               lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run() {
            synchronized(lock){
                for (int i=0;i<5;i++){
                    try {
                        System.out.println("ThreadB:" + i);
                        lock.notify();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
               lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       // new Thread(new ThreadA()).start();

        //防止ThreadB获得锁
        Thread.sleep(1000);

      //  new ThreadB().run();
        new Thread(new ThreadB()).start();
    }
}
