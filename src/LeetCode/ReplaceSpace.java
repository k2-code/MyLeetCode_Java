package LeetCode;
/*
* 替换字符串中的空格
* */
public class ReplaceSpace {

    public static String resString(StringBuffer str){

        int p1=str.length()-1;
        for (int i=0;i<=p1;i++){
            if (str.charAt(i)==' ')
                str.append("  ");
        }

        int p2=str.length()-1;
        while (p1>=0&&p2>p1){
            //从 初始 的str往前遍历
            char c=str.charAt(p1--);
            //如果当前字符串为空格，则插入%20
            if (c==' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                //如果当前字符不为空格，则将其移到 新的 str后面
                str.setCharAt(p2--,c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str=new StringBuffer();
        str.append("你 好");
        System.out.println(resString(str));
    }
}
