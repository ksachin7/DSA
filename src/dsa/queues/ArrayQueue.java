package dsa.queues;

public class ArrayQueue {
    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity){
        data= new Object[capacity];
        front = 0;
        rear = 0;
        size= data.length;
    }

    // Queue will be empty when front == rear
    boolean isEmpty(){
        return front==rear;
    }

    // Queue will be full if
    boolean isFull(){
        return (front+size-rear)%size == 1;
    }

    // in case of deque front will change and so will size of queue
    int size(){
        return rear+size-front;
    }

    // Inserts the specified element into the queue. If the task is successful, add() returns true, if not it throws an exception.
    void add(Object e){
        if (isFull())
            throw new RuntimeException("Can't push! Queue is full.");
        data[rear++]= e;
        rear= adjustIndex(rear, size);
    }

    // Inserts the specified element into the queue. If the task is successful, offer() returns true, if not it returns false.
    boolean offer(int e){
        if (isFull())
            return false;
        data[rear++]= e;
        rear= adjustIndex(rear, size);
        return true;
    }

    // Returns and removes the head of the queue. Returns null if the queue is empty.
    Object poll(){
        if(isEmpty())
            return null;
        front = adjustIndex(front, size);
        return data[front++];
    }

    // Returns and removes the head of the queue. Throws an exception if the queue is empty.
    Object remove(){
        if(isEmpty())
            throw new RuntimeException("Can't pop! Queue is empty.");
        front = adjustIndex(front, size);
        return data[front++];
    }

    //  Returns the head of the queue. Throws an exception if the queue is empty.
    Object element(){
        if (isEmpty())
            throw new RuntimeException("Queue is empty!");
        front = adjustIndex(front, size);
        return data[front];
    }

    // Returns the head of the queue. Returns null if the queue is empty.
    Object peek(){
        if (isEmpty())
            throw new RuntimeException("Queue is empty!");
        front = adjustIndex(front, size);
        return data[front];
    }

    private int adjustIndex(int index, int sz){
        return index >= sz ? index-sz : index;
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        aq.isEmpty();
        aq.peek();
        aq.isFull();
    }
}
