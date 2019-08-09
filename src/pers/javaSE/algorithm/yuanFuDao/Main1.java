package pers.javaSE.algorithm.yuanFuDao;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
* 由此题，联想到的题型有：
* - 正则表达式的匹配
* - 字符号的去括号问题
* - 字符串相关问题
* */
public class Main1 {
    public static void main(String[] args){
        String line = new Scanner(System.in).nextLine();
        String res = parse2(line);
        System.out.println(res);
    }

    // 使用栈来处理字符串
    public static String parse2(String str){
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(!stack.isEmpty() && c==')' ){
                while (!stack.isEmpty()&& stack.peek()!='('){
                    tempSb.append(stack.pop());
                }
                stack.pop();//  弹出栈中的’(';
            }

            // 检查字符是否有数字
            int start = i;
            while (i<str.length() && str.charAt(i) >='0'
                    && str.charAt(i) <='9'){
                i++;
            }

            if(i-start>=1){
                int count = Integer.valueOf(str.substring(start,i));
                for (int k=0;k<count-1;k++){
                    if (tempSb.length()==0){
                        sb.append(str.charAt(start-1));
                    }else {
                        sb.append(tempSb.toString());
                    }
                }
                i--;
                tempSb.delete(0,tempSb.length());
            }else {
                stack.push(c);
                if(c !='('){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }


    public static String parse(String str){
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> len = new LinkedList<>();
        String temp = ""; // 记录括号内的字符串

        // 针对字符串，处理顺序依次为：去括号，统计出现次数，拼接结果
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '('){
                len.add(sb.length());
                continue;
            }

            if(c == ')'){
                // 移除上一个括号开始时的下标
                int newLeftIndex = len.remove(len.size()-1);
                temp = sb.substring(newLeftIndex);
                i++;
            }

            // 处理数字
            int start = i;
            while (i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
                i++;
            }
            // 获取字符后面的数字
            if(i-start>=1){
                int count = Integer.valueOf(str.substring(start,i));
                for(int k=0;k<count-1;k++){
                    if (temp ==""){
                        sb.append(str.charAt(start-1));
                    }else {
                        sb.append(temp);
                    }
                }
                temp = "";
                i--;//若存在数字，此时i指向的字符并没有经过上述判断，所以需要减去1.
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
