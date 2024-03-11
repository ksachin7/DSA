package dsa.array;
public class Array {
    private int[] array;
    private int size;

    // Constructor to initialize the array with a given size
    public Array(int capacity) {
        array = new int[capacity];
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
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return array[index];
    }

    // Set an element at a specific index
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        array[index] = value;
    }

    // Insert an element at the end of the array
    public void add(int value) {
        if (size == array.length) {
            // Resize the array if it is full
            int[] newArray = new int[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    // Insert an element at a specific index
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        if (size == array.length) {
            // Resize the array if it is full
            int[] newArray = new int[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        // Shift elements to the right to make space for the new element
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

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

        size--;
    }

    // Reverse the array elements in place
    public void reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // Sort the array elements in ascending order using insertion sort
    public void sort() {
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
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

    public static void main(String[] args) {
        Array array = new Array(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.insert(1, 15);
        array.display(); // Output: [ 10, 15, 20, 30 ]
        array.remove(2);
        array.display(); // Output: [ 10, 15, 30 ]

        array.add(10);
        array.add(20);
        array.add(30);
        array.insert(1, 15);
        array.display(); // Output: [ 10, 15, 20, 30 ]

        array.reverse();
        array.display(); // Output: [ 30, 20, 15, 10 ]

        array.sort();
        array.display(); // Output: [ 10, 15, 20, 30 ]

        System.out.println(array.get(3));
        array.set(3, 5);
        array.display();
    }
}
