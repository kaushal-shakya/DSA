package leetcode.stacks;

import java.util.Stack;
// Leetcode Problem : 84
public class LargestRectangle {
    public static void main(String[] args) {
        int[] A = {8,6,2,5,6,5,7,4};

        System.out.println(largestRectangleArea(A));
    }


    public static int largestRectangleArea(int[] A)
    {
        int[] nsel = getNextSmallestOnLeft(A);
        int[] nser = getNextSmallestOnRight(A);
        int max = 0;
        for(int i = 0; i < A.length; i++)
        {
            int height = A[i];
            int width = nser[i]-nsel[i]-1;
            int currArea = height * width;
            max = Math.max(currArea, max);
        }
        return max;
    }

    public static int[] getNextSmallestOnLeft(int[] A)
    {
        int[] nsel = new int[A.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < A.length; i++)
        {
            while(!st.isEmpty() && A[i] <= A[st.peek()])
            {
                st.pop();
            }

            if(st.isEmpty())
                nsel[i]= -1;
            else {
                nsel[i] = st.peek();
            }
            st.push(i);
        }
        return nsel;
    }

    public static int[] getNextSmallestOnRight(int[] A)
    {
        int[] nser = new int[A.length];
        Stack<Integer> st = new Stack<>();

        for(int i = A.length-1; i >= 0; i--)
        {
            while(!st.isEmpty() && A[i] <= A[st.peek()])
            {
                st.pop();
            }

            if(st.isEmpty())
                nser[i]= A.length;
            else {
                nser[i] = st.peek();
            }
            st.push(i);
        }
        return nser;
    }

}
