package dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InPreBinaryTree {
    Node root;
    static int idx=0;

    static class Node{
        Node left, right;
        int data;
//        Node end;
//        Node start;

        Node(int data){
            this.data = data;
        }
    }
     int search(int[] inorder, int start, int end, int curr){
        for (int i = start; i <= end; i++) {
            if (inorder[i] == curr)
                return i;
        }
        return -1;
    }
     Node buildTree(int[] preorder, int[] inorder, int start, int end) {
         if (start> end)
             return null;

        int current= preorder[idx];
        idx++;
        Node newNode = new Node(current);
        if (start== end)
            return newNode;
        int pos= search(inorder, start, end, current);
        newNode.left = buildTree(preorder, inorder, start, pos-1);
        newNode.right = buildTree(preorder, inorder, pos+1, end);
        return newNode;
    }
//    void buildTree(){
//        root = buildTree(preorder, inorder, start, end);
//    }


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

    void inorderPrint(Node root){
        if (root == null)
            return;
        inorderPrint(root.left);
        System.out.print(root.data+" ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] preorder= {1, 2, 4, 3, 5};
        int[] inorder= {4, 2, 1, 5, 3};

        InPreBinaryTree ipbt = new InPreBinaryTree();
        Node root = ipbt.buildTree(preorder, inorder, 0, preorder.length-1);
        ipbt.levelOrder(root);

        System.out.println("Inorder: ");
        ipbt.inorderPrint(root);
    }
}

// Time complexity: O(n^2)

// Level Order Binary Tree Traversal
// Write a Program to Find the Maximum Depth or Height of a Tree
// Decision Tree
// A program to check if a binary tree is BST or not