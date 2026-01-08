package sc.trees;

import java.util.Scanner;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        bt.populate(scanner);
        flatten(bt.getRoot());
        bt.display();
    }

    public static void flatten(BinaryTree.Node a) {
        if(a == null)
            return ;

        if(a.left != null) {
            BinaryTree.Node curr = a.left;
            while(curr.right != null) {
                curr = curr.right;
            }
            curr.right = a.right;
            a.right = null;
            a.right = a.left;
            a.left = null;
        }

        flatten(a.left);
        flatten(a.right);
    }
}
