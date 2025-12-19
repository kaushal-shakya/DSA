package sc.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        ArrayList<ArrayList<Integer>> result = levelOrderTraversal(root);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTree.Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        helper1(root, queue, result);
        return result;
    }

    // correctly prints level   [[1], [2], [3], [4], [5], [6]]
//    public static void helper(BinaryTree.Node root, Queue<BinaryTree.Node> queue, ArrayList<ArrayList<Integer>> result)
//    {
//        if(root == null)
//            return;
//
//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(root.value);
//        result.add(al);
//        queue.add(root.left);
//        queue.add(root.right);
//        queue.poll();
//        helper(queue.peek(), queue, result);
//    }

    // now print [ [1], [2, 3], [4, 5, 6] ]
    public static void helper1(BinaryTree.Node root, Queue<BinaryTree.Node> queue, ArrayList<ArrayList<Integer>> result)
    {
        if(root == null)
            return;

        while (!queue.isEmpty()){
            ArrayList<Integer> al = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                BinaryTree.Node curr = queue.poll();
                al.add(curr.value);

                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                size--;
            }
            result.add(al);
        }
    }
}
