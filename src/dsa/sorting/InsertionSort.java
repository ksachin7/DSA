package dsa.sorting;

public class InsertionSort {
    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int temp= arr[i], j=i;
            while (j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
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
        insertionSort(arr);
        print(arr);
    }
}
