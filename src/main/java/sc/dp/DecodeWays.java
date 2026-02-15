package sc.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class DecodeWays {
    ArrayList<String> allDecodeMsg = new ArrayList<>();
    private static int helper(String s, int start, char[] letters) {
        if(start == s.length())
            return 1;

        if(s.charAt(start) == '0')
            return 0;

        int lA = helper(s, start+1, letters);
        int rA = 0;
        if(s.charAt(start) == '1' || s.charAt(start) == '2' && s.charAt(start+1) <= '6')
               rA = helper(s, start+2, letters);

        return lA + rA;
    }


    public static void main(String[] args) {
        String s = "226";
        char[] letters = new char[27];
        for(int i = 0; i < 26; i++) {
            letters[i+1] = (char) ('A' + i);
        }

        int ans = helper(s, 0,  letters);
        System.out.println(ans);
    }

}
