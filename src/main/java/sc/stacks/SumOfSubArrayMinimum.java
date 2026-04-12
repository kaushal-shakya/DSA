package sc.stacks;

import java.util.Stack;

public class SumOfSubArrayMinimum {
    static int n = 0;

    static int[] getNextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if(st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }

        return nse;
    }

   static int[] getPrevSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if(st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }

        return pse;
    }

    public static int sumSubarrayMins(int[] arr) {
        n = arr.length;
        long M = 1000000007;
        long sum = 0;
        int[] nse = getNextSmallerElement(arr);
        int[] pse = getPrevSmallerElement(arr);

        for(int i=0; i<n; i++) {
            long ls = i - nse[i];
            long rs = pse[i] - i;

            long totalWays = ls * rs;

            long totalSum = arr[i] * totalWays;
            sum = (sum + totalSum) % M;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        int[] A = {71,55,82,55};
        System.out.println(sumSubarrayMins(A));
    }
}
