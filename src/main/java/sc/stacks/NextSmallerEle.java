package sc.stacks;

import java.util.*;

public class NextSmallerEle {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
//        System.out.println(result.size());
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if(st.isEmpty())
                result.add(-1);
            else
                result.add(arr[st.peek()]);

            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3 };
        ArrayList<Integer> l = nextSmallerEle(arr);
        Collections.reverse(l);
        System.out.println(l);
    }
}
