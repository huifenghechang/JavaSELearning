package pers.javaSE.algorithm.leetcode;

import java.util.Arrays;

public class T14 {
    // 查找字符串或者字符在字符中第一次出现的位置的索引。
    // 如果不存在，则返回 -1；
    public static void main(String[] args){
        String[] strings = new String[4];
        strings[0] = "abf";
        strings[1] = "abcd";
        strings[2] = "abcdef";
        strings[3] = "abefg";
        Arrays.sort(strings);
        for(int i=0;i<strings.length;i++){
            System.out.println(strings[i]);
        }
    }
}
