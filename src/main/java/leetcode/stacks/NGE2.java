package leetcode.stacks;

import java.util.Stack;

public class NGE2 {
    public static void main(String[] args)
    {
        int[] input = {1,2,3,4,3};
        int[] ans = nextGreaterElement2(input);
        for(int val : ans){
            System.out.print( val + " ");
        }
    }

    public static int[] nextGreaterElement2(int[] nums)
    {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1 ; i >=0 ; i--)
        {
            while(!st.isEmpty() && nums[i%n] >= nums[st.peek()])
            {
                st.pop();
            }
            if(i < n ){
                nge[i] = st.isEmpty() ? -1 : nums[st.peek()];
            }
            st.push(i%n);
        }
        return nge;
    }
}
