package pers.javaSE.algorithm.kdxf;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        getNumbers(chars);
    }

    public static void getNumbers(char[] chars){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<chars.length;i++){
            if(chars[i] >='0' && chars[i] <='9'){
                res.append(chars[i]);
            }
        }
        char[] resArray = res.toString().toCharArray();

        Arrays.sort(resArray);
        StringBuilder myres = new StringBuilder();
        for (int i=0;i<resArray.length;i++){
            myres.append(resArray[i]);
        }
        if (myres.length()==0){
            System.out.println("-1");
        }else {
            System.out.println(myres.toString());
        }
    }
}
