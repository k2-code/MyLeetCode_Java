package Part_1;

//递归
public class Test {

    public static void main(String[] args) {
        printOut(76234);
    }

    public static void printOut(int n){
        if (n>=10)
            printOut(n/10);
        System.out.println(n%10);
    }

}
