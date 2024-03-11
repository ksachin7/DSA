package dsa.linkedlists.singlylinkedlist;

public class ArrayToLinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
            next= null;
        }
    }
    Node insert(int data){
        Node tmp = new Node(data);
        Node current= head;
        if (head == null)
            head = tmp;
        else {
            while (current.next != null){
                current = current.next;
            }
            current.next = tmp;
        }
        return head;
    }

    Node removeFirst(){
        int d= head.data;
        head = head.next;
        System.out.println(d+" removed!");
        return head;
    }

    Node arrayToList(int[] arr){
        for (int j : arr)
            head = insert(j);
        return head;
    }

void printLL(){
    Node i = head;
    System.out.print("|");
    while (i!=null){
        System.out.print("[ "+i.data+" ]---> ");
        i= i.next;
    }
    System.out.println('|');
}

    public static void main(String[] args) {
        ArrayToLinkedList aLL= new ArrayToLinkedList();
        int[] arr = {1, 3, 5, 7, 9, 0};
        aLL.arrayToList(arr);
        aLL.printLL();
        aLL.removeFirst();
        aLL.removeFirst();
        aLL.printLL();
    }
}
