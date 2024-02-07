package main;

public class MergeSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] array){
        return mergeSort(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] input, int beg, int end){
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(input, beg, mid);
            mergeSort(input, mid + 1, end);
            merge(input, beg, mid, end);
        }
        return input;
    }

    public static void merge(int[] arr, int b, int m, int e){
        int leftIndex,rightIndex,finIndex;
        int num1 = m-b+1;
        int num2 = e-m;
        int[] leftArr = new int[num1];
        int[] rightArr = new int[num2];
        for (leftIndex = 0; leftIndex<num1;leftIndex++){
            leftArr[leftIndex] = arr[b + leftIndex];
        }
        for (rightIndex = 0;rightIndex<num2;rightIndex++){
            rightArr[rightIndex] = arr[m+1+rightIndex];
        }
        leftIndex = 0;
        rightIndex = 0;
        finIndex = b;
        while (leftIndex < num1 && rightIndex < num2) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[finIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[finIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            finIndex++;
        }
        while(leftIndex < num1){
            arr[finIndex] = leftArr[leftIndex];
            leftIndex++;
            finIndex++;
        }
        while(rightIndex < num2){
            arr[finIndex] = rightArr[rightIndex];
            rightIndex++;
            finIndex++;
        }
    }
}
