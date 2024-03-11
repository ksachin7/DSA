package dsa.linkedlists;
public class DoublyLinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data= data;
            next = prev = null;
        }
    }

    void insertStart(int d){
        Node newNode = new Node(d);
        newNode.prev= null;
        if (head == null)
            head = newNode;
        newNode.next= head;
        head= newNode;
    }

    void insertEnd(int d){
        Node newNode = new Node(d);
        Node n= head;
        // check if head is null
        if (head == null){
            head= newNode;
            return;
        }
        while (n.next != null){
            n= n.next;
        }
        newNode.next= null;
        newNode.prev= n.next;
        n.next= newNode;
    }
    void insertAfter(int previous, int d){
        Node preNode = head;
        if (preNode == null)
            return;
        while (preNode.data != previous) {
            preNode = preNode.next;
        }
        Node newNode= new Node(d);
        newNode.next= preNode.next;
        preNode.next= newNode;
        newNode.prev= preNode;
        if (newNode.next != null)
            newNode.next.prev= newNode;
    }

    void remove(int pos){
//        Node prePos = head;
//        if (head == null)
//            return;
//        if (head.next == null){
//            head = null;
//            return;
//        }
//
//        for (int j = 0; j < pos-1; j++) {
//            prePos = prePos.next;
//        }
//        if (prePos==null || prePos.next==null){
//            return;
//        }
//        System.out.println(prePos.data);
//        prePos.next.next.prev= prePos;
//        prePos.next= prePos.next.next;
    }

    void removeFirst(){
        head= head.next;
        if(head.next == null){
            head=null;
        }
    }

    void removeLast(){
        Node n = head;
        if (head== null)
            return;
        if (head.next== null){
            head= null;
            return;
        }
        while (n.next != null){
            n= n.next;
        }
        n.prev.next=null;
    }

    void printDLL(){
        Node i = head;
        Node j = null;
        System.out.print("\nPrinting forward: ");
        while (i != null){
            System.out.print(i.data+" ");
            j=i;
            i= i.next;
        }
        System.out.println();
//        System.out.print("Printing Backward: ");
//        while (j != null){
//            System.out.print(j.data);
//            j= j.next;
//        }
    }

    // Delete the last node
    public int deleteL() {
        int x = -999;
        if (head != null) {
            Node current;
            current = head;
            while (current.next != null) // for traverse till the ends of the list
                current = current.next;
            x = current.data;

            if (current.prev == null) // this is to check list has only one element or  not
                head = null;
            else
                current.prev.next = null;

        } else
            System.out.println("List is empty");

        return x;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1);
        dll.printDLL();
        dll.removeLast();
        dll.printDLL();
        dll.insertEnd(2);
        dll.insertEnd(4);
        dll.printDLL();
        dll.insertAfter(2, 3);
        dll.insertAfter(2, 5);
        dll.insertAfter(4, 7);
        dll.printDLL();
        dll.insertStart(0);
        dll.removeLast();
        dll.printDLL();
        dll.removeFirst();
        dll.printDLL();
        System.out.println("-----");
        dll.remove(0);
        dll.printDLL();

        dll.remove(1);
        dll.printDLL();

        dll.remove(2);
        System.out.println("-------");
        dll.printDLL();
        dll.deleteL();
        dll.printDLL();
    }
}
