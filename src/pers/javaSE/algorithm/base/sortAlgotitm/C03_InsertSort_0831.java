package pers.javaSE.algorithm.base.sortAlgotitm;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import static pers.javaSE.algorithm.base.ScannerLearn.printArray;

public class C03_InsertSort_0831 {
    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        insertSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);
    }

    // 插入排序
    public static void insertSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i;j>0;j--){
                if(nums[j]<nums[j-1]){
                    int temp =nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }
}
