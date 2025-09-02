package leetcode.trees;

import scaler.trees.BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class IsSymmetric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        boolean ans = isSymmetric(root);
        System.out.println(ans);
    }

    //Recursion approach
    public static boolean isSymmetric(BinaryTree.Node root){
        return false;
    }


//    public static boolean isSymmetric(BinaryTree.Node root) {
//        if(root == null)
//            return true;
//
//        ArrayList<ArrayList<BinaryTree.Node>> ll = new ArrayList<>();
//
//        ArrayList<BinaryTree.Node> list = new ArrayList<>();
//        if(root.getLeft() != null){
//            list.add(root.getLeft());
//        }else{
//            list.add(null);
//        }
//
//        if(root.getRight() != null){
//            list.add(root.getRight());
//        }else{
//            list.add(null);
//        }
//        ll.add(list);
//
//        int i = 0;
//        while(!ll.isEmpty())
//        {
//            ArrayList<BinaryTree.Node> ar = new ArrayList<>();
//            ArrayList<BinaryTree.Node> curr = ll.get(i);
//            int size = ll.get(i).size(); // size of
//            while(size > 0)
//            {
//                BinaryTree.Node exRight = curr.remove(size-1); // extreme right in list
//                BinaryTree.Node exLeft = curr.remove(0); // extreme left in list
//
//                if( exLeft != null && exRight != null && exLeft.getValue() != exRight.getValue())
//                    return false;
//
//                if(exLeft != null && exLeft.getLeft() != null){
//                    ar.add(exLeft.getLeft());
//                } else if(exLeft != null) {
//                    ar.add(null);
//                }
//                if(exLeft != null && exLeft.getRight() != null){
//                    ar.add(exLeft.getRight());
//                } else if(exLeft != null) {
//                    ar.add(null);
//                }
//
//                if(exRight != null && exRight.getLeft() != null){
//                    ar.add(exRight.getLeft());
//                } else if(exRight != null) {
//                    ar.add(null);
//                }
//                if(exRight != null && exRight.getRight() != null){
//                    ar.add(exRight.getRight());
//                } else if(exRight != null) {
//                    ar.add(null);
//                }
//                size = size - 2;
//            }
//            if(ar.size() > 0)
//                ll.add(ar);
//            ll.remove(0);
//        }
//        return true;
//    }

}
