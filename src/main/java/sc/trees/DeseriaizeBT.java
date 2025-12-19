package sc.trees;

import java.util.*;

public class DeseriaizeBT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
//        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));

//        BinaryTree.Node root = deserialize(input);
        BinaryTree bt = new BinaryTree();
        bt.display();
//        System.out.println(result);
    }

//
}
