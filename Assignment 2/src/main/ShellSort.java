package main;

public class ShellSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] arr){
        int n = arr.length;
        for (int diff = n/2; diff > 0; diff /= 2){
            for (int i = diff; i < n; i++){
                int temp = arr[i];
                int j;
                for (j = i; j >= diff && arr[j-diff] > temp; j -= diff){
                    arr[j] = arr[j - diff];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }
}
