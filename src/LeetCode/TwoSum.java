package LeetCode;
//        双指针

//        Input: numbers={2, 7, 11, 15}, target=9
//        Output: index1=1, index2=2
//        题目描述：在有序数组中找出两个数，使它们的和为 target。

public class TwoSum {
    public static void main(String[] args) {
       int[] result1=Sum(new int[]{2,7,8,12,45},9);
       int[] result2=sum_simple(new int[]{2,7,8,12,45},10);
       if (result1!=null) {
           for (int i : result1) {
               System.out.println(i);
           }
       }
        if (result2!=null) {
            for (int i : result2) {
                System.out.println(i);
            }
        }
    }

    /*双指针*/
    public static int[] Sum(int[] numbers, int target){
        if (numbers==null){
            return null;
        }
        int i=0,j=numbers.length-1;
        while(i<j){
            int sum=numbers[i]+numbers[j];
            if (sum==target){
                return new int[]{i+1,j+1};
            }else if (sum<target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }

    /*暴力*/
    public static int[] sum_simple(int[] nums,int target){

        if (nums==null){
            return null;
        }
        for (int i=0;i<nums.length-2;i++){
            for ( int j=i+1;j<=nums.length-1;j++){
                 int sum=nums[i]+nums[j];
                 if (sum==target){
                     return new int[]{i+1,j+1};
                 }
            }
        }
        return null;
    }
}
