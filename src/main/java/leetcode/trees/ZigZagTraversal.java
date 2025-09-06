package leetcode.trees;

import scaler.trees.BinaryTree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        BinaryTree.Node root = bt.getRoot();
        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }

    public static List<List<Integer>> zigzagLevelOrder(BinaryTree.Node root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<BinaryTree.Node> dqu = new LinkedList<>();
        if(root != null)
            dqu.add(root);

        boolean doReverse = false; // even : L to R / odd : R to L

        while(!dqu.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            int size = dqu.size();
            while( size > 0 )
            {
                if(!dqu.isEmpty()) {
                    BinaryTree.Node t = dqu.remove();
                    ll.add(t.getValue());
                    if(t.getLeft() != null)
                        dqu.add(t.getLeft());

                    if(t.getRight() != null)
                        dqu.add(t.getRight());

                    size--;
                }
            }

            if(doReverse){
                Collections.reverse(ll);
            }
            doReverse = !doReverse;
            result.add(ll);
        }
        return result;
    }
}
