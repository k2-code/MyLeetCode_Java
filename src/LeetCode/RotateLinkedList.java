package LeetCode;

import LeetCode.Model.RotateLinkedList_Node;

public class RotateLinkedList {


    //递归实现单链表反转 https://www.cnblogs.com/keeya/p/9218352.html
    public RotateLinkedList_Node reverse(RotateLinkedList_Node head){
        if (head==null||head.next==null){
            return head;
        }
        RotateLinkedList_Node temp=head.next;
        RotateLinkedList_Node newHead=reverse(head.next);
        temp.next=head;
        head.next=null;
        return newHead;
    }
}
