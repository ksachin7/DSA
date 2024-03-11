package dsa.array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LatestArray<T> {
    private T[] array;
    private int size;

    // Constructor to initialize the array with a given size
    @SuppressWarnings("unchecked")
    public LatestArray(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    // Get the current size of the array
    public int size() {
        return size;
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get an element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return array[index];
    }

    // Set an element at a specific index
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        array[index] = value;
    }

    // Insert an element at the end of the array
    public void add(T value) {
        if (size == array.length) {
            // Resize the array if it is full
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = value;
        size++;
    }

    // Insert an element at a specific index
    /** Note: Shifting elements from the right side is a common approach when inserting an element into an array because it helps ensure that existing elements are not overwritten or lost during the insertion process.
     */
    public void insert(int index, T value) {
        if (size == array.length) {
            // Resize the array if it is full
            array = Arrays.copyOf(array, size * 2);
        }

        // Shift elements to the right to make space for the new element
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

//        for (int i = index; i <= size-1; i++) {   // very incorrect way it will cause elements to be overwritten,
//            array[i+1]= array[i];
//        }

        array[index] = value;
        size++;
    }

    // Remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        // Shift elements to the left to fill the gap left by the removed element
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // Set the last element to null or a default value (optional)
        array[size - 1] = null;  // Optional, but recommended for memory management

        size--;
    }

    // Display the array elements
    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    // Reverse the array elements in place using streams
    public void reverse() {
        array = IntStream.range(0, size)
                .mapToObj(i -> array[size - 1 - i])
                .toArray(size -> Arrays.copyOf(array, size));
    }

    // Sort the array elements in ascending order using streams
    public void sort() {
        array = Arrays.stream(array, 0, size)
                .sorted()
                .toArray(size -> Arrays.copyOf(array, size));
    }

    /*
    // Helper method to create a new array of the same type as T
    @SuppressWarnings("unchecked")
    private T[] createArray(int length) {
        return (T[]) new Object[length];
    }

    // Reverse the array elements in place using streams and method reference
    public void reverse() {
        array = IntStream.range(0, size)
                .mapToObj(i -> array[size - 1 - i])
                .toArray(this::createArray);
    }

    // Sort the array elements in ascending order using streams and method reference
    public void sort() {
        array = Arrays.stream(array, 0, size)
                .sorted()
                .toArray(this::createArray);
    }
    */

    public static void main(String[] args) {
        LatestArray<Integer> array = new LatestArray<>(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.insert(1, 15);
        array.display(); // Output: [ 10, 15, 20, 30 ]

        array.reverse();
        array.display(); // Output: [ 30, 20, 15, 10 ]

        array.sort();
        array.display(); // Output: [ 10, 15, 20, 30 ]

        LatestArray<String> stringArray = new LatestArray<>(5);
        stringArray.add("banana");
        stringArray.add("apple");
        stringArray.add("orange");
        stringArray.insert(1, "grape");
        stringArray.display(); // Output: [ banana, grape, apple, orange ]

        stringArray.reverse();
        stringArray.display(); // Output: [ orange, apple, grape, banana ]

        stringArray.sort();
        stringArray.display(); // Output: [ apple, banana, grape, orange ]
    }

}
