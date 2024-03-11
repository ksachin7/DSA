package dsa.stacks;
import java.util.EmptyStackException;

public class StaticArrayStack {

    private static class IntStack {
        private int top = -1;
        private int[] data;
        private int capacity;

        public IntStack(){
            capacity = 10;
            data= new int[capacity];
        }

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

        // check first if Stack(arr) is full
        void push(int e) throws Exception {
            if(!isFull())
                data[++top] = e;
            else
                throw new Exception("Can't push! Stack is full already.");
        }

        // check if Stack is empty? if so throw EmptyStackException
        // make current top 0, decrement top and return top element
        int pop(){
            if (isEmpty())
                throw new EmptyStackException();
            int newTop = data[top-1];   // doing --top will decrease top too!
            data[top] = 0;
            top--;
            return newTop;
        }

        // return top element
        int peek(){
            if (isEmpty())
                throw new EmptyStackException();
            return data[top-1];
        }

        // print stack while i == top
        void printStack(){
            int i = top;
            System.out.println("+--+");
            while(i != -1){
                    System.out.printf("%2d \n",data[i]);
                i--;
            }
            System.out.println("+--+");
        }
    }
    public static void main(String[] args) throws Exception {
        StaticArrayStack.IntStack istack= new StaticArrayStack.IntStack();
        System.out.println("Checking if array is empty: "+istack.isEmpty());
        System.out.println("Checking if array is full: "+istack.isFull());
        istack.push(5);
        istack.push(7);
        istack.push(9);
        istack.push(0);
        istack.push(1);
        istack.push(2);
        istack.push(4);
        istack.push(4);
//        istack.push('c');
//        istack.push(6);
        istack.push(6);
        istack.printStack();

        istack.pop();
        istack.printStack();
        System.out.println("Size of the Stack: "+istack.size());
        System.out.println("Peek: "+istack.peek());
    }
}
