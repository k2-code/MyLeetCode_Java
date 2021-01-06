package LeetCode;

import java.util.*;

/*
* 第一个只出现一次的字符
* Input:abacc
* Output:b
* */
public class FirstOnlyChar {


    //HashMap是无序的并不能找出 第一个 出现一次的字符
    //HashMap是根据key的HashCode排序的
    public static HashMap<Character, Integer> findChar(String str){
        HashMap<Character, Integer> map=new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                Integer val= map.get(str.charAt(i));
                map.put(str.charAt(i),++val);
            }else {
                map.put(str.charAt(i),1);
            }
            str.charAt(i);
        }
        return map;
    }


    //LinkedHashMap有序
    public static Character findChar2(String str){
        Character res=null;
        LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                Integer val= map.get(str.charAt(i));
                map.put(str.charAt(i),++val);
            }else {
                map.put(str.charAt(i),1);
            }
        }
//        Set<Character> keyset=map.keySet();
//        for (Character key:keyset){
//            if (map.get(key)==1){
//                res=key;
//            }
//        }

        //按照顺序遍历map
        Iterator<Map.Entry<Character,Integer>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character,Integer> next=iterator.next();
            if (next.getValue()==1){
                res=next.getKey();
                break;
            }
        }
        return res;
    }

    public static void iterator(LinkedHashMap<Character,Integer> map){
        Iterator<Map.Entry<Character,Integer>> iterator=map.entrySet().iterator();
    }

    public static void main(String[] args) {
        String str="ccba";
        Character res = findChar2(str);
        System.out.println(res);
    }
}
