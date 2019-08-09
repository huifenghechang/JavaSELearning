package pers.javaSE.algorithm.alibaba;

public class QuickSortAlgorithm {

    // 快速随机排序的实现
    public static void quickRandomSort(int[] arr) {

        if(arr == null || arr.length <2){
            return ;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        swap(arr,left+(int)Math.random()*(right-left+1),right);
        int[] p = partition(arr,left,right);
        quickSort(arr,left,p[0]-1);
        quickSort(arr,p[1]+1,right);
    }

    public static int[] partition(int[] arr,int left,int right){
        int less = left-1;
        int more = right;// 此处，right的值选作为枢轴
        int cur = left;
        // 将right的值作为枢轴，故，right肯定为枢轴值！！！
        while (cur < more){
            if (arr[cur] < arr[right])
                swap(arr,++less,cur++);
            else if(arr[cur] > arr[right])
                swap(arr,--more,cur);
            else
                cur++;
        }
        // 此时，枢轴值的下标在more的前一位。最终more指向的大于区域的第一个数。它的前一个数，肯定是枢轴值的下标
        swap(arr,more,right);
        // 返回的是等于区间的范围
        return new int[]{less+1,more};

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {9,0,1,3,4,2,9,5,7,12,6};
        System.out.print("The origin is:");
        printArray(arr);
        quickRandomSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);



    }




}
