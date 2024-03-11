package dsa.linkedlists.singlylinkedlist;

public class LinkedList {
    public Node head;

    public static class Node{
//        int size=0;
        public int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    // insert at start
     void addFirst(int data){
        Node newNode = new Node(data);  // creating a new node
        newNode.next = head;            // pointing new node to old node(head)
        head = newNode;                 // making newNode head
    }

    // insert at end
    void add(int data){
        Node newNode = new Node(data);  // creating a new node

        if (head==null){                // checking if LL is empty?
//            head = new Node(data);    //
            head = newNode;             // assigning newNode's ref. to head or making it head node
            return;
        }
        Node n = head;              // creating a new ref. for traversal
        while (n.next!= null){      // traversing LL to find last node
            n= n.next;              // pointing n to last node
        }
        n.next= newNode;            // adding new node to (older)last node
    }
//
//    public void insertAt(int pos, int data){
//        Node current = head, prev= null;
//        Node newNode= new Node(data);
//
////        // checking if next is null not necessary
////        if (current.next == null) {
////            current = newNode;
////        }
//
//        // moving current to pos and prev to before pos cuz prev.next(i.e pos)==newNode
//        for (int i = 0; i < pos && current != null; i++) {
//            prev = current;
//            current = current.next;
//        }
//
//        // if prev is null(in case of only one element in LinkedList)
//        if (prev == null) {
//            newNode.next= head;
//            head = newNode;
//            return;
//        }
//        prev.next = newNode;
//        newNode.next = current;
//    }
public void insertAt(int pos, int data){
        Node newNode= new Node(data);
        Node h=head;

        if(head == null){
            head= newNode;
        }
        else{
            for (int i = 1; i < pos; i++) {
                h= h.next;
            }
            newNode.next= h.next;
            h.next= newNode;
        }
    }

//    void insertAfter(int prev, int data){       // taking previous node and data of node to add after
//        Node p = head;                          // creating p ref. of node and pointing to head node
//        while (p.data != prev){                 // finding the node after which new node has to be added
//            p= p.next;                          // and assigning(pointing) it to p
//        }
//        Node newNode = new Node(data);
//        newNode.next = p.next;                  // pointing prev. node's next(node after) to newNode
//        p.next = newNode;                       // pointing newNode to prev. node
//    }

    void insertAfter(Node prev, int data){
        if(prev == null){
            System.out.println("This node doesn't exist in the linked-list.");
            return;
        }
        Node newNode= new Node(data);
        newNode.next= prev.next;
        prev.next= newNode;
    }

    int removeFirst(){
        int data= head.data;         // Extract the data at the head and move
        head = head.next;            // shifting head to next node
        System.out.println("1st node removed!");
        return data;
    }
    int removeLast(){
        Node curr= head;
        int d= curr.data;

        if (head == null) {
            System.out.println("The list is already empty!");
            return -1;
        }
        if (curr.next ==null){
            System.out.println(head.data+" is deleted!");
            head=null;
            return -1;
        }

        while (curr.next.next != null){
            curr = curr.next;
        }
//        System.out.println(curr.data);
        curr.next = null;

        System.out.println("Last node is deleted!");
        return d;
    }
    void remove(int key){
        Node current = head, prev = null;                   // creating current and previous node references
        if (head != null && head.data == key) {       // if first(current) node isn't null and this is the node to delete
            head = head.next;                            // making head point to next node
            return;
            // Note: after removing first node calling remove again doesn't remove occurrence of element because of return
        }
        if (head == null){                                // if current node is null return
            return;
        }
        while (current != null){                             // finding the node to delete
            if (current.data == key)
                prev.next = current.next;                    // else deleting the node by making previous point to next(next to current) node
            prev = current;                                  // making previous point to current node
            current = current.next;                          // making current point to next node
        }
//        while(current.next != null){
//            if (current.data == key)
//                current= current.next;
//            current = current.next;
//        }
        System.out.println(key+" removed!");
    }


    public void removeAt(int position){
        Node current = head;                    // creating current node reference
        if (position == 0) {                    // if first(current) node is the node to delete
            head = current.next;                // making head point to next node
//            removeFirst();
        }
       for(int i = 0; i < position-1 && current != null; i++)
           current = current.next;              // pointing current to the position to delete
       if (current == null || current.next == null){
           return;                              // if current element is (null) then return
       }
        current.next = current.next.next;       // else deleting the node by making current point to next(next to deletion node) node
//        current.next= null;

        switch (position) {
            case 1 -> System.out.println(position + "st node is deleted!");
            case 2 -> System.out.println(position + "nd node is deleted!");
            case 3 -> System.out.println(position + "rd node is deleted!");
            default -> System.out.println(position + "th node is deleted!");
        }

    }

