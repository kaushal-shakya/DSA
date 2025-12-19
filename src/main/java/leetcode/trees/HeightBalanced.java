package leetcode.trees;

import sc.trees.BinaryTree;

import java.util.Scanner;

public class HeightBalanced {
    static boolean isTreeBalanced = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        boolean result = isBalanced(root);
        System.out.println(result);
    }

    private static boolean isBalanced(BinaryTree.Node root){
        height(root);
        return isTreeBalanced;
    }

    private static int height(BinaryTree.Node root)
    {
        if(root==null)
            return 0;

        int h1 = height(root.getLeft());
        int h2 = height(root.getRight());

        if(Math.abs(h1 - h2 ) > 0)
            isTreeBalanced = false;
        return 1 + Math.max(h1, h2);
    }
}
