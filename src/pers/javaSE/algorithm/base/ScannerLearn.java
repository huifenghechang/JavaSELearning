package pers.javaSE.algorithm.base;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class ScannerLearn {

    public static void main(String[] args){
        int[] nums = getFixedNums(3);
        printArray(nums);
    }
    public static void printArray(int[] array){
        for(int i=0;i < array.length;i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }

    public static int[] getInputNumArray(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] chars = line.split(" ");

        int[] nums = new int[chars.length];
        System.out.println("数组长度"+chars.length);
        for (int i=0;i<chars.length;i++){
            nums[i] = Integer.valueOf(chars[i]);
        }
        return nums;
    }

    public static int[] getFixedNums(int n){
        int[] res = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++)
            res[i]= sc.nextInt();
        return res;
    }
}
