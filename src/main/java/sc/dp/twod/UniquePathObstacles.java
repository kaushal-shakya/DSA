package sc.dp.twod;


import java.util.Arrays;

class Solution {
    //Memoization => top down
    public int uniquePathsWithObstacles(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] B = new int[row+1][col+1];
        int[][] dp = new int[row+1][col+1];
        for(int i=0; i<B.length; i++){
            for(int j=0; j<B[i].length; j++){
                if(i == 0 || j == 0) {
                    B[i][j] = 1;
                    dp[i][j] = -1;
                } else
                {
                    B[i][j] = A[i-1][j-1];
                    dp[i][j] = -1;
                }
            }
        }
        System.out.println(Arrays.deepToString(B));
        int ans = helper(B, 1,1,B.length-1, B[0].length-1, dp);
        System.out.println(Arrays.deepToString(dp));

        return dp[1][1];
    }

    int ans = 0;
    public int helper(int[][] B, int sx, int sy, int dx, int dy, int[][] dp) {
        if(sx == dx && sy == dy && B[sx][sy] == 0)
            return dp[sx][sy]=1;

        if( sx < 1 || sx > dx || sy < 1 || sy > dy || B[sx][sy] == 1 ){
            if(sx >= 1 && sx <= dx && sy <= dy && sy >= 1) {
                return dp[sx][sy] = 0;
            }
            return 0;
        }


        if(dp[sx][sy] != -1) return dp[sx][sy];
        int lA = helper(B, sx, sy+1, dx, dy, dp);
        int rA = helper(B, sx+1, sy, dx, dy, dp);

        return dp[sx][sy] = ans = lA+rA;
    }


}

public class UniquePathObstacles {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0}, {0,1,0}, {0,0,0}};
//        int[][] matrix = {{0,1}};
//        int[][] matrix = {{0, 0, 0},{1, 1, 1}, {0, 0, 0}};
//        int[][] matrix = {{1,0}};
        Solution s = new Solution();
        int ans = s.uniquePathsWithObstacles(matrix);
        System.out.println(ans);
    }
}
