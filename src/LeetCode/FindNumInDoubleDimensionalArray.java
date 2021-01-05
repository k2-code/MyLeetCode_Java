package LeetCode;
/*
* 一个二维数组，每一行从左到右递增排序，从上到下也是递增排序。
* 判断一个数是否在该二维数组之中。
* [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
* */
public class FindNumInDoubleDimensionalArray {

    //选定起始位置为右上角，比a小的值都在当前位置的左边
    //比a大的值都在当前位置的下边，通过不断比较并调整当前位置(r,c)来缩小范围
    public static boolean findNum(int[][] nums,int a){
        //判空，略
        int rows=nums.length,cols=nums[0].length;
        int r=0,c=cols-1;//起始位置

        while (r<=rows-1&&c>=0){
            if (nums[r][c]==a){
                return true;
            }else if (a>nums[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},
            {10,13,14,17,24},{18,21,23,26,31}};
        System.out.println(findNum(nums,18));
    }
}
