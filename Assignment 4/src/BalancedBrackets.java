import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {

    public static void main(String[] args){
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    static String isBalanced(String s){
        Deque<Character> deque = new LinkedList<>();
        char temp = ' ';
        if (s == null || ((s.length() % 2)!= 0)){
            return "NO";
        } else{
            char[] ch = s.toCharArray();
            for (char c: ch){
                if (c == '{' || c == '[' || c == '('){
                    deque.add(c);
                } else{
                    if (deque.size() != 0){
                        temp = deque.peek();
                        if ((temp == '{' & c == '}') || (temp == '[' & c == ']') || (temp == '(' & c == ')')){
                            deque.remove();
                        }
                    }else{
                        return "NO";
                    }
                }
                }
            }
        return "YES";
    }
}
