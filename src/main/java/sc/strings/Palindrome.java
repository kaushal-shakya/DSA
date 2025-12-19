package sc.strings;

public class Palindrome {
    public static void main(String[] args) {
        String input = "malayalam";
        String input2 = "abab";

        System.out.println("Is " + input + " Palindrome ? " + isPalindrome(input));
        System.out.println("Is " + input2 + " Palindrome ? " + isPalindrome(input2));

    }

    public static boolean isPalindrome(String input)
    {
        int i = 0;
        int j = input.length()-1;

        while (i<j)
        {
            if(input.charAt(i) == input.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
