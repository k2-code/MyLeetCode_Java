package LeetCode;

import java.util.HashSet;
import java.util.Set;
/*
* 给一个字符串，找出不含重复字符的字串的最大长度
* 方法：滑动窗口 for
*                   if
*                   while
* */
public class MaxSubStr_3 {

    public static int lengthOfLongestSubStr(String str)
    {
        Set<Character> characterSet=new HashSet<>();
        int len=str.length();
        //右指针初始值为-1
        int rPointer=-1,res=0;
        for (int i=0;i<len;i++){
            if (i!=0){
                characterSet.remove(str.charAt(i-1));
            }
            while (rPointer+1<len&&!characterSet.contains(str.charAt(rPointer+1))){
                //不断的移动右指针
                characterSet.add(str.charAt(rPointer+1));
                rPointer++;
            }
            //从i到rPointer个字符是最长的无重复字符串
            res= Math.max(res,rPointer-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str="abbabcbb";
        int res= lengthOfLongestSubStr(str);
        System.out.println(res);
    }
}
