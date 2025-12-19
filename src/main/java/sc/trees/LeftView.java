package sc.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        ArrayList<Integer> result = leftView(root);
        System.out.println(result);
    }

    public static ArrayList<Integer> leftView(BinaryTree.Node root) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        helper1(root, queue, result);
        return result;
    }

    public static void helper1(BinaryTree.Node root, Queue<BinaryTree.Node> queue, ArrayList<Integer> result)
    {
        if(root == null)
            return;

        while (!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i<size; i++){
                BinaryTree.Node curr = queue.peek();
                if(i == 0)
                    result.add(curr.value);

                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);

                queue.poll();


            }

        }
    }
}
