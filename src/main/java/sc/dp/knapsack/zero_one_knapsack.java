package sc.dp.knapsack;

import java.util.Arrays;

class ZeroOneKnapsack {

    private int helper_tabulation(int[] A, int[] B, int capacity) {
        int[][] dp = new int[A.length+1][capacity+1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int rej = dp[i-1][j];
                int sel = 0;
                int w = B[i-1];
                int v = A[i-1];
                if(w <= j)
                    sel  = dp[i-1][j-w] + v;
                dp[i][j] = Math.max(rej, sel);
            }
        }
        return dp[A.length][capacity];
    }

    private int helper_memoization(int i, int j, int[] A, int[] B, int[][] dp) {
        if(i < 0 || j == 0)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int reject = helper_memoization(i-1, j, A, B, dp);
        int pick = 0;
        if(B[i] <= j)
            pick = helper_memoization(i-1, j-B[i], A, B, dp) + A[i];

        return dp[i][j] = Math.max(reject, pick);
    }

    private int helper_recursive(int i, int j, int[] A, int[] B) {

        if(i < 0 || j == 0)
            return 0;
        int reject = helper_recursive(i-1, j, A, B);
        int pick = 0;
        if(B[i] <= j)
            pick = helper_recursive(i-1, j-B[i], A, B) + A[i];

        return Math.max(reject, pick);
    }

    public int solve(int[] A, int[] B, int C) {
        int[][] dp = new int[A.length+1][C+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
//        return helper_recursive(A.length-1, C, A, B);
//        return helper_memoization(A.length-1, C, A, B, dp);
        return helper_tabulation(A, B, C);
    }
}


public class zero_one_knapsack {
    public static void main(String[] args) {

        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        ZeroOneKnapsack zok = new ZeroOneKnapsack();
        System.out.println(zok.solve(value, weight, capacity));
    }
}
