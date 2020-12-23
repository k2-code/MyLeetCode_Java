package About_Algorithm;

public class RatioTest {
    public static void main(String[] args) {
        int N=500;
        int loopTime=7;
        double preTime=-1;
        while (loopTime-- >0){
            int[] nums=new int[N];
            StopWatch.start();
            int cnt=count(nums);
            System.out.println(cnt);
            double elapsedTime=StopWatch.elapsedTime();
            double ratio=preTime==-1?0:elapsedTime/preTime;
            System.out.println(N+" "+elapsedTime+" "+ratio);
            preTime=elapsedTime;
            N*=2;
        }

    }

    private static int count(int[] nums){
        int N=nums.length;
        int cnt=0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                for (int k=j+1;k<N;k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}


