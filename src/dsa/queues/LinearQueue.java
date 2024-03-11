package dsa.queues;

public class LinearQueue {
    int[] queue;
    int size, front, rear;

    public LinearQueue(int capacity){
        queue= new int[capacity];
        size= queue.length;
        front = 0;
        rear = -1;
    }

    boolean isEmpty(){
        return front > rear;
    }

    boolean isFull(){
        return rear == size-1;
    }

    void enqueue(int e){
        if (!isFull()){
            rear++;
            queue[rear]= e;
            System.out.println(e+" inserted!");
        }
        else
            throw new RuntimeException("Queue overflow!");
    }

    int dequeue(){
        if (!isEmpty()) {
            int x= queue[front];
            queue[front]=0;
            front++;
            System.out.println(x+" deleted!");
            return x;
        }
        else
            throw new RuntimeException("Queue Underflow!");
    }

    void printQueue(){
        if (isEmpty())
            System.out.println("Queue is empty!");
        else
            System.out.print("[ ");
//            for (int e: queue) {
//                System.out.print(e+" ");
//            }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]+" ");
        }
        System.out.println(']');
    }

    public static void main(String[] args) {
        LinearQueue lq = new LinearQueue(6);
        System.out.println("Queue is empty: "+lq.isEmpty());
        lq.enqueue(40);
        lq.enqueue(4);
        lq.enqueue(44);
        lq.enqueue(41);
        lq.enqueue(14);
        lq.enqueue(42);
        lq.printQueue();
        System.out.println("Queue is full: "+lq.isFull());
//        lq.enqueue(41);
        lq.dequeue();
        lq.printQueue();

    }
}
