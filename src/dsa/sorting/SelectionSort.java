package dsa.sorting;

public class SelectionSort {

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex= i;

            // finding minimum element index
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex=j;
            }
//          swapping
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex]= tmp;
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
        selectionSort(arr);
        print(arr);
    }
}
