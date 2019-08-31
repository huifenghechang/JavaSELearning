package pers.javaSE.algorithm.base.sortAlgotitm;

public class HeapSortAlgorithm {

    public static void heapSort(int[] arr) {

        if(arr == null || arr.length <2){
            return ;
        }

        // 遍历数字，建立大根堆
        for(int i=0; i< arr.length;i++)
            heapInsert(arr,i);
        // 逐步弹出堆顶
        // 弹出堆顶的基本操作：
          // 将大根堆的堆顶和堆的中的最后一位交换，堆顶长度减一
        int heapSize = arr.length;
        swap(arr,0,--heapSize); //长度为heapSize的堆，其最后一个数的下标为heapSize -1;

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);//  调整大根堆
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index-1)/2;
        }
    }

    // 堆顶被换成了一个新的数字，将长度为heapSize的堆，调整为大根堆
    public static void heapify(int[] arr,int index,int heapSize){
        // index为需要调整的节点
        int left = 2*index+1;
        // 通过left 小于heapSize,来保证为叶节点
        while (left < heapSize){
            int largest = left+1 <heapSize && arr[left+1]>arr[left]?left+1:left;
            // 判断新换的数和左右孩子中的哪一个大？
            largest = arr[largest] > arr[index]?largest:index;
            if(largest==index)
                break;
            swap(arr,largest,index);
            index = largest;
            left = 2*index+1; // 求出新的被置换的堆顶元素的左孩子。
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
    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5};
        System.out.print("The origin is:");
        printArray(arr);
        heapSort(arr);
        System.out.print("The sorted is:");
        printArray(arr);



    }
}
