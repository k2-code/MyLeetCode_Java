package Part_7;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a={23,12,3,2,56,15};
        //Integer [] b=insertionSort(a);
        int[] b={23,12,3,2,56,15};
//        int [] c=myInsertSort(b);
//        for (int val:
//             c) {
//            System.out.println(val);
//        }
        int[] d=shellSort(b);
        for (int i:
             d) {
            System.out.println(i);
        }

    }

    public static <T extends Comparable<? super T>> T[] insertionSort(T [] a){
        int j;
        for (int p=1;p< a.length;p++){
            T tmp=a[p];
            for (j=p;j>0&&tmp.compareTo(a[j-1])<0;j--){
                a[j]=a[j-1];
            }
            a[j]=tmp;
        }

        return a;
    }

    public static int[] myInsertSort(int[] a){

        for (int i=0;i<=(a.length-1);i++){
            for (int j=i+1;j<=(a.length-1);j++){
                if (a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static int[] myShellSort(int[] a){

        int step;
        for (step=a.length;step>0;step--){
            for (int i=0;i<i+step;i++){
                while(i<a.length) {
                    if (a[i] > a[i + step]) {
                        int temp = a[i];
                        a[i] = a[i + step];
                        a[i + step] = temp;
                    }
                    i=i+step;
                }
            }
        }
        return null;
    }

    public static int[] shellSort(int[] arr){
        //增量gap，并逐步的缩小增量
        for(int gap = arr.length / 2; gap > 0; gap /= 2 ){
            //从gap个元素，逐个对其所在组进行直接插入排序
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j-gap >= 0 && temp < arr[j - gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
