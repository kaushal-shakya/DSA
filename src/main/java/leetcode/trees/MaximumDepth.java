package leetcode.trees;

import scaler.trees.BinaryTree;

import java.util.Scanner;

public class MaximumDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        int ans = maxDepth(root);
        System.out.println(ans);
    }

    private static int maxDepth(BinaryTree.Node root)
    {
        if(root == null)
            return 0;

        int ans1 = maxDepth(root.getLeft());
        int ans2 = maxDepth(root.getRight());

        return 1 + Math.max(ans1, ans2);
    }

}