    int peek(){
        return head.data;
    }
    int peekLast(){
        if(head == null)
          throw new RuntimeException("The LinkedList is empty!");
        Node itr = head;
        while(itr.next != null) {
            itr = itr.next;
        }
        return itr.data;
    }

     int size(Node n){
        if (n == null)
            return 0;
        return 1+size(n.next);
    }
    public int getSize(){
        System.out.println("Size of the LinkedList: "+size(head));
        return size(head);
    }

    boolean search(Node head, int key){
        Node n = head;
        int index=0;
        boolean result = false;
        while (n != null){
            if (n.data == key) {
                System.out.println("Element is found at: " + index);
                result = true;
            }
            n = n.next;
            index++;
        }
        return result;
    }

    // Iterative reverse
    Node reverse(Node h){
        if (h==null || h.next==null) {
            return h;
        }
        Node tmp;
        Node current= h, prev= null;
        while(current != null){
            tmp= current.next;      // storing next node in tempNode
            current.next = prev;    // deleting next node
            prev = current;         // making current node previous
            current = tmp;          // making tmp node current
        }
        return prev;
    }

    // Recursive reverse
    static Node revRecur(Node h){
        if (h==null || h.next==null) {
            return h;
        }
        Node prev= revRecur(h.next);
        h.next.next= h;
        h.next= null;

        return prev;
    }

    int indexOf(int d){
        int index=0;
        Node h = head;
        while (h != null){
            if (h.data == d)
                return index;
            index++;
            h= h.next;
        }
        return -1;
    }

    boolean contains(int d) {
        return indexOf(d) != -1;
    }

    void clear(){
        Node itr = head;
        while(itr != null){
            itr.next = null;
            itr= itr.next;
        }
        head=null;
        System.out.println("Cleared!");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node itr = head;
        while (itr!=null){
            sb.append(itr.data);
            if (itr.next != null)
                sb.append(" ");
            itr= itr.next;
        }
        sb.append(']');
        return sb.toString();
    }

    void createLoop(){
        Node i = head;
        if (head== null)
            return;
        while (i.next!= null)
            i= i.next;
        i.next=head;
    }


    void printLL(){
        Node i = head;
        System.out.print("|");
        while (i!=null){
//            System.out.print(i.data+" ");
            System.out.print("[ "+i.data+" ]-> ");
            i=i.next;
        }
        System.out.println('|');
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head= new Node(5);            // creating head node
        Node second = new Node(7);      // creating second node
        ll.head.next= second;                 // pointing second to head
        Node third = new Node(8);
        second.next= third;
        ll.printLL();
        ll.getSize();

        ll.addFirst(9);
        ll.addFirst(6);
        ll.add(7);
        ll.add(3);
        ll.printLL();

        ll.insertAt(3,4);
        ll.insertAt(0,1);
        ll.insertAt(9,9);
        ll.printLL();

        ll.removeFirst();
        ll.printLL();

        ll.insertAfter(ll.head.next, 0);
        ll.insertAfter(ll.head.next.next, 1);
        ll.printLL();

        ll.remove(8);
        ll.remove(6);
        ll.remove(9);
        ll.printLL();

        ll.removeAt(0);
        ll.removeAt(3);
        ll.removeAt(5);
        ll.printLL();

        ll.getSize();
        ll.search(ll.head, 7);
        System.out.println(ll.peek());
        System.out.println(ll.peekLast());
        ll.printLL();
        System.out.println("Index of 7: "+ll.indexOf(7));
        System.out.println("LL contains(6):"+ll.contains(6));
        ll.printLL();
//
        ll.head=ll.reverse(ll.head);
        ll.printLL();
        ll.head= revRecur(ll.head);
        ll.printLL();

        ll.removeLast();
        ll.printLL();
        ll.removeLast();
        ll.printLL();
        ll.removeLast();
        ll.printLL();
        ll.removeLast();
        ll.printLL();
//        ll.removeLast();
//        ll.printLL();

        ll.clear();
        ll.printLL();

    }
}
