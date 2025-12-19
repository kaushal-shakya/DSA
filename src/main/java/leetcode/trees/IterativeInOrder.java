package leetcode.trees;

import sc.trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class IterativeInOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }

    public static List<Integer> inorderTraversal(BinaryTree.Node root)
    {
        BinaryTree.Node node = root;
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> st = new Stack<>();

        while(!st.isEmpty() || node != null)
        {
            while (node.getLeft() != null){
                st.push(node);
                node = node.getLeft();
            }

            node = st.pop();
            result.add(node.getValue() );

            if(node.getRight() != null )
                node = node.getRight();
        }

        return result;
    }
}
