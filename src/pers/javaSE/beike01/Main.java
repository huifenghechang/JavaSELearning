package pers.javaSE.beike01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 =sc.nextLine();
        String[] chars1 = line1.split(" ");
        int n = Integer.valueOf(chars1[0]);
        int s = Integer.valueOf(chars1[1]);

        String line2 =sc.nextLine();
        int[] c = new int[n];

        String[] chars = line2.split(" ");
        for(int i=0;i<n;i++){
            c[i]=Integer.valueOf(chars[i]);
        }

        int res = getMaxCategory(s,c);
        System.out.println(res);
    }

    public static int getMaxCategory(int s,int[]c){
        Arrays.sort(c);
        int count = 0;
        int sum = 0;
        for(int i=0;i<c.length;i++){
            if(sum<s){
                sum+=c[count++];
            }
        }
        if(sum>s){
            count = count-1;
        }
        return count;
    }
}
