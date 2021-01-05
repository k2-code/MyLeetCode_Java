package LeetCode;

/*
* 在长度为n的数组里，所有的数字都是在0到n-1的范围内，
* 数组中可能存在重复的数字，找出任意一个重复数字
* */
public class RepetitiveNum {

    public static int findNum(int[] nums){

        int res=nums.length;

     /*   如果i位置上的数字a与i不相等，则
        将i位置上的数字a放到数组的a位置上，交换后，
        若仍不相等则继续交换，在交换前判断数字a是否和数组a
        位置上的数字是否相等，若相等，则该数字为重复数字。 */
        for (int i=0;i<nums.length;i++){
            int a=nums[i];
            while(a!=i){
                if (a!=nums[a]) {
                    int tmp = nums[a];
                    nums[a] = nums[i];
                    nums[i] = tmp;
                    a=nums[i];
                }else {
                    res=a;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={0,2,1,4,7,4,5,6};
       int res= findNum(a);
       if (res!=a.length){
           System.out.println("重复数字为:"+res);
       }else {
           System.out.println("无重复数字");
       }
    }
}
