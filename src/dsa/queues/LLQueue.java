package dsa.queues;

public class LLQueue {
    Node front = null, rear = null;
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next=null;
        }
    }

    boolean isEmpty(){
        return front== null && rear == null;
    }

    void enqueue(int x){
        Node tmp = new Node(x);
        tmp.data= x;
        tmp.next=null;
        // case 1: if both front and rear will be null
        if (front==null && rear == null) {
            front = rear = tmp;
            return;
        }
        // case 2: if both the front and rear is not null
        rear.next= tmp;
        rear= tmp;      // making tmp the new rear
    }

    void dequeue(){
        // case 1: if list is empty
        if (front== null)
            throw new RuntimeException("Can't dequeue, the queue is empty!");

        // case 2: if list has one element
        else if (front == rear) {
            System.out.println(front.data + " dequeued!");
            front = rear = null;
        }
        else {
            System.out.println(front.data + " dequeued!");
            front = front.next;
        }
    }

    void display(){
        Node head = front;
        if (front== null)
            return;
        else
            System.out.print("[ ");
            while (head != null) {
                System.out.print(head.data+" ");
                head = head.next;
            }
        System.out.println("]");
    }

    public static void main(String[] args) {
        LLQueue llq= new LLQueue();
        System.out.println(llq.isEmpty());
        llq.enqueue(5);
        llq.enqueue(6);
        llq.enqueue(9);
        llq.enqueue(0);
        llq.display();
        llq.dequeue();
        llq.display();
        llq.enqueue(7);
        llq.display();
        llq.dequeue();
        llq.dequeue();
        llq.dequeue();
        llq.dequeue();
        llq.dequeue();
        llq.dequeue();
        System.out.println(llq.isEmpty());
    }
}
