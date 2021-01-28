package ThreadTest;

public class ThreadTest {

//    public static void main(String[] args) {
//        Thread testThread=new Thread(()->{
//            System.out.println("testThread当前线程组的名字："+
//                    Thread.currentThread().getThreadGroup().getName());
//            System.out.println("testThread线程的名字："+
//                    Thread.currentThread().getName());
//        });
//
//        testThread.start();
//        System.out.println("执行main所在的线程组的名字:"+
//                Thread.currentThread().getThreadGroup().getName());
//        System.out.println("执行main方法线程的名字："+
//                Thread.currentThread().getName());
//    }

    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("group1"){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+":"+e.getMessage());
            }
        };

        Thread thread1=new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
        thread1.start();
    }
}
