package Part_2;
//最大子序列求和
import java.util.*;
public class MaxSubSumTest {
    public static void main(String[] args) {
        int[] nums=new int[]{-2,11,-4,13,-5,-2};
        //int res=  maxSubSum(nums);
       // int res2=maxSubSum2(nums);
       int res3= maxSubSum3(nums);
        System.out.println(res3);
    }

    public static int maxSubSum(int[] a){
        int maxSum=0;
        //i:控制从那个下标开始计算
        for (int i=0;i<a.length;i++){
            //j:控制每次几个数相加，即子序列的长度
            for (int j=i;j<a.length;j++){
                int thisSum=0;
                //从下标i开始处完成长度为j的子序列的相加，得到子序列的和
                for (int k=i;k<=j;k++){
                    thisSum+=a[k];
                }
                if (thisSum>maxSum)
                    maxSum=thisSum;
            }
        }
        return maxSum;
    }

    public static int maxSubSum2(int[] a){
        int maxSum=0;
        //i:控制子序列的起点
        for (int i=0;i<a.length;i++){
            int thisSum=0;

            //以i为起点，j为长度算出子序列的和，同时和上次for循环即j-1长度子序列的和比较
            //该层for循环结束是得到的是以i为起点的所有连续子序列的和的最大值
            for (int j=i;j<a.length;j++){
                thisSum+=a[j];

                if (thisSum>maxSum){
                    maxSum=thisSum;
                }
            }
        }
        return maxSum;
    }

    private static int maxSumPec(int[] a,int left,int right){

        if (left==right){
            if (a[left]>0)
                return a[left];
            else
                return 0;
        }

        int center=(left+right)/2;
        int maxLeftSum=maxSumPec(a,left,center);
        int maxRightSum=maxSumPec(a,center+1,right);

        int maxLeftBorderSum=0,leftBorderSum=0;
        for (int i=center;i>=left;i--){
            leftBorderSum+=a[i];
            if (leftBorderSum>maxLeftBorderSum)
                maxLeftBorderSum=leftBorderSum;
        }

        int maxRightBorderSum=0,rightBorderSum=0;
        for (int i=center+1;i<=right;i++){
            rightBorderSum+=a[i];
            if (rightBorderSum>maxRightBorderSum)
                maxRightBorderSum=rightBorderSum;
        }

       return Math.max(Math.max(maxLeftSum,maxRightSum),(maxLeftBorderSum+maxRightBorderSum));
    }
    public static int maxSubSum3(int[] a){
        return maxSumPec(a,0,a.length-1);
    }

    public static int maxSubSum4(int[] a){
        int maxSum=0,thisSum=0;
        for (int j=0;j<a.length;j++){
            thisSum+=a[j];
             if (thisSum>maxSum)
                 maxSum=thisSum;
             else if (thisSum<0)
                 thisSum=0;
        }
        return maxSum;
    }
}
