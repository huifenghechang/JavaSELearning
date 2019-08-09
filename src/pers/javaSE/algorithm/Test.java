package pers.javaSE.algorithm;

public class Test {
    public static void main(String[] args){
        for(int i=0;i<8;i++){
            if((i&1)==0){
                continue; // 该关键字的作用是，返回循环入口。不执行后面的语句
            }
            System.out.println(i);
        }
    }
}
