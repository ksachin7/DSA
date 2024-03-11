package dsa.sorting;

public class MergeSort {
    static void merge(int[] arr, int left, int middle, int right){
        // took the array size a little bigger to avoid ArrayOutOfBound exception
        int[] leftTempArray= new int[middle-left+2];
        int[] rightTempArray= new int[right-middle+1];

        // dividing array & copying data
        for (int i = 0; i <= middle-left; i++) {
            leftTempArray[i] = arr[left+i];
        }
        for (int i = 0; i < right-middle; i++) {
            rightTempArray[i] = arr[middle+1+i];
        }
//        // simplified above for-loops
//        if (middle - left + 1 >= 0)
//            System.arraycopy(arr, left, leftTempArray, 0, middle - left + 1);
//        if (right - middle + 1 >= 0)
//            System.arraycopy(arr, middle+1, rightTempArray, 0, right - middle + 1);

        //
        leftTempArray[middle-left+1] = Integer.MAX_VALUE;
        rightTempArray[right-middle]=  Integer.MAX_VALUE;

        // merging arrays
        int i=0, j=0;
        for (int k = left; k <= right ; k++) {
            // if element in leftTempArray is less than rightTempArray then copy that to array otherwise copy rightTempArray element to Array
            if (leftTempArray[i] < rightTempArray[j]){
                arr[k] = leftTempArray[i];
                i++;
            }
            else {
                arr[k] = rightTempArray[j];
                j++;
            }
        }

    }

    static void mergeSort(int[] arr, int left, int right){
        if (right > left){
            int m= (left+right)/2;
            // sorting left array
            mergeSort(arr, left, m);

            // sorting right array
            mergeSort(arr, m+1, right);

            // merging
            merge(arr, left, m, right);
        }

    }

    static void print(int[] arr){
        System.out.print("Sorted Array: [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int left=0, right= arr.length-1;
        MergeSort.mergeSort(arr, left, right);
        MergeSort.print(arr);
    }
}
