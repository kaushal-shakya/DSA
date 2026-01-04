package sc.trees.bst;

import sc.trees.BinaryTree;

import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        System.out.println(kthSmallest(bt.getRoot(), 4));
    }

    static int  k = 0;
    public static int kthSmallest(BinaryTree.Node A, int B) {
        k = B;
        return helper(A);
    }

    public static int helper(BinaryTree.Node A)
    {
        if( A == null)
            return -1;
        int leftAns = helper(A.getLeft());
        if(leftAns != -1)
        {
            return leftAns;
        }
        k--;
        if(k == 0)
        {
            return A.getValue();
        }
        return helper(A.getRight());
    }
}
