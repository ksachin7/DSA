package dsa.queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class CollectionQueue {

    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<>();
        System.out.println(q.peek());

        q.offer(7); // Inserts the specified element into the queue. If the task is successful, offer() returns true, if not it returns false.
        q.add(5);       // Inserts the specified element into the queue. If the task is successful, add() returns true, if not it throws an exception.
        System.out.println(q);

        // Returns the head of the queue. Returns null if the queue is empty.
        System.out.println("Printing peek: "+q.peek());
        //  Returns the head of the queue. Throws an exception if the queue is empty.
        System.out.println("Printing peek with element(): "+q.element());

        q.remove();     // Returns and removes the head of the queue. Throws an exception if the queue is empty.
        q.poll();       // Returns and removes the head of the queue. Returns null if the queue is empty.
        System.out.println(q);
    }
}

// Priority Queue
class PQ {

    public static void main(String[] args) {
        // Creating Queue using the PriorityQueue class
        Queue<Integer> numbers = new PriorityQueue<>();

        // offer elements to the Queue
        numbers.offer(5);
        numbers.offer(1);
        numbers.offer(2);
        System.out.println("Queue: " + numbers);

        // Access elements of the Queue
        int accessedNumber = numbers.peek();
        System.out.println("Accessed Element: " + accessedNumber);

        // Remove elements from the Queue
        int removedNumber = numbers.poll();
        System.out.println("Removed Element: " + removedNumber);

        System.out.println("Updated Queue: " + numbers);
    }
}

//    How to use Queue?

//     LinkedList implementation of Queue
//    Queue<String> animal1 = new LinkedList<>();

//     Array implementation of Queue
//    Queue<String> animal2 = new ArrayDeque<>();

//    Priority Queue implementation of Queue
//    Queue<String> animal3 = new PriorityQueue<>();