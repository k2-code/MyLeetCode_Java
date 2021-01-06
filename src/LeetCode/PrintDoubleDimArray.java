package LeetCode;


import java.util.ArrayList;

public class PrintDoubleDimArray {

    //顺时针打印矩阵的值
    public static ArrayList<Integer> printArray(int[][] param){

        ArrayList<Integer> res=new ArrayList<>();

        int r=0, rows=param.length-1,c=0,cols=param[0].length-1;
        while (r<=rows&&c<=cols){
            //上
            for (int i=c;i<=cols;i++){
                res.add(param[r][i]);
            }
            //右
            for (int i=r+1;i<=rows;i++){
                res.add(param[i][cols]);
            }
            if (r!=rows){
                //下
                for (int i=cols-1;i>=c;i--){
                    res.add(param[rows][i]);
                }
            }
            if (c!=cols){
                //左
                for (int i=rows-1;i>r;i--){
                    res.add(param[i][c]);
                }
            }
            r++;
            rows--;
            c++;
            cols--;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[][]={{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        ArrayList<Integer> res=printArray(nums);
        for (int a:
             res) {
            System.out.println(a);
        }
    }

}
