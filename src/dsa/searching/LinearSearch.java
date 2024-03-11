package dsa.searching;

public class LinearSearch {
    int linearSearch(int[] arr, int e){
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == e) {
                System.out.println("The element "+e+" is found at index: "+i);
                return i;
            }
        }
        System.out.println("The element "+e+" is not found!");
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr= {1, 5, 6, 7, 8, 9, 0};
        int[] arr= {1, 5, 6, 7, 8, 9, 0, 3, 11};
        LinearSearch ls =new LinearSearch();
        ls.linearSearch(arr, 7);
        ls.linearSearch(arr, 4);
        ls.linearSearch(arr, 3);
    }
}
