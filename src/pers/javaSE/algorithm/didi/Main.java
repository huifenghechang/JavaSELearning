package pers.javaSE.algorithm.didi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = n + 3*(n-1);
        String[] input = new String[len];
        for (int i=0;i<len;i++){
            input[i]=sc.next();
        }
        // 使用双指针法来判断
        for(int i=4;i+2<input.length;i+=3){
            //
            String v1 = input[i-4];
            String sig1 = input[i-2];
            String cur = input[i];
            String sig2 = input[i+2];

            // sig2的符号，来决定能否交换
        }

    }

    public static boolean isOk(String sig1,String sig2){
        return true;
    }
}
