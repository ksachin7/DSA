package dsa.heap;

public class HeapWithArray {
    void heappify(int[] arr, int n, int i){
        int largest= i;
        int lc= 2*i+1;
        int rc= 2*i+2;

        // if left-child is larger than current largest make it largest
        if (lc < n && arr[lc] > arr[largest])
            largest= lc;

        // if right-child is larger than current largest make it largest
        if (rc < n && arr[rc] > arr[largest])
            largest= rc;

        // if largest isn't root making it by swapping
        if (largest != i){
            int tmp = arr[i];
            arr[i]= arr[largest];
            arr[largest]= tmp;
            heappify(arr, n, largest);
        }
    }

    void sort(int[] arr){
        int n= arr.length;
        for (int i = n/2-1; i >=0 ; i--) {
            heappify(arr, n,  i);
        }
        for (int i = n-1; i >0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heappify(arr, i, 0);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapWithArray heap= new HeapWithArray();
//        int[] arr= {8,3 ,7, 1, 2, 5, 6};
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int n= arr.length;
        heap.heappify(arr, n, 0);
        printArray(arr);
        heap.sort(arr);
        printArray(arr);
    }
}
