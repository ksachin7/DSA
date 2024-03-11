package dsa.stacks;
import java.util.Stack;
public class InfixToPostfix {
    Stack<Character> st = new Stack<>();
    String exp= "[a*b[{(}]";
//    String exp= "2+34*5";
//    char[] postFix = new char[10];
    String postFix;
    int checkPrecedence(char ch){
        int p= 0;
            if (ch =='^')
                p = 3;
            else if (ch == '*' || ch=='/')
                p = 3;
            else if (ch == '+' || ch =='-')
                p = 2;
            else
                p = -1;
        return p;
    }

    void infixToPostfix(){
        for (int i = 0; i <exp.length() ; i++) {
            char ch= exp.charAt(i);
            switch(ch){
                case '(', '{', '['-> {
                    st.push(ch);
                }
                case '*', '+', '-', '/' -> {
                    while (!st.isEmpty() && checkPrecedence(ch) < checkPrecedence(st.peek())) {
                        postFix += st.pop();
                        st.push(ch);
                    }
                }
                case ')', '}', ']'->{
                    postFix += st.pop();
                    st.pop();
                }
                default -> {
                    postFix += ch;
                }
            }

//            while(st.peek()!= ch)
//                postFix += st.pop();
//            st.pop();
        }
//        return ;

        System.out.println(postFix);
    }

    public static void main(String[] args) {
        InfixToPostfix itp = new InfixToPostfix();
        itp.infixToPostfix();
    }
}
