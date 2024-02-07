package main;

public class BubbleSort implements SortingAlgorithm{
   @Override
    public int[] sorty(int[] input){
        int n = input.length;
        int i,j;
        for (i = 0; i < n - 1; ++i) {
            for (j = 0; j < n - i -1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }
}
