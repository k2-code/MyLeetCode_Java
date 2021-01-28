package ThreadTest;

/**
 * 信号量，volatile基本用法
 */
public class Signal {

    private static volatile int signal=0;

    private static Object lock=new Object();

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (signal < 5) {
                    if (signal % 2 == 0) {
                        try {
                            System.out.println("threadA:" + signal);
                            signal++;
                            lock.notify();
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (signal < 5) {
                    try {
                        System.out.println("threadB:" + signal);
                        signal = signal + 1;
                        lock.notify();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
