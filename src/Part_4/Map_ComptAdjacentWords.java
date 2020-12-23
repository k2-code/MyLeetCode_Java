package Part_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Map_ComptAdjacentWords {

    public static Map<String, List<String>> comptAdjacentWords(List<String> thewords){

        Map<String,List<String>> adjWords=new TreeMap<>();
        Map<Integer,List<String>> wordsByLength=new TreeMap<>();

        //根据单词长度进行分组
        for (String w: thewords) {
            update(wordsByLength,w.length(),w);
        }


        for (Map.Entry<Integer,List<String>> entry:wordsByLength.entrySet()){
            List<String> groupWords=entry.getValue();
            int groupNum=entry.getKey();

            for (int i=0;i<groupNum;i++){
                Map<String,List<String>> repToWord=new TreeMap<>();

                for (String str: groupWords) {
                    String rep=str.substring(0,i)+str.substring(i+1);
                    update(repToWord,rep,str);
                }

                for (List<String> wordClique:repToWord.values()){
                    if (wordClique.size()>=2){
                        for (String s1:wordClique) {
                            for (String s2: wordClique) {
                                if (s1!=s2)
                                    update(adjWords,s1,s2);
                            }
                        }
                    }
                }
            }
        }

        return adjWords;
    }

    private static <T> void update(Map<T,List<String>> m,T key,String val){
        List<String> lst=m.get(key);
        if (lst==null){
            lst=new ArrayList<>();
            m.put(key,lst);
        }
        lst.add(val);
    }
}
