package sc.trees;

import java.util.Scanner;

public class SameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first tree : ");
        BinaryTree bt1 = new BinaryTree();
        bt1.populate(scanner);

        System.out.println("Enter second tree : ");
        BinaryTree bt2 = new BinaryTree();
        bt2.populate(scanner);

        System.out.println(isSameTree(bt1.getRoot(), bt2.getRoot()));
    }

    public static boolean isSameTree(BinaryTree.Node p, BinaryTree.Node q) {
        if( p == null && q == null )
            return true;

        if( ( p == null & q != null ) || ( q == null && p != null ) ) {
            return false;
        }

        if(p.value == q.value) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
