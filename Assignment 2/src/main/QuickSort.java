package main;

public class QuickSort implements SortingAlgorithm{

    @Override
    public int[] sorty(int[] arr) {
        quickSort(arr, 0, arr.length -1);
        return arr;
    }

    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            int index = partition(arr, start, end);
            quickSort(arr, start, index -1);
            quickSort(arr, index+1, end);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
