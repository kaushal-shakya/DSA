package sc.trees;

import java.util.Scanner;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);

        System.out.println(maxPathSum(bt.getRoot()));
    }
    static int maxAbTk = -1002;
    public static int maxPathSum(BinaryTree.Node root) {
        if(root.left == null && root.right == null)
            return root.value;
        int ans = helper(root);
        if(maxAbTk > ans)
            return maxAbTk;
        return ans;
    }

    public static int helper(BinaryTree.Node root) {
        if(root == null)
            return 0;

        int lA = helper(root.left);
        int rA = helper(root.right);

        if(lA == 0 && rA != 0){
            if(maxAbTk < Math.max(root.value+rA, Math.max(rA, root.value)))
                maxAbTk =  Math.max(root.value+rA, Math.max(rA, root.value));
            return Math.max(root.value+rA, Math.max(rA, root.value));
        } else if(lA != 0 && rA == 0) {
            if(maxAbTk < Math.max(root.value+lA, Math.max(lA, root.value)))
                maxAbTk = Math.max(root.value+lA, Math.max(lA, root.value));
            return Math.max(root.value+lA, Math.max(lA, root.value));
        } else if(lA == 0 && rA == 0) {
            if(root.value > maxAbTk)
                maxAbTk = root.value;  //update only if root.value > maxAbTk

            return root.value;
        } else {
            if(Math.max(root.value, Math.max(root.value+lA, Math.max(root.value+rA, root.value+lA+rA))) > maxAbTk ){
                maxAbTk = Math.max(root.value, Math.max(root.value+lA, Math.max(root.value+rA, root.value+lA+rA))) ;
            }
            return Math.max(root.value,  Math.max(root.value+lA, root.value+rA));
        }
    }
}
