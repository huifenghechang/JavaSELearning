package pers.javaSE.algorithm.offer;

public class T14 {
    // 使用动态规划求解的基本步骤,一般前面的小问题，动态规划公式不适合
    public int maxProductAfterCutting_solution(int length){
        //
        if(length <= 1)
            throw new IllegalArgumentException("The length is illegal");
        if (length == 2)
            return 1;
        if(length == 3)
            return 2;
        int[] maxV = new int[length+1];
        maxV[1] = 1;
        maxV[2] = 2;
        maxV[3] = 3;

        for (int n=4;n<=length;n++){
            int max=0;
            for(int i=1;i<=n/2;i++){
                int f = maxV[i]*maxV[n-i];
                if ( f> max)
                    max = f;
            }
            maxV[n] = max;
        }
        return maxV[length];
    }
}
