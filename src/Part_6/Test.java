package Part_6;

public class  Test<T>{

    public static void main(String[] args) {
        int [] items={10,9,5,16,8,34,29,2};

        BinaryHeap binaryHeap=new BinaryHeap();
        for (int item: items) {
            binaryHeap.insert(item);
        }

        Comparable b=binaryHeap.findMin();
        System.out.println(b.toString());

        Comparable c=binaryHeap.deleteMin();

        System.out.println(c);
    }

}
