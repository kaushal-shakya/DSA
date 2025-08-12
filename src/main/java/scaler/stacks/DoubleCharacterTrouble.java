package scaler.stacks;

import java.util.Stack;

public class DoubleCharacterTrouble {

    public static void main(String[] args) {
        String a = "aaaaa";
        System.out.println(solve(a));
    }

    public static String solve(String A)
    {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < A.length(); i++)
        {
            if (!st.empty() && st.peek() == A.charAt(i)) {
                st.pop();
            } else st.push(A.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty())
        {
            char el = st.pop();
            res.append(el);
        }

        return reverseWithLoop(res.toString());
    }

    public static String reverseWithLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i); // Very inefficient
        }
        return reversed;
    }
}
