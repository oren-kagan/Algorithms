import java.util.ArrayList;
import java.util.HashMap;

public class subInteger {

    subInteger() {
    }

    public static subInteger createsubInteger() {
        return new subInteger();
    }

    public String subIntegerDecider(int[] S, int[] T){
        if (S.length > T.length) return "No";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: T){
            map.put(num, 1);
        }
        for (int nums: S){
            if (!map.containsKey(nums)) return "No";
        }
        return "Yes";
    }
}
