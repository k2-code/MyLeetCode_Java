package ThreadTest;

public class VolatileExample {
    int a=0;
    boolean flag=false;

    public void write(){
       // System.out.println("write方法写之前 a="+a);
        a=1;
        //System.out.println("write方法写之后 a="+a);
        flag=true;
    }

    public void reader(){
        if (flag){
            System.out.println("reader方法a="+a);
            //System.out.println("reader方法flag:"+flag);
        }
    }
}
