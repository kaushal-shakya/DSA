package scaler.trees;

import java.util.Scanner;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        preorderTraversal(root);

    }

    public static void preorderTraversal(BinaryTree.Node root) {
        if(root == null)
            return;

        System.out.print(root.value + "");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

}
