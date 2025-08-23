package leetcode.trees;

import scaler.trees.BinaryTree;

import java.util.*;

public class IterativePreOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        List<Integer> result = preOrderIterative(root);
        System.out.println(result);
    }

    public static List<Integer> preOrderIterative(BinaryTree.Node root)
    {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> st = new Stack<>();
        st.push(root);
        helperPreOrder(root, st, result);
        return result;
    }

    public static void helperPreOrder(BinaryTree.Node root, Stack<BinaryTree.Node> st, List<Integer> result)
    {
        while(!st.isEmpty())
        {
            BinaryTree.Node n1 = st.pop();
            result.add(n1.getValue());

            if(n1.getRight() != null)
                st.push(n1.getRight());

            if(n1.getLeft() != null)
                st.push(n1.getLeft());
        }
    }


}
