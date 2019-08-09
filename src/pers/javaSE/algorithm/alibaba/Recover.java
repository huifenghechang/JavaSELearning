package pers.javaSE.algorithm.alibaba;

public class Recover {

    public void heapSort(int[] arr){
        if(arr==null || arr.length <2){
            return;
        }
        // 首先，调整为大根堆
        for(int i=0; i<arr.length;i++){
            heapInsert(arr,i);
        }
        // 依次弹出栈
        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while (heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }

    public void heapInsert(int[] array,int index){
        while (array[index] > array[(index-1)/2]){
            swap(array,index,(index-1)/2);
            index = (index-1)/2;
        }

    }

    // 将堆顶元素置换后，调整为大根堆的过程.调整大根堆，是一个循环操作
    public void heapify(int[] arr,int index,int heapSize){
        int left = 2*index +1;
        while (left<heapSize){
            int largest = left+1<heapSize && arr[left+1]>arr[left]?left+1:left;//找到左右孩子的最大值下标
            largest = arr[largest]>arr[index]?largest:index;// 将最大值与当前的堆顶作比较。
            if(largest==index)
                break;
            swap(arr,index,largest);
            index = largest;
            left = 2*index+1;
        }
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
}
