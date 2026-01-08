package sc.trees;

import java.util.Scanner;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        bt.populate(scanner);
        System.out.println(sumNumbers(bt.getRoot()));
    }

    static int ans = 0;
    public static int sumNumbers(BinaryTree.Node root) {

        return helper(root, String.valueOf(root.value));
    }

//    static int leftAns = 0;
//    static int rightAns = 0;
    public static int helper(BinaryTree.Node root, String a) {
        if(root.left == null && root.right == null)
            return Integer.parseInt(a);
        int leftAns = 0;
        if(root.left != null)
            leftAns = helper(root.left, a.concat(String.valueOf(root.left.value)));
        int rightAns = 0;
        if(root.right != null)
            rightAns = helper(root.right, a.concat(String.valueOf(root.right.value)));

        return leftAns + rightAns;
    }
}
