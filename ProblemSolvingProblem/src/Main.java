import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[] arr = {1,2,3,7,5};
        System.out.println("When input is 12: " + Arrays.toString(subArraySum(arr, 12)));
        System.out.println("When input is 5: " + Arrays.toString(subArraySum(arr, 5)));
        System.out.println("When input is 7: " + Arrays.toString(subArraySum(arr, 7)));
        System.out.println("When input is 11: " + Arrays.toString(subArraySum(arr, 11)));
    }
    public static int[] subArraySum(int[] A, int K) {
        int tempSum = A[0];
        int[] indices = {-1, -1};
        int firstIndex = 0;
        for(int i = 1; i <= A.length; i++){
            while ((tempSum > K) && (firstIndex < i -1)){
                tempSum = tempSum - A[firstIndex];
                System.out.println(i);
                firstIndex++;
            }
            if (tempSum == K){
                indices[0] = firstIndex;
                indices[1] = i-1;
                return indices;
            }
            if (i < A.length){
                tempSum += A[i];
            }
        }
    return indices;
    }
}