package pers.javaSE.algorithm.trend;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        System.out.println(add(line1,line2));

    }
    public static String add(String line1,String line2){
        String[] number1 = line1.split("\\.");
        String[] number2 = line2.split("\\.");

        String Integer1 = number1[0];
        String Integer2 = number2[0];
        String dot1 = number1[1];
        String dot2 = number2[1];

        // 小数位相加
        StringBuilder dotsb1 = new StringBuilder(dot1);
        StringBuilder dotsb2 = new StringBuilder(dot2);

        while (dotsb1.length()!=dotsb2.length()){
            if(dotsb1.length()<dotsb2.length()){
                dotsb1.append('0');
            }else {
                dotsb2.append('0');
            }
        }

        dotsb1.reverse();
        dotsb2.reverse();
        StringBuilder dotRes = new StringBuilder();

        int jw = 0;// 在加法运算中，进位只可能为1或者0；
        boolean flag = true;
        int len2 = dotsb1.length();
        for(int i=0;i<len2;i++){
            int sum = dotsb1.charAt(i)-'0'+dotsb2.charAt(i)-'0'+jw;
            jw = sum/10;
            sum = sum%10;
            // 只有当末尾的数字中，全部为0时，才不加入结果。
            // 若结果为中，一旦有一位数字不为0，其后续结果的0，可以加入到结果中。
            char c = (char) (sum+'0');
            if(flag&& c=='0'){
                continue;
            }else {
                flag = false;
            }
            dotRes.append(c);
        }
        // 若小数位不是全部为0，则最终的结果
        if(!flag){
            dotRes.append('.');
        }
        // 整数为相加
        StringBuilder intsb1 = new StringBuilder(Integer1);
        intsb1.reverse();
        StringBuilder intsb2 = new StringBuilder(Integer2);
        intsb2.reverse();
        StringBuilder intRes = new StringBuilder();
        // 选择两者中较长者，作为运算的长度控制
        int intLen = intsb1.length()>intsb2.length()?intsb1.length():intsb2.length();
        for(int i=0;i<intLen;i++){
            int sum = jw;
            if(i<intsb1.length()){
                sum += intsb1.charAt(i)-'0';
            }
            if(i<intsb2.length()){
                sum += intsb2.charAt(i)-'0';
            }
            jw = sum/10;
            sum = sum%10;
            char c = (char) (sum+'0');
            intRes.append(c);
        }
        if(jw==1)
            intRes.append('1');
        intRes.reverse();
        dotRes.reverse();
        intRes.append(dotRes.toString());
        return intRes.toString();
    }
}
