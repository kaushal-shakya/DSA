package sc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<Integer> temp = new ArrayList<>();
    private static void helper(int[] candidates, int target, List<List<Integer>> result, int k) {
        if(target == 0) {
            return ;
        }
        for(int i=k; i<candidates.length; i++) {
            if (target >= candidates[i]) {
                temp.add(candidates[i]);
                int newTarget = target - candidates[i];
                if (newTarget == 0) {
                    ArrayList<Integer> temp1 = new ArrayList<>(temp);
                    result.add(temp1);
                }
                helper(candidates, newTarget, result, i);
                if (!temp.isEmpty())
                    temp.remove(temp.size() - 1);
            }
        }

        return ;
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, result, 0);

        return result;
    }

    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
