package Part_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test_MyArrayList {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList= new MyArrayList<String>();

        for (int i=0;i<10;i++){
            myArrayList.add("h");
        }

        for (int i=0;i<10;i++){
            myArrayList.add("h");
        }
        int afterSize=myArrayList.size();
        System.out.println(afterSize);

       Iterator<String> iterator= myArrayList.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }
    }
}
