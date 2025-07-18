package scaler.hasing;

import java.util.HashSet;
import java.util.Set;

public class LongestLenSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("u"));
    }

    public static int lengthOfLongestSubstring(String A) {
        
        int l = 0, r =0;
        int maxLen = 0;
        int len = 0;
        Set<Character> s = new HashSet<>();

        while(r < A.length()){
            char curr = A.charAt(r);

            if(s.contains(curr)) {
                s.remove(A.charAt(l));
                l++;
            }else
            {
                s.add(curr);
                r++;
                len = r - l;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
