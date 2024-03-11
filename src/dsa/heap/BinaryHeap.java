package dsa.heap;
import java.util.Objects;

public class BinaryHeap {
    int[] arr;
    int sizeOfHeap;

    public BinaryHeap(int size){
        arr = new int[size+1];
        this.sizeOfHeap= 0;
        System.out.println("Heap is created successfully!");
    }
    public boolean isEmpty(){
        return sizeOfHeap==0;
    }
    boolean isFull(){
        return sizeOfHeap== arr.length-1;
    }

    int findParent(int node){
        int parent=0, flag=0;
        if (node==arr[1]) {
            System.out.println(node + " is root node!");
            return -1;
        }
        for (int i = 2; i < sizeOfHeap; i++) {
            if (arr[i] == node) {
                parent = arr[i/ 2];
                flag =1;
                System.out.println("Parent of " + node + " at index-"+i+" is: " + parent);
//                return parent;
            }
        }
        if (flag==0)
            System.out.println(node + " is not a node of this heap!");
        return parent;
    }

    Integer peek(){
        if (isEmpty()) {
            System.err.println("Heap is empty!");
            return null;    // to return null return type must be Integer
        }
        else
            return arr[1];
    }

    int getSizeOfHeap(){
        return sizeOfHeap;
    }

    public void insert(int val, String typeOfHeap){
        arr[sizeOfHeap+1]= val;
        sizeOfHeap++;
        // using sizeOfHeap as index cuz new element is inserted at sizeOfHeap
        heapify(sizeOfHeap, typeOfHeap);    // TimeComplexity: O(log n)
        System.out.println(val+" inserted!");
    }
    // heapify bottom to top(for insertion)
    void heapify(int idx, String typeOfHeap){
        int parent= idx/2;
        if (idx <= 1)
            return;
        if (typeOfHeap == "min"){
            if (arr[idx]<arr[parent]) {
                int tmp = arr[idx];
                arr[idx]= arr[parent];
                arr[parent]= tmp;
            }
        }
        else if (typeOfHeap == "max"){
            if (arr[idx] > arr[parent]) {
                int tmp = arr[idx];
                arr[idx]= arr[parent];
                arr[parent]= tmp;
            }
        }
        heapify(parent, typeOfHeap);
    }

    // heapify top to bottom(for deletion)
    void heapifyTopToBottom(int idx, String typeOfHeap){
        int LCi= 2*idx;
        int RCi= 2*idx+1;
        int swapChild = 0;

        // if new element exceeds sizeOfHeap then return
        if (sizeOfHeap < LCi)
            return;

        if (Objects.equals(typeOfHeap, "max")){
            // if only one left child in the heap
            if (sizeOfHeap == LCi){
                // if root < LCi then swap it
                if (arr[idx] < arr[LCi]){
                    int tmp = arr[idx];
                    arr[idx]= arr[LCi];
                    arr[LCi]= tmp;
                }
                return;
            }
            // if heap has two children
            else {
                // left child is greater than right then swapChild = LCi
                if (arr[LCi] > arr[RCi])
                    swapChild = LCi;
                // right child is greater than left then swapChild = RCi
                else
                    swapChild = RCi;
                // swapping root with swapChild value i.e. left/right child
                if (arr[idx] < arr[swapChild]){
                    int tmp = arr[idx];
                    arr[idx]= arr[swapChild];
                    arr[swapChild]= tmp;
                }
            }
        } else if (Objects.equals(typeOfHeap, "min")) {
            // if only one left child in the heap
            if (sizeOfHeap == LCi){
                // if root < LCi then swap it
                if (arr[idx] > arr[LCi]){
                    int tmp = arr[idx];
                    arr[idx]= arr[LCi];
                    arr[LCi]= tmp;
                }
                return;
            }
            // if heap has two children
            else {
                // left child is greater than right then swapChild = LCi
                if (arr[LCi] < arr[RCi])
                    swapChild = LCi;
                    // right child is greater than left then swapChild = RCi
                else
                    swapChild = RCi;
                // swapping root with swapChild value i.e. left/right child
                if (arr[idx] > arr[swapChild]){
                    int tmp = arr[idx];
                    arr[idx]= arr[swapChild];
                    arr[swapChild]= tmp;
                }
            }
        }
        heapifyTopToBottom(swapChild, typeOfHeap);
    }

    public int extractRoot(String typeOfHeap){
        if (!isEmpty()){
            // extracted value = root
            int extractedValue = arr[1];
            arr[1]= arr[sizeOfHeap];
            sizeOfHeap--;
            heapifyTopToBottom(1, typeOfHeap);
            System.out.println(extractedValue+ " is deleted successfully!");
            return extractedValue;
        }
        return -1;
    }

    void deleteHeap(){
        arr = null;
        sizeOfHeap = 0;
        System.out.println("The heap is deleted successfully!");
    }

    // levelOrderTraversal
    public void printHeap(){
        if (isEmpty()){
            System.out.println("The heap is empty!");
            return;
        }
        else {
            int n = arr.length;
            System.out.print("Level-order: ");
            for (int i = 1; i <= sizeOfHeap; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(7);
        System.out.println("Is heap empty?: "+bh.isEmpty());
        System.out.println("Size of heap: "+bh.getSizeOfHeap());
//        System.out.println("Peek: "+bh.peek());
        bh.insert(9, "max");
        bh.insert(1, "max");
        bh.insert(5, "max");
        bh.insert(5, "max");
        bh.insert(7, "max");
        bh.insert(2, "max");
        bh.insert(6, "max");
        bh.printHeap();
        System.out.println("Is heap empty?: "+bh.isEmpty());
        System.out.println("Size of heap: "+bh.getSizeOfHeap());
        System.out.println("Is heap full?: "+bh.isFull());
        System.out.println("Peek: "+bh.peek());
        bh.findParent(11);
        bh.findParent(1);
        bh.findParent(5);
        bh.printHeap();
        bh.extractRoot("min");
        bh.printHeap();
        bh.deleteHeap();
        bh.printHeap();
    }
}
