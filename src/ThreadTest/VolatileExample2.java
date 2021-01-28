package ThreadTest;

public class VolatileExample2 {

  //  int a=0;
    private volatile boolean go=false;

    public void Method1(){
        int i=1;
        while (!go){
            System.out.println("Method1方法执行了"+i++);
        }
    }

    public void changeGo(){
        go = true;
        System.out.println("changeMethod:"+go+"$$$$$$$$$$$$$$$$$$$$$$$$$");
    }
}
