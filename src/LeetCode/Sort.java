package LeetCode;

//        Input: [3,2,1,5,6,4] and k = 2
//        Output: 5
//        题目描述：找到倒数第 k 个的元素。

import java.util.PriorityQueue;

public class Sort {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,5,1,6,2};
        int target=2;
        System.out.println(findKthLargest(nums,target));//堆排序
        System.out.println(findKthLargestByQuickSort(nums,2));//快速排序
    }


    public static int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);//向小顶堆中添加值，并维持小顶堆
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();//删除队首元素
        }
        return pq.peek();//返回队列中的最小值
    }

    public static int findKthLargestByQuickSort(int[] nums,int k){
        int l=0,h=nums.length-1;
        while (l<h){
            int j=partition(nums,l,h);
            if (j==k){
                break;
            }else if (j<k){
                l=j+1;
            }
            else {
                h=j-1;
            }
        }
        return nums[k];
    }
    private static int partition(int[] a,int l,int h){
        int i=l,j=h+1;
        while (true){
            while (a[++i]<a[l]&&i<h);
            while (a[--j]>a[l]&&j>l);
            if (i>j){
                break;
            }
            swap(a,l,j);
        }
        swap(a,l,j);
        return j;
    }
    private static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}
