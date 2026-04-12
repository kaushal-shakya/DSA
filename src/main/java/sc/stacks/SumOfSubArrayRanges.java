package sc.stacks;

import java.util.Stack;

public class SumOfSubArrayRanges {
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

    static int[] getNextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if(st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        return nge;
    }

    static int[] getPrevGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if(st.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }
            st.push(i);
        }

        return pge;
    }
    public static int subArrayRanges(int[] A) {
        n = A.length;
        int M = 1000000007;
        int[] nse = getNextSmallerElement(A);
        int[] pse = getPrevSmallerElement(A);
        int[] nge = getNextGreaterElement(A);
        int[] pge = getPrevGreaterElement(A);

        long sum = 0;

        for(int i=0; i<n; i++) {
            long maxCount = ((long)(nge[i]-i) * (i-pge[i])) % M;;
            long minCount = ((long)(nse[i]-i) * (i-pse[i])) % M;;

            long diff = ((maxCount - minCount) % M + M) % M;

            sum = (sum + (A[i] * diff) % M) % M;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
//        int[] A = {4,7,3,8};
        int[] A = {994390,986616,976849,979707,950477,968402,992171,937674,933065,960863,980981,937319,951236,959547,991052,991799,992213,941294,978103,997198,960759,988476,963517,980366,921767,979757,977912,983761,981869,947454,930202,999086,973538,999798,996446,944001,974217,951595,942688,975075,970973,970130,897109,927660,862233,997130,986068,954098,978175,889682,988973,996036,969675,985751,977724,881538,988613,924230,906475,915565,986952,975702,994316,964011,986848,983699,949076,989673,981788,929094,988310,926471,994763,999736,980762,973560,996622,934475,998365,966255,998697,998700,911868,983245,996382,996992,953142,994104,987303,853837,960626,904203,998063,977596,977868,996012,946345,949255,988138,996298,954933,965036,886976,998628,990878,953725,916744,985233,919661,970903,986066};
        System.out.println(subArrayRanges(A));
    }
}
