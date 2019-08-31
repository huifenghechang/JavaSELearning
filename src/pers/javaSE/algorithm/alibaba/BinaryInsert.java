package pers.javaSE.algorithm.alibaba;

public class BinaryInsert {
    public int binarySearch(int[] nums,int value){
        int start = 0;
        int end = nums.length-1;
        int mid = -1;

        while (start <= end){ // 此处判断
            mid = start +(end-start)/2;
            if(nums[mid] <= value){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }
}
