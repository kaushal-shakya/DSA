package sc.slidingwindow;

import java.util.HashMap;

public class MinimumWindowString {

    private static boolean check(int[] pFreq, int[] sFreq) {
        for (int i = 0; i < 128; i++) {
            if(pFreq[i] > sFreq[i])
                return false;
        }
        return true;
    }

    //way 2
    public static String minWindow2(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        int[] pFreq = new int[128];
        for(int i=0; i < nt; i++) {
            pFreq[t.charAt(i)]++;
        }

        int l = 0, r = 0, head = 0, len = Integer.MAX_VALUE;
        int[] sFreq = new int[128];

        while (r < ns) {
            if(check(pFreq, sFreq)) {
                if(r-l+1 < len) {
                    head = l;
                    len = r-l;
                }
                sFreq[s.charAt(l)]--;
                l++;
            } else {
                sFreq[s.charAt(r)]++;
                r++;
            }
        }

        return s.substring(head, head+len);
    }

    // way 1
    public static String minWindow(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        int[] freq = new int[128];
        int count = nt;
        // yha pr freq array is doing two things :
        // 1. it is used for tracking the frequency of char in t
        // 2.
        for(int i = 0; i < nt; i++) {
            freq[t.charAt(i)]++;
        }

        int si = 0, ei = 0, len = Integer.MAX_VALUE, head = 0;

        while(ei < ns) {
            if(freq[s.charAt(ei)] > 0) {
                count--;
            }

            freq[s.charAt(ei)]--;
            ei++;

            while(count == 0) { // we have found all the char from pattern into string
                if(ei-si < len) {
                    head = si;
                    len = ei-si;
                }

                // Now we have to again search for better substring
                if(freq[s.charAt(si)] == 0) { // As we were subtracting freq when element is found, count == 0 ensures that
                    //freq at si will be zero, as we have to again search for this char, count++
                    count++;
                }
                freq[s.charAt(si)]++; // freq increase of
                si++;
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(head, head+len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

//        System.out.println(
//                minWindow2(s,t)
//        );

        System.out.println(minWindow(s, t));
    }
}
