import java.util.Stack;

import static java.lang.System.*;

public class BalancedBrackets {
    public static void main(String[] args){
        String s1 = "{[()]}";
        String s2 = "{[(])}";
        String s3 = "{{[[(())]]}}";
        out.println("BalancedBrackets.java");
        out.println("Sample Input: " + s1 + " Is it balanced? " + isBalanced(s1));
        out.println("Sample Input: " + s2 + " Is it balanced? " + isBalanced(s2));
        out.println("Sample Input: " + s3 + " Is it balanced? " + isBalanced(s3));
    }
    private static String isBalanced(String s){
        if (s.isEmpty()){
            return "YES";
        }
        char bracket;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if((bracket == ')' || (bracket == ']') || (bracket == '}'))){
                if(stack.isEmpty()){
                    return "NO";
                }
                char temp = stack.peek();
                if (bracket == ')' && temp == '(' || bracket == ']' && temp == '[' || bracket == '}' && temp == '{'){
                    stack.pop();
                }
                else{
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()){
            return "YES";
        }
        return "NO";
    }
}
