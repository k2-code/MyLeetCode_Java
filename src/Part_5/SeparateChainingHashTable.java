package Part_5;

import java.util.LinkedList;
import java.util.List;

/*
* 散列，分离链接法
* */
public class SeparateChainingHashTable<T> {

    private static final int DEFAULT_TABLE_SIZE=101;
    private List<T> [] theLists;
    private int currentSize;

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size){

    }

}
