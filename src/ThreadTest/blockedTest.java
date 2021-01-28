package ThreadTest;

/**
 *线程状态转换
 */
public class blockedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        },"a");

        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        },"b");

        a.start();

        /**
         * 启动线程后执行run方法要消耗时间，a.start()后没有立即拥有锁（处于ready状态）
         * 没有Thread.sleep(1000L)这一句，b也会处于ready状态；加上后a会在这段时间内(该时间要小于2000)获得锁，
         * b会处于blocked状态
         */
       //Thread.sleep(1000L);

       // Thread.sleep(3000L);//a线程会TERMINATED，b会TIMED_WAITING

        //使当前线程执行指定时间，并使线程将进入TIMED_WAITING(等待指定的时间)状态
        a.join(1000L);
        b.start();

        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());

    }

    private static synchronized void testMethod() {
        try{
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
