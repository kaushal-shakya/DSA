package scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SerializeBT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        ArrayList<Integer> result = serialize(root);
        System.out.println(result);
    }

    public static ArrayList<Integer> serialize(BinaryTree.Node root)
    {
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
            while (size > 0){
                BinaryTree.Node curr = queue.poll();
                result.add(curr.value);

                if(curr.left != null) {
                    queue.add(curr.left);
                } else if(curr.value != -1){
                    queue.add(new BinaryTree.Node(-1));
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                } else if(curr.value != -1){
                    queue.add(new BinaryTree.Node(-1));
                }
                size--;
            }
        }
    }
}
