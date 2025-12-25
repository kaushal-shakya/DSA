package sc.trees;

import java.util.Scanner;

public class InvertTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);

        BinaryTree.Node ans = invertTree(bt.getRoot());
        bt.setRoot(ans);
        bt.display();
    }

    public static BinaryTree.Node invertTree(BinaryTree.Node root) {
        if(root == null)
            return root;

        BinaryTree.Node lAns = invertTree(root.left);
        BinaryTree.Node rAns = invertTree(root.right);

        root.left = rAns;
        root.right = lAns;

        return root;
    }
}
