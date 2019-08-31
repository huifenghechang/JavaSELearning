package pers.javaSE.mianshi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntegerDivide {
    public static void  main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        mdivideN(42,2,list,1);
    }

    // 表示对m进行拆分。
    public static void mdivideN(int m, int n, List<Integer> list,int start){
        if(m==0 && n==0)
            print(list);
        if(m<0 || n<0)
            return;
        if(m>0 && n>0){
            for (int i= start;i<=m/n;i++){
                list.add(i);
                mdivideN(m-i,n-1,list,i+1);
                list.remove(list.size()-1);// 此处回溯法，对比查找和为N的路径
            }
        }
    }

    public static void print(List<Integer> list){
        for(Integer k :list)
            System.out.printf("%d,",k);
        System.out.println();
    }
}
