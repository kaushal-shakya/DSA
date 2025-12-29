package sc.strings;

import java.util.Arrays;
import java.util.List;

public class ReverseStringWords {
    public static void main(String[] args) {
        String s = "Shahrukh is the best actor";
        System.out.println(solve(s));
    }

    public static String solve(String A) {
        A = A.trim();
        String[] s = A.split(" ");

        int l = 0;
        int r = s.length-1;
        while(l < r)
        {
            String temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

        List<String> reversedArray = Arrays.asList(s);
        return String.join(" ", reversedArray);
    }
}
