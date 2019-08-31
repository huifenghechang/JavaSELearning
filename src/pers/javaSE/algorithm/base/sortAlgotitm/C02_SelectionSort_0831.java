package pers.javaSE.algorithm.base.sortAlgotitm;

import static pers.javaSE.algorithm.base.ScannerLearn.printArray;

public class C02_SelectionSort_0831 {
    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        selectionSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);
    }

    public static void selectionSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

}
