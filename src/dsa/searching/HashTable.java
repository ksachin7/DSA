package dsa.searching;
import java.util.*;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(1, 21);
        ht.put(11, 121);
        ht.put(111, 1);
        ht.put(10, 11);
        ht.put(21, 10);
        ht.put(1001, 10);
        System.out.println(ht);
        ht.remove(10);
        System.out.println(ht);
    }
}
