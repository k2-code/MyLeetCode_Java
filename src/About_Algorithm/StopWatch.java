package About_Algorithm;

public class StopWatch {

    private static long start;

    public static void start(){
        start=System.currentTimeMillis();
    }

    public static double elapsedTime(){
        long now=System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}
