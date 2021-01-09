package LeetCode.Model;

public class RotateLinkedList_Node {
    public int val;
    public RotateLinkedList_Node next;

    public RotateLinkedList_Node(int data){
        this.val=data;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RotateLinkedList_Node getNext() {
        return next;
    }

    public void setNext(RotateLinkedList_Node next) {
        this.next = next;
    }
}
