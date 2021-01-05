package LeetCode;

/*
* 将数组{1，2，2，1，1，2，2，2，1，2}中的1放到数组前部，2放到数组后部
* 即：{1，1，1，1，2，2，2，2，2，2}
* 双指针
* */

public class DoublePointer {

    public static int[] sort(int[] nums){

        int j=nums.length-1;
        int i=0;
        while (i<j){
            if (nums[i]==1&&nums[j]==2){
                i++;
                j--;
            } else if (nums[i]==1&&nums[j]==1){
                i++;
            } else if (nums[i]==2&&nums[j]==1){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
                j--;
            } else if (nums[i]==2&&nums[j]==2){
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a={1,2,2,2,1,1,1,2,1,2,1,2,1,1};
        int[] res=sort(a);
        for (int num:
             res) {
            System.out.println(num);
        }
    }
}
