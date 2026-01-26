package sc.dp.knapsack;


import java.util.Arrays;

class RodCutting {

    private int helper_tabulation(int[] rod) {
        int[] dp = new int[rod.length];
        dp[0] = 0;
        dp[1] = rod[1];
        for (int i = 2; i < rod.length; i++) {
            int max = -1;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, rod[j]+dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[rod.length-1];
    }

    private int helper_recursive(int[] rod, int length, int cut ) {
        if(length <= 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            if(length-i >= 0)
                max = Math.max(helper_recursive(rod, length-i, i)+rod[i], max) ;
        }

        return max;
    }

    public int solve(int[] rod) {
        int[] rod_copy = new int[rod.length+1];
        for (int i = 1; i <= rod.length; i++) {
            rod_copy[i] = rod[i-1];
        }
        rod_copy[0]=0;
//        Arrays.stream(rod_copy).forEach(System.out::print);
//        return helper_recursive(rod_copy, rod.length, 0);
        return helper_tabulation(rod_copy);
    }
}

public class RodCuttingMain {
    public static void main(String[] args) {
//        int[] rod = {3, 4, 1, 6, 2};
        int[] rod = {1, 5, 2, 5, 6};
        RodCutting rc = new RodCutting();
        System.out.println(rc.solve(rod));
    }
}
