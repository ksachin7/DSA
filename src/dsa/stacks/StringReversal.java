package dsa.stacks;
import java.util.Stack;
//
//public class StringReversal {
//    public static StringBuffer reverse(StringBuffer str) {
//        int strlen = str.length();
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < strlen; i++) {
//            char ch = str.charAt(i);
//            stack.push(ch);
//        }
//
//        for (int i = 0; i < strlen; i++) {
//            char ch = stack.pop();
//            str.setCharAt(i, ch);
//        }
//        return str;
//    }
//
//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("a b c d");
//        System.out.println(reverse(sb));
//    }
//}
//

import java.util.Stack;

public class StringReversal {
    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}

/*
    When concatenating or modifying strings frequently, using StringBuilder is more efficient than using String.
    StringBuilder uses a dynamic array to store characters, which can be resized as needed.
    On the other hand, each time you modify a String(Immutable), a new String object is created,
    leading to potentially inefficient memory usage and performance degradation.
 */