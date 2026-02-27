package sc.dp.stringdp;

import java.util.Arrays;

public class PalindromicSubstrCount {
    static int[][] dp = new int[1000][1000];
    static int isPalindrome(String s, int start, int end) {
        if(start >= end)
            return dp[start][end]=1;

        if(s.charAt(start) != s.charAt(end))
            return dp[start][end]=0;

        if(dp[start][end] != -1)
            return dp[start][end];

        int ans = isPalindrome(s, start+1, end-1);
        return dp[start][end]=ans;
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i =0 ; i< 1000; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < n ;i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

class PalidromicSubstring {
    public static void main(String[] args) {
        PalindromicSubstrCount psc = new PalindromicSubstrCount();

    }
}
