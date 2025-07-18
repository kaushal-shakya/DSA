package scaler.recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("madam"));
        System.out.println(solve("malayalam"));
        System.out.println(solve("abcda"));
        System.out.println(solve("radar"));

    }

    public static boolean solve(String s){

        char[] input = s.toCharArray();
        return checkPalidrome(input, 0, input.length-1);
    }

    public static boolean checkPalidrome(char[] input, int start, int end)
    {
        if(start >= end)
            return true;

        if(input[start] != input[end])
            return false;

        return checkPalidrome(input, start+1, end-1);
    }


}
