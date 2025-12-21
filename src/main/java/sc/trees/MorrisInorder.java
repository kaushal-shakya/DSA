package sc.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorrisInorder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        List<Integer> result = morrisInorderTraversal(bt.getRoot());
        System.out.println(result);
    }

    public static List<Integer> morrisInorderTraversal(BinaryTree.Node A) {
        List<Integer> result = new ArrayList<>();
        BinaryTree.Node curr = A;
        while(curr != null)
        {
            if(curr.left == null){
                result.add(curr.value);
                curr = curr.right;
            } else {
                BinaryTree.Node temp = curr.left;
                while(temp.right != null && temp.right != curr)
                {
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }
                if(temp.right == curr){
                    temp.right = null;
                    result.add(curr.value);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
