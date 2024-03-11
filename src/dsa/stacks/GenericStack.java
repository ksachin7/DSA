package dsa.stacks;

import java.util.Arrays;

public class GenericStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public GenericStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Pushes an item onto the top of the stack.
    public void push(T item) {
        ensureCapacity();
        array[size++] = item;
    }

    // Removes and returns the top item from the stack.
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop an element.");
        }
        System.out.println("size: "+ size);
        @SuppressWarnings("unchecked")
        T poppedItem = (T) array[--size];
        System.out.println("size: "+ size);

        array[size] = null; // Clear the reference to the popped item to avoid memory leaks
        return poppedItem;
    }

    // Returns the top item of the stack without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek an element.");
        }

        @SuppressWarnings("unchecked")
        T topElement = (T) array[size - 1];
        return topElement;
    }

    // Checks if the stack is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of elements in the stack.
    public int size() {
        return size;
    }

    // Ensures that the array has enough capacity to hold more items.
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    // Print the stack in the specified stack format
    public void printStack() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println("   +-----+");
            System.out.println("   |  " + array[i] + "  |");
        }
        System.out.println("   +-----+");
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

//        System.out.println("Top element: " + stack.peek());
//        stack.printStack();

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        stack.printStack();
    }
}
