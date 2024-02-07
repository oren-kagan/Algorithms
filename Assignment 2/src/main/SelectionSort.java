package main;

public class SelectionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] arr){
        int n = arr.length;
        int k,temp;
        for (int i = 0;i < n -1; i++){
            k = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[k]){
                    k = j;
                }
            }
            temp = arr[i];
            arr [i] = arr[k];
            arr[k] = temp;
        }
        return arr;
    }
}
