package main;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

class Tester {
    SortingAlgorithm sa;


    Tester(SortingAlgorithm sa){
        this.sa = sa;
    }
    public SortingAlgorithm getSa(SortingAlgorithm sa){
        return this.sa;
    }

    double SingleTest(int Size){
        int k = 10;
        int[] array = new int[Size];
        Random randNum = new Random();
        for (int i = 0; i < Size; i++){
            array[i] = randNum.nextInt();
        }
        k_sort(array, k);
        double start = System.currentTimeMillis();
        int[] output = sa.sorty(array);
        return System.currentTimeMillis() - start;
    }


    void test(int iterations, int size) throws IOException {
        double totalTime = 0;
        for(int i = 0; i < iterations; i++){
            totalTime += SingleTest(size);
        }
        double avgTime = totalTime/iterations;
        System.out.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
        Main.writeTo("Sorted " + size + " elements in " + avgTime + " ms (avg)");
    }

    void k_sort ( int[] arr, int k){
        int n = arr.length;
        int diff = k;
            for (int i = diff; i < n; i++){
                int temp = arr[i];
                int j;
                for (j = i; j >= diff && arr[j-diff] > temp; j -= diff){
                    arr[j] = arr[j - diff];
                }
                arr[j] = temp;
            }
        }
    }
