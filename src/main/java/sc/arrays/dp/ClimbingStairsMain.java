package sc.arrays.dp;

import java.util.Arrays;

class ClimbingStairs {

    private int climbStairsHelper(int n, int[] dp) {
        if(n <= 2) {
            dp[n] = n;
            return n;
        }


        if(dp[n] != -1) return dp[n];
        dp[n] = (climbStairsHelper(n-1, dp) + climbStairsHelper(n-2, dp)) ;
        return dp[n] % (int)(Math.pow(10,9)+7);
    }

    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        return climbStairsHelper(A, dp);
    }
}

public class ClimbingStairsMain {
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(7));
    }
}
