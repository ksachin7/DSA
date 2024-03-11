package dsa.searching;

import java.util.Arrays;

public class BinarySearch {
    int binarySearch(int[] arr, int key){
        System.out.println("Searching "+key+"...");
        // initializing start, end, and mid
        int start= 0, end= arr.length-1;

        // looping and creating new mid in half left/right part of the array in which the key lies
        while (start <= end){
            int mid = start+(end-start)/2;
            System.out.println("-> start= "+start+" | end= "+end+" | mid= "+mid);

            if (key < arr[mid])
                end =mid-1;
            else if (key > arr[mid]) {
                start = mid + 1;
            }
            else {
                System.out.println("The element " + key + " is found at index: " + mid+"\n");
                return mid;
            }
        }
        System.out.println("The element " + key + " is not found!\n");
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr= {1, 5, 6, 7, 8, 9, 0};
        int[] arr= {1, 5, 6, 7, 8, 9, 0, 3, 8};
        // For Binary Search array needs to be sorted
        Arrays.sort(arr);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
        BinarySearch bs = new BinarySearch();
        bs.binarySearch(arr, 6);
        bs.binarySearch(arr, 9);
        bs.binarySearch(arr, 0);
        bs.binarySearch(arr, 8);
    }
}
