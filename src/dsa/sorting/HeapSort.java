package dsa.sorting;
import dsa.heap.BinaryHeap;

public class HeapSort {
    int[] arr= null;
    HeapSort(int[] arr){
        this.arr= arr;
    }
    void heapSort(){
        BinaryHeap bHeap= new BinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            bHeap.insert(arr[i], "max");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]= bHeap.extractRoot("max");
        }
    }

    // levelOrderTraversal
    public void printHeap(){
        if (arr == null){
            System.out.println("The heap is empty!");
            return;
        }
        else {
            int n = arr.length;
            System.out.print("Sorted Array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        HeapSort hs= new HeapSort(arr);
        hs.heapSort();
        hs.printHeap();
    }
}
