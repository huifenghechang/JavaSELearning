package pers.javaSE.algorithm.alibaba;

import static pers.javaSE.algorithm.alibaba.QuickSortAlgorithm.printArray;

public class MergeSort {

   /* public static void  mergeSort(int[] arr){
//        if (arr == null ||arr.length<2)
//            return;
        mergeSort(arr,0,arr.length-1);

    }*/

    public static void mergeSort(int[] arr){
        if(arr.length < 2 || arr == null){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int left,int right){
        if(left==right){
            return;
        }
        int mid = (left+right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right){
        int[] help= new int[right-left+1];
        int p1= left;
        int p2 = mid+1;
        int index = 0;

        while (p1<=mid&&p2<=right){
            help[index++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }

        while (p1<=mid){
            help[index++] = arr[p1++];
        }
        while (p2<=right){
            help[index++] = arr[p2++];
        }

        for (int k=0; k< right-left+1;k++){
            arr[left+k] = help[k]; // 原代码为：arr[k] = help[k]
        }

    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5,-90,0,73};
        System.out.print("The origin is:");
        printArray(arr);
        mergeSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);

    }
}
