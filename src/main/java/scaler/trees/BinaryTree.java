package scaler.trees;

import java.sql.SQLOutput;
import java.util.Scanner;

//This implementation is from Kunal Kushwaha you tube series
public class BinaryTree {
    public BinaryTree()
    {

    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value)
        {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

// insert elements
    public void populate(Scanner in){
        System.out.println("Enter the root node value: ");
        int value = in.nextInt();
        root = new Node(value);
        populate(in, root);
    }

    private void populate(Scanner scanner, Node node)
    {
        System.out.println("Do you want to enter left of "+node.value);
        boolean left = scanner.nextBoolean();
        if(left)
        {
            System.out.println("Enter the value of the left of : "+ node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right)
        {
            System.out.println("Enter the value of the right of : "+ node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null)
            return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right , indent + "\t");

    }
}
