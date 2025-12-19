package sc.trees.bst;

import sc.trees.BinaryTree;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        BinaryTree root = solve(A, 0, A.length-1);
        root.display();
    }

    private static BinaryTree solve(int[] A, int s, int e)
    {
//        if(s == e){
//            BinaryTree t = new BinaryTree();
//            BinaryTree.Node n1 = new BinaryTree.Node(A[s]);
//            t.setRoot(n1);
//            return t;
//        }
//
//        int mid = s + (e-s)/2;
//        BinaryTree t1 = new BinaryTree();
//        BinaryTree.Node n2 = new BinaryTree.Node(A[mid]);
//        t1
//        n2.setLeft(solve(A, s, mid-1));
//        n2.setRight(solve(A, mid+1, e));
//
//        return n2;
        return null;
    }
}
