package sc.dp.stringdp;

//5. Longest Palindromic Substring leetcode
class LongestPalindromicSubstring {

//    private boolean checkPalindrome1(int i, int j, String s) {
//        if(i >= j)
//            return true;
//
//        if(s.charAt(i) == s.charAt(j))
//            return  checkPalindrome1(i+1, j-1, s);
//
//        return false;
//    }

    // private boolean checkPalindrome(int i, int j, String s) {
    //     while(i <= j) {
    //         if(s.charAt(i) != s.charAt(j))
    //             return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    private int checkPalindrome(int i, int j, String s, int[][] dp) {
        if(i >= j)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = checkPalindrome(i+1, j-1, s, dp);
        dp[i][j] = ans;
        if(ans == 1 && s.charAt(i) == s.charAt(j))
            return dp[i][j]= 1;
        else
            return dp[i][j]=0;
    }

    String ans = "";
    private void helper(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp.length; j++) {
                if(i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = -1;
            }
        }

        int maxlength = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(checkPalindrome(i, j, s, dp) == 1) {
                    if(j-i+1 >= maxlength) {
                        maxlength = j-i+1;
                        ans=(s.substring(i,j+1)) ;
                    }
                }
            }
        }
    }

    public String longestPalindrome(String s) {
        helper(s);
        return ans;
    }
}


public class LongestPalindromicSubstringMain {
    public static void main(String[] args) {
        LongestPalindromicSubstring lc = new LongestPalindromicSubstring();
//        System.out.println(lc.longestPalindrome("babad"));
        System.out.println(lc.longestPalindrome("mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd"));

    }
}