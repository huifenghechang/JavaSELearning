package pers.javaSE.algorithm.base;

public class BinarySearch {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,4,5,6,7,8};
        int target = 8;
        int res = binarySearch2(arr,target);
        System.out.printf("The index of target is %d",res);


    }

    // 二分查找，主要是针对排序数组而言的
    public static int binarySearch2(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void binarySearch1(int[] arr,int target){
        int start =0;
        int end = arr.length-1;
        int result = -1;

        while (start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                result = mid;
                break;
            }else if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.printf("The index of target is %d",result);
    }
}
