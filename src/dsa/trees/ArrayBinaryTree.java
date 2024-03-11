package dsa.trees;

public class ArrayBinaryTree {
    int root;
    String[] arr;
    public ArrayBinaryTree(int size){
        root=0;
        arr= new String[size+1];
    }

    boolean isFull(){
        return arr.length - 1 == root;
    }

    void insert(String str) {
        if (!isFull()) {
            arr[root + 1] = str;
            root++;
            System.out.println(str + " is inserted!");
        }
        else
            System.out.println("The tree is full!");
    }

    // Preorder traversal
    void preorder(int index){
        if (index>root)
            return;
        System.out.println(arr[index]+" ");
        preorder(index*2);
        preorder(index*2+1);
    }
    void preorder(){
        preorder(root);
    }

    // Inorder traversal
    void inorder(int index){
        if (index>root)
            return;
        inorder(index*2);
        System.out.println(arr[index]+" ");
        inorder(index*2+1);
    }
    void inorder(){
        inorder(root);
    }

    // Postorder traversal
    void postorder(int index){
        if (index>root)
            return;
        postorder(index*2);
        postorder(index*2+1);
        System.out.println(arr[index]+" ");
    }
    void postorder(){
        postorder(root);
    }

    // Level order traversal
    void print(){
        for (int i = 1; i <= root &&  arr != null; i++) {
            System.out.print("| "+arr[i]+" |");
        }
    }

    // delete BT
    void deleteTree(){
        try {
            arr= null;
            System.out.println("\nThe Tree has been deleted successfully!");
        }
        catch (Exception e){
            System.err.print(e);
        }
    }

    public static void main(String[] args) {
        ArrayBinaryTree bt= new ArrayBinaryTree(5);
        bt.isFull();
        bt.insert("abc");
        bt.insert("def");
        bt.insert("ghi");
        bt.insert("jkl");
        bt.insert("mno");
        bt.preorder();
        bt.postorder();
        bt.print();
        bt.deleteTree();
        bt.print();

    }
}
