package sc.dp.catalon;

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1; dp[1] = 1;

        for(int i=2; i <= A; i++) {
            int ans = 0;
            for(int j=1; j<=i; j++) {
                ans += dp[j-1]* dp[i-j];
            }
            dp[i] = ans;
        }
        return dp[dp.length-1];
    }
}
