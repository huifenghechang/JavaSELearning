package pers.javaSE.algorithm.alibaba;

import static pers.javaSE.algorithm.alibaba.QuickSortAlgorithm.printArray;

public class test {
    public static void mergeSort(int[] arr){
        if(arr == null ||arr.length < 2 ){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr,int left,int right){
        if(left == right){
            return;
        }

        // 这一部分的代码，主要是采用划分的思想，将一个问题，划分为两个相同规模的等价子问题
        // 划分的实现，是通过递归调用自身来实现的 ···
        int mid = (left + right) / 2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right); //原代码为mergeSort(arr,mid,right);

        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left,int mid, int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;
        int i = 0; //help数组的初始下标

        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; //原代码为help[i++] = arr[p1++] < arr[p2++] ? arr[p1++] : arr[p2++];

        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= right){
            help[i++] = arr[p2++];
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
