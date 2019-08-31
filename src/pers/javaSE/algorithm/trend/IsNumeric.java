package pers.javaSE.algorithm.trend;

// 学习一下正则表达式
/*
* 下标访问数组，一定要判断是否越界
* 写判断条件时，需要好好的写，是否有括号，大于小于号方向是否写错等！！！
*
* */
public class IsNumeric {
        // A[.B][e|E][C]
        public static int index = 0;
        public static void main(String[] args){
           boolean res =  isNumeric("12e".toCharArray());
           System.out.println(res);
        }
        public static boolean isNumeric(char[] str) {
            boolean res = false;
            boolean isNum ;
            if (str != null) {
               isNum = isInteger(str);

               if(index < str.length &&str[index]=='.'){
                   index++;
                   isNum = isUnsignedNum(str) || isNum; // 判断小数部分是否为整数
               }

               if(isNum && index < str.length &&(str[index]=='e' || str[index]=='E')){
                   index++;
                   isNum = isInteger(str);
               }
               res = isNum && (index==str.length);
            }
            return res;
        }



    public static boolean isUnsignedNum(char[] str){
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index>start;
    }

    public static boolean isInteger(char[] str){
        if(index < str.length && (str[index]=='+' || str[index]=='-')){
            index++;
        }
        return isUnsignedNum(str);
    }

}
