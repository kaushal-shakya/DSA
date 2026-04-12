package sc.stacks;

import java.util.Stack;
import java.util.StringTokenizer;

public class SimplifyPaths {
    public static void main(String[] args) {
//        String path =  "/.../a/../b/c/../d/./";
//        String path =  "/../";
//        String path =  "/home/user/Documents/../Pictures";
//        String path =  "/home//foo/";
//        String path =  "/home/";
//        String path =  "/././../";
//        String path =  "/.../a/../";
        String path =  "/a/../../b/../c//.//";

        Stack<String> st = new Stack<>();

        StringTokenizer stringTokenizer = new StringTokenizer(path, "/");
        while(stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if(token.equals("..")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else if(token.equals(".")) {
                continue;
            }else {
                st.push(token);
            }
        }

        String result = "";
        while(!st.isEmpty()) {
            result = "/" + st.pop() + result;
        }

        System.out.println(result);
    }
}
