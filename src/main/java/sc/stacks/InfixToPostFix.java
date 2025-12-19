package sc.stacks;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String s1 = "x^y/(a*z)+b";
        String s2 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(solve(s2));
    }

    public static String solve(String A)
    {
        HashMap<Character, Integer> priority = new HashMap();
        priority.put('^', 3);
        priority.put('/', 2);
        priority.put('*', 2);
        priority.put('+', 1);
        priority.put('-', 1);

        return helper(A, priority);
    }

    public static String helper(String A, HashMap<Character, Integer> priority)
    {
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i = 0;
        while (i < A.length())
        {
            char curr = A.charAt(i);
            if( (curr >= 'A' && curr <= 'Z') || (curr >= 'a' && curr <= 'z') || (curr >= '0' && curr <= '9') )
            {
                ans += curr;
            } else if (curr == '(') {
                st.push(curr);
            } else if (curr == ')') {
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            } else {
                if(st.isEmpty())
                    st.push(curr);
                else {
                    char top = st.peek(); // top element
                    int topElePriority = priority.getOrDefault(top, -1);
                    int currElePriority = priority.getOrDefault(curr, -1);
                    while (!st.isEmpty() && currElePriority <= topElePriority) {
                        ans += st.peek();
                        st.pop();
                        if(!st.isEmpty())
                        {
                            top = st.peek(); // top element
                            topElePriority = priority.getOrDefault(top, -1);
                        }
                    }
                    st.push(curr);
                }
            }

            i++;
        }
        while (!st.isEmpty()){
            ans += st.peek();
            st.pop();
        }
        return ans;
    }
}
