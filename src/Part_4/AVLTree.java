package Part_4;
/*
???????????
* */
public class AVLTree<T> {

    private static class AvlNode<T>{
        AvlNode(T theElement){
            this(theElement,null,null);
        }

        AvlNode(T theElement,AvlNode<T> lt,AvlNode<T> rt){
            element=theElement;
            left=lt;
            right=rt;
        }

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }


}
