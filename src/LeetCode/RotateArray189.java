package LeetCode;

import java.util.Stack;

/*
* 旋转数组
* 给定一个数组将数组中的元素向右移动K个位置
* 输入[1,2,3,4,5,6,7] k=3
* 输出[5,6,7,1,2,3,4]
* */
public class RotateArray189 {

    //重新开辟了栈空间
    public static int[] rotateByStack(int[] param,int k){
       Stack<Integer> container= new Stack<>();
       for (int i=param.length-k-1;i>=0;i--)
           container.push(param[i]);
       for (int i=param.length-1;i>=param.length-k;i--)
           container.push(param[i]);
       for (int i=0;i<param.length;i++)
           param[i]=container.pop();
        return param;
    }

    //使用额外的数组
    public static int[] rotateByArray(int[] nums,int k){
        int n=nums.length;
        int[] newArr=new int[n];
        for (int i=0;i<n;++i){
            newArr[(i+k)%n]=nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
        return nums;
    }


    //将数组翻转
    public static int[] rotateArray(int[] nums,int k){

       // k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return nums;
    }

    private static void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int [] a={1,2,3,4,5,6};
//        int [] res= rotateByStack(a,3);
//        for (int i:
//             res) {
//            System.out.println(i);
//        }
       int[] res= rotateArray(a,3);
        for (int i:
             res) {
            System.out.println(i);
        }
    }

}
