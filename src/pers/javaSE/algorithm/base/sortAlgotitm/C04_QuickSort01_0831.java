package pers.javaSE.algorithm.base.sortAlgotitm;

import static pers.javaSE.algorithm.base.ScannerLearn.printArray;

public class C04_QuickSort01_0831 {
    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        quickSort(arr,0,arr.length-1);
        System.out.print("The sorted is:");
        printArray(arr);
    }

    public static void quickSort(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int[] p = partition(nums,0,end);
        quickSort(nums,0,p[0]);
        quickSort(nums,p[1],end);
    }

    public static int[] partition(int[] nums,int start,int end){
        int less = start-1;
        int more = end;
        int pivot = nums[end];
        int cur = start;
        while (cur < more){
            if(nums[cur] < pivot){
                swap(nums,++less,cur++);
            }else if(nums[cur] > pivot){
                swap(nums,--more,cur);
            }else {
                cur++;
            }
        }
        swap(nums,more,end);
        return new int[]{less,more+1};
    }

    public static void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
