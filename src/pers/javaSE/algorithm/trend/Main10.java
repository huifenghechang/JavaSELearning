package pers.javaSE.algorithm.trend;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String[] numOne = num1.split("\\.");
        String[] numTwo = num2.split("\\.");

        //  整数部分相加
        String result1 = aPlusB(numOne[0],numTwo[0]);
        String result2 = aPlusB(numOne[1],numTwo[1]);
        // 小数部分相加大于1
        if (moreThanOne(numOne[1],numTwo[1])){
            result2 = result2.substring(1);
            String weight = result2.substring(0,1);
            result1 = aPlusB(result1,weight);
        }

        System.out.println(result1+'.'+result2);
    }

    public static boolean moreThanOne (String str1,String str2){
        boolean result = false;
        if(str1.length() >=1 && str2.length()>=1){
            int k = str1.charAt(0)-'0'+str2.charAt(0)-'0';
            if (k>=10){
                result = true;
            }
        }
        return result;
    }

    public static String aPlusB(String str1,String str2){

        int i= str1.length()-1;
        int j= str2.length()-1;
        StringBuilder sb = new StringBuilder();

        int tempSum =0, addSign = 0;
        while (i>=0&&j>=0){
            tempSum = str1.charAt(i)-'0' + str2.charAt(j)-'0' + addSign;
            addSign = tempSum/10;
            sb.append(tempSum%10);
            i--;j--;
        }

        while (i>=0){
            sb.append(str1.charAt(i--));
        }
        while (j>=0){
            sb.append(str1.charAt(j--));
        }

        sb.reverse();
        return sb.toString();
    }
}
