package main;

import java.io.IOException;

public class Performance {

    final static SortingAlgorithm BS = new BubbleSort();
    final static Tester BSTest = new Tester(BS);
    final static SortingAlgorithm IS = new InsertionSort();
    final static Tester ISTest = new Tester(IS);
    final static SortingAlgorithm MS = new MergeSort();
    final static Tester MSTest = new Tester(MS);
    final static SortingAlgorithm QS = new QuickSort();
    final static Tester QSTest = new Tester(QS);
    final static SortingAlgorithm SS = new SelectionSort();
    final static Tester SSTest = new Tester(SS);
    final static SortingAlgorithm HS = new ShellSort();
    final static Tester HSTest = new Tester(HS);

    final static SortingAlgorithm[] SA_arr = {HS, QS, MS, IS, SS, BS};
    final static Tester[] TESTERS = {HSTest, QSTest, MSTest, ISTest, SSTest, BSTest};

    final static int[] Sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

    /**
     * @throws IOException
     */
    public static void main() throws IOException {
        for(int j = 0; j< TESTERS.length; j++) {
            System.out.println("Sorting Algorithm - " + SA_arr[j].getClass().getSimpleName());
            Main.writeTo("Sorting Algorithm - " + SA_arr[j].getClass().getSimpleName());
            for (int size : Sizes) {
                TESTERS[j].test(20, size);
            }
        }
    }
}
