package pers.javaSE.algorithm.pdd;

import java.util.*;

public class Main3 {
    public static void main(String[] args){
        List<Integer> list = getFixedNumList(3);
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int res = 0;
        // 循环计算代价
        for(int i=0; i<list.size();i++){
            // 从倒数第二个数字开始计算
            if(i>0){
                res += Math.abs(list.get(i)-list.get(i-1));
            }
        }
        System.out.println(res);
    }

    public static int[] getFixedNums(int n){
        int[] res = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++)
            res[i]= sc.nextInt();
        return res;
    }

    public static List<Integer> getFixedNumList(int n){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++)
            list.add(sc.nextInt());
        return list;
    }
}
