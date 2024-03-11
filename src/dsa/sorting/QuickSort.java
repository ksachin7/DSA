package dsa.sorting;

public class QuickSort {
    static int partition(int[] arr, int start, int end){
        // for simplicity taking last element as pivot
        int pivot = end;
        int i= start-1;

        // incrementing i and swapping i and j
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int tmp= arr[i];
                arr[i]= arr[j];
                arr[j]= tmp;
            }
        }
        return i;
    }

    static void quickSort(int[] arr, int start, int end){
        if (start < end) {
            // partitioning array
            int pivot = partition(arr, start, end);
            // recursive call for left & right sub-array
            quickSort(arr, start, pivot-1);
            quickSort(arr,pivot+1, end);
        }
    }

    static void print(int[] arr){
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int end= arr.length-1;
        quickSort(arr, 0, end);
        print(arr);
    }
}
