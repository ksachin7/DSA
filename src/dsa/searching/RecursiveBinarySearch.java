package dsa.searching;

public class RecursiveBinarySearch {
    static int recBinarySrarch(int[] arr, int start, int end, int key){
        int mid= start+(end-start)/2;
        if (start <= end){
            if (arr[mid]== key){
                System.out.println("The element " + key + " is found at index: " + mid);
                return mid;
            }
            else if (arr[mid] > key)
                recBinarySrarch(arr, start, mid-1, key);
            else if (arr[mid] < key)
                recBinarySrarch(arr, mid+1, end, key);
            else {
                System.out.println("The element " + key + " is not found!");
            }
        }
        return -1;
    }
    static void rBinarySearch(int[] arr, int key){
        int end= arr.length-1;
        recBinarySrarch(arr, 0, end, key);
    }

    public static void main(String[] args) {
        int[] arr= {0, 1, 3, 5, 6, 7, 8, 8, 9};
        rBinarySearch(arr, 6);
        rBinarySearch(arr, 3);
        rBinarySearch(arr, 7);
    }
}
