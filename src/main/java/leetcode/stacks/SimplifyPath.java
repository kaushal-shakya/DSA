package leetcode.stacks;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String s1 = "/../"; //expected output = "/"
        String s2 = "/home/";
        String s3 = "/home//foo/";
        String s4 = "/home/user/Documents/../Pictures";
        String s5 = "/../";
        String s6 = "/.../a/../b/c/../d/./";
        String s7 = "/.";
        String s8 = "/.../"; // expected output = "/..."
        String s9 = "/..a/";
        String s10 = "/a/./b/";
        System.out.println(simplifyPath(s1));
    }

    public static String simplifyPath(String path) {
        Stack<Character> st = new Stack<>();
        st.push(path.charAt(0));
        int countOfDots = 0;
        for(int i = 1; i < path.length();)
        {
            char curr = path.charAt(i);
            st.push(curr);
            if(curr == '.') {
                countOfDots++;
            }

            if(i < path.length()-1 && countOfDots == 2 && path.charAt(i+1) == '/')
            {
                int countOfSlashes = 2;
                while(countOfSlashes > 0 ) {
                    if(!st.isEmpty() && st.peek() == '/')
                        countOfSlashes--;
                    st.pop();
                }
            }
            else if(
                    i < path.length()-1
                    && ( countOfDots == 2 )
                    && path.charAt(i+1) != '/'
            ) {
                countOfDots = 0;
            }

            i++;
        }
        //TODO: reset countOfDots
        //TODO: removing last /
        StringBuilder preResult = new StringBuilder("");
        while (!st.isEmpty()){
            preResult.append(st.pop());
        }
        return preResult.reverse().toString();
    }

}
