package sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

    static List<Integer> temp = new ArrayList<>();
//    "pick/don't pick" recursion
    private static void helper(int start, int n, int k, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList<>(temp));
            return ;
        }

        if(start > n)
            return;

        temp.add(start);
        helper(start+1, n, k-1, result);
        temp.remove(temp.size()-1);
        helper(start+1, n, k, result);

    }

//    For-Loop Backtracking
    private void helper(int n, int k, List<List<Integer>> result, int x) {
        if(k == 0) {
            result.add(new ArrayList<>(temp));
            return ;
        }

        for(int i=x; i<=n; i++) {
            temp.add(i);
            helper(n, k-1, result, i+1);
            if (!temp.isEmpty())
                temp.remove(temp.size() - 1);

        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, k, result);
        return result;
    }
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        System.out.println(combine(n, k));
    }
}
