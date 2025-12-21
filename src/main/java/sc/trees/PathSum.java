package sc.trees;

import java.util.Scanner;

public class PathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        System.out.println(hasPathSum(bt.getRoot(), 1000));
    }

    private static boolean hasPathSum(BinaryTree.Node root, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
        {
            if(root.value == targetSum){
                return true;
            }
            return false;
        }
        boolean lt = hasPathSum(root.left, targetSum-root.value);
        boolean rt = hasPathSum(root.right, targetSum-root.value);

        if(lt || rt)
            return true;
        else
            return false;
    }
}
