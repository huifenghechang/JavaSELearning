package pers.javaSE.algorithm.pdd;

public class Algorithm {

    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            if(array == null || array.length == 1){
                return 0;
            }
            int result = 0;
            int left = 0;
            int right = array.length-1;

            int mid = (left + right)/2;
            // 确保是在旋转数列的两部分
            while(array[left] >= array[right]){
                if(array[left] == array[mid] && array[mid]==array[right]){
                    result= getMinNumberInSort(array);
                    break;
                }
                if(right - left == 1){
                    result=array[left];
                    break;
                }
                if(array[mid] <= array[left])
                    right = mid;
                if(array[mid] >= array[left])
                    left = mid;
                mid = (left+right)/2;
            }
            return result;
        }

        public int getMinNumberInSort(int[] array){
            int num = array[0];
            for(int i=1;i<array.length;i++)
                num = array[i] < num?array[i]:num;
            return num;
        }
    }
}
