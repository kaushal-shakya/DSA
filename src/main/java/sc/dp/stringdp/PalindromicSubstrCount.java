package sc.dp.stringdp;

public class PalindromicSubstrCount {

    boolean isPalindrome(String s, int start, int end) {
        if(start >= end)
            return true;

        if(s.charAt(start) != s.charAt(end))
            return false;

        boolean ans = isPalindrome(s, start+1, end-1);
        return ans;
    }


}

class PalidromicSubstring {
    public static void main(String[] args) {
        PalindromicSubstrCount psc = new PalindromicSubstrCount();

    }
}
