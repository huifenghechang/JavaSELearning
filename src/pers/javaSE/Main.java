package pers.javaSE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    protected static HashMap<String,String> map = new HashMap<>();
    public static void main(String[] args){
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }



        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits.length()!=0){
                backTrace("",digits);
            }
            return res;
        }

        public void backTrace(String combation,String digits){
            if(digits.length()==0){
                res.add(combation);
            }else{
                String digit = digits.substring(0,1);
                String letters = map.get(digit);
                for(int i=0;i<letters.length();i++){
                    String letter = letters.substring(i,i+1);
                    backTrace(combation+letter,digits.substring(1));
                }
            }

        }

}
