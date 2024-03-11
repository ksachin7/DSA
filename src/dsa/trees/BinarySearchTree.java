package dsa.trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree {
    Node root;
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            right = left = null;
        }
    }

    public BinarySearchTree(){
        root= null;
//        root= new Node(data);
    }

    // iterative approach
    Node add(Node r, int d){
        if (r == null){
            r = new Node(d);
            return r;
        }
        Node parent= null;
        while(r!=null){
            parent= r;
            if (d < r.data){
                r = r.left;
            }
            else {
                r= r.right;
            }
        }
        if (d< parent.data )
            parent.left= new Node(d);
        else
            parent.left= new Node(d);

        return parent;
    }
    void add(int data){
        add(root, data);
    }

    // recursive approach
    Node insert(Node root, int data){
        if (root == null){
            root= new Node(data);
            return root;
        }
        if (data< root.data){
            root.left=  insert(root.left, data);
        }
        else {
            root.right=  insert(root.right, data);
        }
        return root;
    }
    // caller function
    void insert(int data){
        root = insert(root, data);
    }

    // root->left->right
    void preorder(Node n){
        if (n== null) {
            return;
        }
        System.out.print(n.data);
        System.out.print(" ");
        preorder(n.left);
        preorder(n.right);
    }
    // caller function
    void preorder(){
        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
    }

    // left->root->right
    void inorder(Node n){
        if (n== null){
//            throw new RuntimeException("The tree is empty!");
            return;
        }
        inorder(n.left);
        System.out.print(n.data);
        System.out.print(" ");
        inorder(n.right);
    }
    // caller function
    void inorder(){
        System.out.println("\nInorder:");
        inorder(root);
        System.out.println();
    }

    // left->right->root
    void postorder(Node n){
        if (n== null) {
            return;
        }
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data);
        System.out.print(" ");
    }
    // caller function
    void postorder(){
        System.out.println("\nPostorder:");
        postorder(root);
        System.out.println();
    }

    void levelOrder(){
        levelOrder(root);
    }
    void levelOrder(Node root){
        if (root == null)
            return;
        final Queue<Node> q= new LinkedList<>();
        // adding the node
        q.add(root);
        System.out.println("Level order: ");
        while (!q.isEmpty()) {
            final int size= q.size();
            for (int i = 0; i < size; i++) {
                // removing the front node from the queue
                Node current = q.remove();
                // print the value of the removed node
                System.out.print(current.data+" ");
                // if the left child is present, enqueue the left child
                if (current.left != null)
                    q.add(current.left);
                // if the right child is present, enqueue the right child too
                if (current.right != null)
                    q.add(current.right);
            }
            System.out.println();
        }
    }

//    int search(){
//        int index=0;
//
//        return index;
//    }

    Node delete(Node r, int data){
        // if tree is empty
        if (r == null)
             return r;
        // if data to be deleted is in left or right side go to left/right side accordingly
        if(data< r.data)
            r.left = delete(r.left, data);
        else if (data > r.data)
            r.right= delete(r.right, data);

        // if data == root node then writing conditions for deletion
        else {
//            case 1: deleting leaf node
//            case 2: deleting root with one child
            if (r.left == null) {
                r= r.right;          // in case of leaf node it will return right node that is null
            }
            else if (r.right == null) {
                r= r.left;
            }
            else {
//            case 3: deleting root with two child
                r.data = minvalue(r.right);

                // deleting an element in inorder and replacing with successor node
                r.right = delete(r.right, r.data);
            }
        }
        return r ;
    }

    int delete(int e){
       root =  delete(root, e);
//       throw new UnsupportedOperationException();
       return root.data;
    }

//    Iterative approach
//    int minvalue(Node r){
//        int min= r.data;
//        while (r.left != null){
//            min = r.left.data;
//            r= r.left;              // if u take root instead of r it will modify the whole tree and set root = min_val
//        }
//        return min;
//    }

//    Recursive Approach
    int minvalue(Node root){
        if (root == null) {
            System.err.println("The tree is empty!");
            return 0;
        }
        else if (root.left == null)
            return root.data;
        return minvalue(root.left);
    }
    int minvalue(){
       return minvalue(root);
    }

    int maxvalue(Node root){
        if (root == null) {
            System.err.println("The tree is empty!");
            return 0;
        }
        else if (root.right == null)
            return root.data;
        return maxvalue(root.right);
    }
    int maxvalue(){
        return maxvalue(root);
    }

    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();
//        bst.inorder();
//        bt.root.left=new Node(11);
//        bt.root.right=new Node(14);
//        bt.root.left.left=new Node(6);
//        bt.root.right.right=new Node(7);
//        bst.insert(11);
//        bst.insert(4);
//        bst.insert(3);
//        bst.insert(5);
//        bst.insert(6);
//        bst.insert(7);
//        bst.insert(10);  // bst can have duplicates

//        int randomNumber = (int)(Math.random()*100);    // this generates 1 random no. everytime so not suitable to use here
        Random rNum = new Random();
        for (int i = 0; i < 10; i++) {
            bst.insert(rNum.nextInt(100));
        }

        bst.preorder();
        bst.inorder();
        bst.postorder();
        bst.levelOrder();

//        bst.add(10);
        bst.inorder();
        System.out.println("Min. value: "+bst.minvalue());
        System.out.println("Max. value: "+bst.maxvalue());
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Deleting 6: ");
        bst.delete(6);
        bst.inorder();
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Deleting 11: ");
        bst.delete(11);
        bst.inorder();
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Deleting 10: ");
        bst.delete(10);
        bst.inorder();
        bst.preorder();
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Deleting 4: ");
        bst.delete(4);
        bst.inorder();
        bst.preorder();
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Deleting 5: ");
        bst.delete(5);
        bst.inorder();
        bst.preorder();
        System.out.println("----------------");
    }
}

//    Time Complexity: O(n^2). The worst case occurs when the tree is left-skewed.

//    Efficient Approach :
//    We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java).
//    We store indexes of inorder traversal in a hash table. So that search can be done O(1) time.