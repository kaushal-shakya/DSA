package sc.dp.twod;

public class NDigitsNum {
    public static void main(String[] args) {
        int A = 75, B = 22;
        long[][] dp = new long[A+1][B+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                    dp[i][j] = -1;
            }
        }
//        System.out.println(Arrays.deepToString(dp));
//        System.out.println(solve1(A,B, true));
        System.out.println(solve(A, B, true, dp));
    }

    // Top-down Approach / Memoization
    public static long solve(int A, int B, boolean isFirstDig, long[][] dp) {
        if(A == 0 && B == 0) return 1;
        if(A == 0 && B > 0) return 0;
        if(dp[A][B] != -1) return dp[A][B];
        long ans = 0;
        int start = isFirstDig == true ? 1 : 0;
        for(int i=start; i<=Math.min(B, 9); i++) {
            ans += solve(A-1, B-i, false, dp);
        }

        return dp[A][B] = ans % (int) (Math.pow(10,9)+7);
    }

    //Recursive
    public static int solve1(int A, int B, boolean isFirstDig) {
        if(A == 0 && B == 0)
            return 1;

        if(A == 0 && B > 0)
            return 0;

        int ans = 0;
        int start = isFirstDig == true ? 1 : 0;
//        if(dp[A][B] != )
            for(int i=start; i<Math.min(B+1, 9); i++) {
                ans += solve1(A-1, B-i, false);
            }

        return ans;
    }
}
