package dsa.linkedlists.singlylinkedlist;
import java.util.LinkedList;
public class SearchLL {
    LinkedList<Integer> ll= new LinkedList<>();

    // searching element in LinkedList
    void search(int e){
        int result= -1;
        for (int i = 0; i < ll.size(); i++) {
            int element =ll.get(i);
            if (element == e) {
                result = i;
                break;
            }
        }
        if (result == -1)
            System.out.println("Element isn't available in the LinkedList.");
        else
            System.out.println("Element is found at index: "+ result);
    }

    public static void main(String[] args) {
        SearchLL s= new SearchLL();
        s.ll.add(5);
        s.ll.add(7);
        s.ll.add(2, 6);
        System.out.println(s.ll);
        s.search(7);
    }
}
