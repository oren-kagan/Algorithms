import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//            ArrayList<String> input = new ArrayList<String>();
//            input.add("gojo");
//            input.add("google");
//            input.add("jogo");
//            input.add("bill");
//            input.add("pup");
//            input.add("cipher");
//            input.add("watchmen");
//            input.add("knight");
//            input.add("it");
//            input.add("stand");
//            input.add("sandman");
//            input.add("hydra");
//            input.add("surtr");
//            RadixSort O = new RadixSort();
//            input = O.radixSort(input);
//            System.out.println(input.toString());
        subInteger SI = new subInteger();
        int[] S1 = {32, 3};
        int[] T1 = {1, 2, 3, 52, 32, 54};
        System.out.println(SI.subIntegerDecider(S1, T1));
        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};
        System.out.println(SI.subIntegerDecider(S2, T2));
        int[] S3 = {0, 67};
        int[] T3 = {100, 5, 66, 2, 32, 90};
        System.out.println(SI.subIntegerDecider(S3, T3));
        int[] S4 = {};
        int[] T4 = {54, 32, 99};
        System.out.println(SI.subIntegerDecider(S4, T4));
        }
}