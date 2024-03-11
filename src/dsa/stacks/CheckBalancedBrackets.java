// Balancing parenthesis: Number of opening and closing brackets should be same.
package dsa.stacks;
import java.util.Stack;

public class CheckBalancedBrackets {
    String expression= "[a* (b-[e*{f/8}])]";

    Stack<Character> stack= new Stack<>();

    void checkBrackets(){
        int i=0;
        for(; i<expression.length(); i++){
            char ch= expression.charAt(i);
            int flag=0;
            switch (ch) {
                case '(', '{', '[' -> {
                    System.out.println("Pushed " + ch);
                    stack.push(ch);
                }
                case ')', '}', ']' -> {
                    char peek = stack.peek();
                    if ((peek == '(' && ch == ')') || (peek == '{' && ch == '}') || (peek == '[' && ch == ']'))
                        stack.pop();
                    else
                        flag = 1;
                }
                default -> System.out.println("Ignored char: " + ch);
            }
            if (flag==1)
                break;
//            for (int j=stack.size()-1; j>=0; j--) {
//                System.out.printf("| %2c  |\n", stack.get(j));
//            }
        }
        if (i == expression.length() && stack.empty())
            System.out.println("Brackets are balanced!");
        else
            System.out.println("Not Balanced!");
    }
    public static void main(String[] args) {
        CheckBalancedBrackets cb = new CheckBalancedBrackets();
        cb.checkBrackets();
    }
}

