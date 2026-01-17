package sc.trees;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//Leetcode problem 508
public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);

        findFrequentTreeSum(bt.getRoot());
    }

    public static int[] findFrequentTreeSum(BinaryTree.Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);

        System.out.println(map);
        return new int[1];
    }

    static int sum = 0;
    public static int helper(BinaryTree.Node root, HashMap<Integer, Integer> map) {
        if(root == null)
            return 0;

        int lA = helper(root.left, map);
        int rA = helper(root.right, map);

        sum = root.value + lA + rA;

        if(!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum)+1);
        }

        return sum;
    }
}
