package pers.javaSE.algorithm.base.sortAlgotitm;
/*
* 快速排序，
* 首先，将数组分成小于pivot和大于pivot两个部分。
* 然后分别对左右两边分别进行 快速排序！
*
* 荷兰国旗问题与本题中partition的区别。
* 荷兰国旗中，进行划分的pivot不一定在数组中。
* 但是在，快速排序中，枢轴值，默认在数组的最后一位。
* */

import static pers.javaSE.algorithm.base.sortAlgotitm.HeapSortAlgorithm.printArray;
public class QuickSort_0810 {

    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,9,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        quickSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);


    }
    public static void quickSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int[] p = partition(arr,0,arr.length-1);
        quickSortCore(arr,0,p[0]);
        quickSortCore(arr,p[1],arr.length-1);
    }

    public static void quickSortCore(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int pivotIndex = (int) (start + Math.random()*(end-start+1));
        swap(arr,pivotIndex,end);// 将枢轴移动至分区的最后一位；
        int[] p = partition(arr,start,end);
        quickSortCore(arr,start,p[0]);
        quickSortCore(arr,p[1],end);
    }

    public static int[] partition(int[] arr,int start,int end){
        int pivot = arr[end];//最后一个元素作为枢轴
        int less = start-1;
        int more = end;
        int cur = start;
        while (cur<more){
            if(arr[cur] <pivot){
                swap(arr,++less,cur++);
            }else if(arr[cur] > pivot){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
        swap(arr,more,end);// 交换后，more指向的是枢轴值，所以第一个大于枢轴值的下标为more+1;
        return new int[]{less,more+1};
    }


    public static void swap(int[] arr,int i,int j){
        int temp =arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
