package pers.javaSE.mianshi;

import java.util.HashMap;

public class JianShenZi {

    public static void main(String[] args){
      int[] nums = new int[]{-1,0,1,2,3};
      for(int i=0;i<nums.length;i++){
          if(nums[i]==1){
              continue;
          }
          System.out.println(nums[i]);
      }

    }

    public int getMaxValue(int length){
        if(length < 2){
            return length;
        }
        if (length==2)
            return 1;
        if(length == 3)
            return 2;

        int[] dp = new int[length+1];
        dp[0]=0;dp[1]=1;
        dp[2]=2;dp[3]=3;
        int max = 0;
        for (int i=4;i<length;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){
                int product = dp[j]*dp[i-j];
                max = max > product? max:product;
                dp[j] = Math.max(product,max);
            }
        }
        max = dp[length];
        return max;
    }
}
