package Part_4;

import java.nio.BufferUnderflowException;

/*
二叉查找树ADT
* */
public class BinarySearchTree <T  extends Comparable<? super T>> {

    //节点定义
    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T theElement){
            this(theElement,null,null);
        }

        BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt){
            element=theElement;
            left=lt;
            right=rt;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree(){
        root=null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }
    public T findMin(){
        if (isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }
    public T findMax(){
        if (isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }
    public void insert(T x){
        root=insert(x,root);
    }
    public void remove(T x){
        root=remove(x,root);
    }


    //按顺序打印二叉查找树
    public void printTree(){
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(BinaryNode<T> t){
        if (t!=null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    //尾递归判断x是否在树t中
    private boolean contains(T x,BinaryNode<T> t){
        if (t==null){
            return false;
        }

        int compareResult=x.compareTo(t.element);

        if (compareResult<0)
            return contains(x,t.left);
        else if (compareResult>0)
            return contains(x, root.right);
        else
            return true;
    }

    //递归左儿子找到最小值
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if (t==null){
           return null;
        }else if (t.left==null){
            return t;
        }
        return findMin(t.left);
    }

    //不用递归找到最大值
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if (t!=null){
            while (t.right!=null){
                t=t.right;
            }
        }
        return t;
    }

    //插入元素x
    private BinaryNode<T> insert(T x,BinaryNode<T> t){
        if (t==null){
            return new BinaryNode<>(x,null,null);
        }
        int compareRes=x.compareTo(t.element);
        if (compareRes<0){
           t.left= insert(x,t.left);
        }else if (compareRes>0){
            t.right=insert(x,t.right);
        }else {
            ;
        }
        return t;
    }


    //删除某个节点
    private BinaryNode<T> remove(T x,BinaryNode<T> t){

        if (t==null){
            return t;
        }

        int compareRes=x.compareTo(t.element);
        if (compareRes<0){
            t.left=remove(x,t.left);
        }else if (compareRes>0){
            t.right=remove(x,t.right);
        }else if (t.left!=null&&t.right!=null){
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }else {
            t=(t.left!=null)?t.left:t.right;
        }
        return t;
    }

}
