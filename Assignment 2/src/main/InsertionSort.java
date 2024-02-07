package main;

import java.lang.reflect.Array;

public class InsertionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] array) {
        int n = array.length;
        int i, j, k;
        for (i = 0; i < n; ++i) {
            k = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > k) {
                array[j + 1] = array[j];
                j--;
            }
        }
        return array;
    }
}

