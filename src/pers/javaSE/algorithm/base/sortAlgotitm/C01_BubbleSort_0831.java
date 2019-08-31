package pers.javaSE.algorithm.base.sortAlgotitm;

import static pers.javaSE.algorithm.base.ScannerLearn.printArray;

public class C01_BubbleSort_0831 {
    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,9,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        bubbleSort2(arr);
        System.out.print("The sorted is:");
        printArray(arr);
    }

    public static void bubbleSort2(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] nums){
        int end = nums.length-1;
        for(int i=0;i<=end;end--){
           for(int j=i+1;j<=end;j++){
               if(nums[j]<nums[j-1]){
                   int temp = nums[j-1];
                   nums[j-1] = nums[j];
                   nums[j] = temp;
               }
           }
        }
    }
}
