package sc.arrays.dp;

import java.util.Arrays;

class FindFibonacci {

    //Recursive approach
    int getFibonacci1(int n) {
        if( n <= 1)
            return n;

        return getFibonacci1(n-1) + getFibonacci1(n-2);
    }

    //Top down - Memoization - recursive
    private int getFibonacciHelper(int n, int[] dp) {
        if(n <= 1)
            return n;

        if(dp[n] != -1) return dp[n];
        dp[n] = getFibonacciHelper(n-1, dp) + getFibonacciHelper(n-2, dp);
        return dp[n];
    }

    int getFibonacci2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return getFibonacciHelper(n, dp);
    }

    //Bottom up - Tabulation - iterative
    int getFibonacci3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i <=n ;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

public class Fibonacci {

    public static void main(String[] args) {
        FindFibonacci fn = new FindFibonacci();

        System.out.println(fn.getFibonacci1(45));
        System.out.println(fn.getFibonacci2(45));
        System.out.println(fn.getFibonacci3(45));
    }
}
