package pers.javaSE.wanmeiWD;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String line = sc.nextLine();
        int limit = sc.nextInt();
        String[] chars = line.split(" ");
        int[] people = new int[chars.length];
        for (int i=0;i<chars.length;i++){
            people[i] = Integer.valueOf(chars[i]);
        }
        int res = numRescueBoats(people,limit);
        System.out.println(res);

    }


    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length;
        int k = j-1;
        int res = 0;
        while(j!=0){
            if(people[i]<limit){
                if(people[i]+people[k]>limit){
                    j--;
                }
                else{
                    i++;
                    j-=2;
                }
                res++;
                k--;
            }
            if(k<i){
                break;
            }
        }
        return res;
    }
}
