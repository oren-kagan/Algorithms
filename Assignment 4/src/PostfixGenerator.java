import java.util.Stack;
import static java.lang.System.*;
public class PostfixGenerator {
    public static void main(String[] args){
        String s1 = "a+b*(c^d-e)^(f+g*h)-i";
        String s2 = "(a + b) * (c - d)";
        String s3 = "(A*(B^C)+(C-E))/A";
        out.println("PostfixGenerator.java");
        out.println("Sample Input: " + s1 + " Postfix: " + infixToPostfix(s1));
        out.println("Sample Input: " + s2 + " Postfix: " + infixToPostfix(s2));
        out.println("Sample Input: " + s3 + " Postfix: " + infixToPostfix(s3));
    }
    private static boolean isOperand(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    private static String infixToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> s = new Stack<>();
        char temp;
        for (int i = 0; i < infix.length(); i++){
            temp = infix.charAt(i);
            if (temp == ' '){
                temp = infix.charAt(++i);
            }
            if(isOperand(temp)){
                postfix.append(temp);
            }else if (temp == '('){
                s.push(temp);
            } else if (temp == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    postfix.append(s.pop());
                }
                s.pop();
            } else {
                while (!s.isEmpty() && (precedence(temp) <= precedence(s.peek()))){
                    postfix.append(s.pop());
                }
                s.push(temp);
            }
        }
        while(!s.isEmpty()) postfix.append(s.pop());
        return postfix.toString();
    }
    private static int precedence(char c){
        return switch (c) {
            case '^' -> 2;
            case '*', '/' -> 1;
            case '+', '-' -> 0;
            default -> -1;
        };
    }
}
