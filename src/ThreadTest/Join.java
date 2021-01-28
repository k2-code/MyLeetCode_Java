package ThreadTest;

public class Join {

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("子线程sleep一秒");
                Thread.sleep(1000);
                System.out.println("sleep结束");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(new ThreadA());
        thread.start();
        thread.join();//等待该thread执行结束后再执行下面的语句
        System.out.println("主线程");
    }
}
