package pers.javaSE.algorithm.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        receiveDataFromKey(listA);
        receiveDataFromKey(listB);

        // 找出A数组中的数
        int numAIndex = findNumberA(listA);
        if(numAIndex == -1){
            System.out.println("NO");
            return;
        }

        // 此处，应该判断是否越界！！！
        int small = -1;
        int big = -1;
        if (numAIndex-1 >=0){
            small = listA.get(numAIndex-1);
            big = listA.get(numAIndex+1);
        }
        // 找出B数组中的数
        Collections.sort(listB);
        int numB = findNumberB(listB,small,big);
        listA.set(numAIndex,numB);
        if (numB ==-1){
            System.out.println("NO");
            return;
        }
        for (int i=0;i<listA.size();i++){
            System.out.print(listA.get(i));
        }
    }

    //从数组B中匹配最合适的数字
    static int findNumberB(List<Integer> listB,int small,int big){
        int maxNum = -1;
        for (int i=0;i<listB.size();i++){
            if(listB.get(i) > small && listB.get(i)<big){
                if (maxNum < listB.get(i))
                    maxNum = listB.get(i);
            }
        }
        return maxNum;
    }

    // 返回数组A的下标
    static int findNumberA(List<Integer> listA){
        int numIndex = -1;
        for (int i=1;i<listA.size();i++){
            // 因为是大致升序的，所以后面的数，应该比前面的数大！
            // 如果不满足此条件，则是需要改变的数
            if(listA.get(i)<listA.get(i-1)){
                numIndex = i;
                break;
            }
        }
        return numIndex;
    }


     static void receiveDataFromKey(List<Integer> list){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner in2 = new Scanner(line);
        // 输入数组A
        while(in2.hasNextInt()){
            list.add(in2.nextInt());
        }
    }
}
