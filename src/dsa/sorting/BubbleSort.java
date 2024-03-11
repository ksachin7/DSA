package dsa.sorting;

public class BubbleSort {
    static void bubbleSort(int[] arr){
        int size= arr.length;

//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size-1; j++) {
//                int tmp= arr[j];
//                if (arr[j]>arr[i]) {
//                    arr[j] = arr[i];
//                    arr[i]= tmp;
//                }
//            }
//        }

        // other way:
        // it will require n-1 passes
//        for (int i = 0; i < size-1; i++) {
////            System.out.print(i+" \n");
//            int flag = 0;
            // after every pass i elements reduced
//            for (int j = 0; j < size-1-i; j++) {
//                int tmp= arr[j];
//                if (arr[j]>arr[j+1]) {
//                    arr[j] = arr[j+1];
//                    arr[j+1]= tmp;
//                    flag = 1;
//                }
//            }
//            if (!flag)
//                break;
//        }

        // another way:
        if (arr == null) {
            return;
        }

        boolean sorted;
        do {
            sorted = true;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i - 1, i);
                    sorted = false;
                }
            }
        } while (!sorted);
    }
    static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    static void printArray(int[] arr){
        int size= arr.length;
        System.out.println("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr= {9, 1, 5, 5 , 7, 2, 6, 0};
        bubbleSort(arr);
        printArray(arr);
    }
}
