package LeetCode;
//双指针

//        Input: 5
//        Output: True
//        Explanation: 1 * 1 + 2 * 2 = 5
//        题目描述：判断一个非负整数是否为两个整数的平方和。

public class SumOFSquare {

    public static void main(String[] args) {
        boolean res=judgeSquareSum(20);
        System.out.println(res);
    }

    public static boolean judgeSquareSum(int target){
        if (target<0){
            return false;
        }
        int i=1,j=(int)Math.sqrt(target);
        while (i<=j){
            int sum=i*i+j*j;
            if (sum==target){
                return true;
            }else if (sum>target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

}
