package pers.javaSE.algorithm.helloBike;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] letter = line.toCharArray();
        int i,j;
        for(i=1;i<letter.length;i++){
            j=i;
            if('a'<=letter[i] && letter[i] <='z'){
                while (j!=0 && letter[j-1]>='A' && letter[j-1] <='Z' ){
                    swap(letter,j-1,i);
                }
            }
        }
        for(int k=0;k<letter.length;k++){
            System.out.print(letter[k]);
        }
    }


    public static void swap(char[] letter,int i,int j){
        char temp = letter[i];
        letter[i] = letter [j];
        letter[j] = temp;
    }

}


