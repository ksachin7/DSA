package dsa.stacks;
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackImplementation {

    static class Stack {
        private int top = -1;
        private Object[] data;
        private int capacity;

        public Stack(){
            capacity = 10;
            data= new Object[capacity];
        }

        // To increase the capacity of array when it's full.
        private void increaseCapacity(){
            capacity*=2;
            data= Arrays.copyOf(data, capacity);
        }

        //
        int size(){
            return ++top;
        }
        // top will be -1 if Stack would be empty
        boolean isEmpty(){
            return top == -1;
        }

        // top will be length of (arr-1) if Stack would be full
        boolean isFull(){
            return top==data.length-1;
        }

        // Check first if Stack(arr) is full if it is then increase capacity
        // add element to data with increased top.
        void push(Object e) {
            if(isFull())
                increaseCapacity();
            data[++top] = e;
        }

        Object pop(){
            if (isEmpty()){
                throw new RuntimeException("Stack Underflow!");
            }
            Object poppedElement = data[top];
            top--;
            return poppedElement;
        }
        Object peek(){
            if (isEmpty())
                throw new EmptyStackException();
            return data[top];
        }


            public void reverse(StringBuffer str) {
                int strlen = str.length();
                for (int i = 0; i < strlen; i++) {
                    char ch = str.charAt(i);
                    push(ch);
                }
                for (int i = 0; i < strlen; i++) {
                    char ch1 = (char) pop();
                    str.setCharAt(i, ch1);
                }
                System.out.println(str);

            }


            void printStack(){
            System.out.println("----------------------");
            int i = top;
            System.out.println("+--+");
            while(i != -1){
                if (data[i] == null)
                    i--;
                else
                System.out.printf("%2s \n",data[i]);
                i--;
            }
            System.out.println("+--+");
            System.out.println("Peek: "+peek());
            System.out.println("Size of the Stack: "+size());
            System.out.println("----------------------\n");
        }

    }
    public static void main(String[] args) throws Exception {
        Stack stack= new Stack();
        System.out.println("Checking if array is empty: "+stack.isEmpty());
        System.out.println("Checking if array is full: "+stack.isFull());
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(0);
        stack.push(-1);
        stack.push(2.3);
        stack.push(4.1f);
        stack.push("str");
        stack.push('c');
        stack.push(6);
        stack.push(6);
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.printStack();
        StringBuffer sb= new StringBuffer("abcd");
        stack.push(sb.charAt(0));
        stack.push(sb.charAt(1));
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.reverse(sb);
    }
}