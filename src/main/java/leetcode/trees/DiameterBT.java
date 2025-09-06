package leetcode.trees;

import scaler.trees.BinaryTree;

import java.util.List;
import java.util.Scanner;

public class DiameterBT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }

    public static int diameterOfBinaryTree(BinaryTree.Node root) {
        int max = 0;
        solve(root, max);
        return max;
    }

    private static int solve(BinaryTree.Node root, int max){
        if(root == null) return 0;

        int left = solve(root.getLeft(), max);
        int right = solve(root.getRight(), max);
        max = Math.max(left+right, max);

        return Math.max(left, right)+1;

    }
}
