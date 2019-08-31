package pers.javaSE.algorithm.base.sortAlgotitm;

import static pers.javaSE.algorithm.base.ScannerLearn.printArray;

public class C06_MergeSort2_0831 {
    public static void main(String[] args) {
        int[] arr = {9, 0, 1, 3, 4, 2, 5, 7, 12, 6};
        System.out.print("The origin is:");
        printArray(arr);
        int[] res = mergeSort(arr, 0, arr.length - 1);
        System.out.print("The sorted is:");
        printArray(res);
    }

    public static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = (start + end) / 2;
        int[] leftArr = mergeSort(nums, start, mid);
        int[] rightArr = mergeSort(nums, mid + 1, end);

        // 对左右数组进行合并
        int[] help = new int[leftArr.length + rightArr.length];
        int i = 0, p1 = 0, p2 = 0;

        while (p1 < leftArr.length && p2 < rightArr.length) {
            help[i++] = leftArr[p1] < rightArr[p2] ? leftArr[p1++] : rightArr[p2++];
        }

        while (p1 < leftArr.length) {
            help[i++] = leftArr[p1++];
        }

        while (p2 < rightArr.length) {
            help[i++] = rightArr[p2++];
        }
        return help;
    }

}

