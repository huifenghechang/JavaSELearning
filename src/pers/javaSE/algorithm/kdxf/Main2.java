package pers.javaSE.algorithm.kdxf;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if(line.length()>2) {
            line = line.substring(1, line.length() - 1); // 去除 字符串的“{” 和 “}”
        }else {
            line = "";
        }
        String[] chars = line.split(",");
        int key = 19;

        int[] nums = new int[chars.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(chars[i]);
        }

        int res = binarySearch(nums,key);
        System.out.println(res);
    }

    public static int binarySearch(int[] nums,int key){
        int index = -1;
        if(nums !=null) {
            index = binaryCore(nums, 0, nums.length - 1, key);
        }
        return index==-1?-1:index+1;// 下标为index，对应的是第index+1个数；
    }

    public static int binaryCore(int[] nums,int start,int end,int key){
        if(start <= end){
            int mid = start+(end-start)/2;
            if(key==nums[mid]){
                return mid;
            }else if(key > nums[mid]){
                return binaryCore(nums,mid+1,end,key);
            }else {
                return binaryCore(nums,start,mid-1,key);
            }
        }
        return -1;
    }
}

