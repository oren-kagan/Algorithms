import java.util.Arrays;
import java.util.Scanner;

public class NotFibonacci {
    public static void main(String[] args) {
        int reply = 0;
        long replyLong = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to NotFibonacci! " + "\nPlease input a whole number greater than 1: ");
        while (reply < 1) {
            reply = input.nextInt();
            if (reply < 1) {
                System.out.println("Please try again.");
            }
        }
        long[] arr = new long[reply];
        arr[1] = 1;
        arr = NotFibonacci1(arr);
        System.out.println("Would you like to use the Where in Sequence program? y/n");
        String replyStr = input.next();
        if (replyStr.charAt(0) == 'y') {
            System.out.println("Cool! What number are you looking for?");
            while (replyLong < 1) {
                replyLong = input.nextLong();
                if (reply < 1) {
                    System.out.println("Please try a number greater than 0");
                }
            }
            int answer = WhereIs(replyLong, arr);
            if (arr[answer] != replyLong) {
                System.out.println("The number " + replyLong
                        + " is not in the NotFibonacci sequence. Therefore the closest lower number is " + arr[answer]
                        + " which is the " + (answer + 1) + "th number in the NotFibonacci sequence.");
            } else {
                System.out.println("The number " + replyLong + " is the " + (answer + 1)
                        + "th number in the NotFibonacci sequence");
            }
        }
        System.out.println(Arrays.toString(arr));
        input.close();
    }

    //	0, 1, 2, 7, 20, 61, 182
    public static long[] NotFibonacci1(long[] array) {
        if (array.length > 2) {
            for (int j = 2; j < array.length; j++) {
                array[j] = ((3 * array[j - 2]) + (2 * array[j - 1]));
            }
        }
        return array;
    }

    public static int WhereIs(long input, long[] array) {
        int i;
        for (i = 0; i <= (array.length - 1); i++) {
            if (array[i] == input) {
                return i;
            }
            if (i == array.length - 1) {
                i = 0;
                input -= 1;
            }
        }
        return i;
    }

}
