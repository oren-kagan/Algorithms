import java.util.Scanner;

public class CommonSubs {

    public static void main(String[] args) {
        String outputStr = "";
        int outputInt = 0;
        int size = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("text1 = ");
        String text1 = input.nextLine();
        System.out.print("text2 = ");
        String text2 = input.nextLine();
        input.close();
        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 <= length2) {
            size = length1;
        } else {
            size = length2;
        }
        for (int j = 0; j < size; j++) {
            if (text1.charAt(j) == text2.charAt(j)) {
                outputInt++;
                outputStr += text1.charAt(j);
            }
        }
        if (outputInt > 0) {
            System.out.println("Explanation: The longest common subsequence is '" + outputStr + "' and its length is " + outputInt + ".");
        } else {
            System.out.println("There is no such common subsequence, so the result is 0.");
        }
    }
    }