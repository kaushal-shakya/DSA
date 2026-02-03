package sc.dp;

public class CoinSumInfinite {

    // List<Integer> temp = new ArrayList<>();
//// TLE
    // private void helper(int[] coins, int target, List<List<Integer>> result, int k) {
    //     if(target == 0) {
    //         result.add(new ArrayList(temp));
    //         return ;
    //     }
    //     for(int i=k; i<coins.length; i++) {
    //         if (target >= coins[i]) {
    //             temp.add(coins[i]);
    //             helper(coins, target - coins[i], result, i);
    //             temp.remove(temp.size() - 1);
    //         }
    //     }

    //     return ;
    // }

    public static int coinchange2(int[] A, int B) {
        // Arrays.sort(A);
        // List<List<Integer>> result = new ArrayList<>();

        // helper(A, B, result, 0);

        // return result.size();

        int[] dp = new int[B+1];
        dp[0] = 1;
        for(int i=0; i < A.length; i++) {
            for(int j=0; j <= B; j++) {
                if(A[i] <= j)
                    dp[j] = (dp[j]+dp[j-A[i]]) % (int)(Math.pow(10,6)+7);
            }
        }

        return dp[B];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int value = 4;
        System.out.println(coinchange2(coins, value));
    }
}
