package sc.dp.knapsack;

import java.util.Arrays;

class UnBoundedKnapsack {

    private int helper_tabulation(int[] value, int[] weight, int capacity) {
        int[] dp = new int[capacity+1];
        dp[0] = 0;

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < value.length; j++) {
                if(weight[j] <= i) {
                    int rbag = i-weight[j];
                    dp[i] = Math.max(dp[i], value[j]+dp[rbag]);
                }
            }
        }

        return dp[capacity];
    }

//    private int helper_memoization(int capacity, int[] value, int[] weight, int[] dp) {
//        if(capacity <= 0)
//            return 0;
//
//        if(dp[capacity] != -1) return dp[capacity];
//
//        int max = 0;
//        for (int i = 0; i < value.length; i++) {
//            if(weight[i] <= capacity) {
//                max = Math.max(max, helper_memoization(capacity-weight[i], value, weight, dp)+value[i]);
//            }
//        }
//        dp[capacity] = max;
//
//        return dp[capacity];
//    }

//    private int helper_recursive(int capacity, int[] value, int[] weight) {
//
//        if(capacity <= 0)
//            return 0;
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < value.length; i++) {
//            if(weight[i] <= capacity) {
//                max = Math.max(max, helper_recursive(capacity-weight[i], value, weight)+value[i]);
//            }
//        }
//
//        return max;
//    }

    public int solve(int[] A, int[] B, int C) {
        int[] dp = new int[C+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

//        return helper_recursive(C, A, B);
//        return helper_memoization(C, A, B, dp);
        return helper_tabulation(A, B, C);
    }
}


public class UnBoundedKnapsackMain {
    public static void main(String[] args) {

//        int[] value = {2, 3, 5};
//        int[] weight = {3, 4, 7};
//        int capacity = 8;
        int[] value = {14,13,7,5,5,7,13,16,17,1};
        int[] weight = {10,20,9,4,15,4,4,1,15,2};
        int capacity = 80;
        UnBoundedKnapsack zok = new UnBoundedKnapsack();
        System.out.println(zok.solve(value, weight, capacity));
    }
}
