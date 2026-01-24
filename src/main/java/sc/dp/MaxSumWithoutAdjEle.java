package sc.dp;

public class MaxSumWithoutAdjEle {
    public static void main(String[] args) {
//        int[][] A = {{1,2,3,4},{2,3,4,5}};
//        int[][] A = {{2,68},{13,4}};
//        int[][] A = {{28}, {10}};
        int[][] A = {{16,5,54,55,36,82,61,77,66,61},{31,30,36,70,9,37,1,11,68,14}};
        System.out.println(adjacent(A));
    }
    static int max = Integer.MIN_VALUE;
    static int maxIdx = -1;
    static int secondMax = Integer.MIN_VALUE;
    public static int adjacent(int[][] A) {

        int[] B = new int[A[0].length];
        int[] ans = new int[A[0].length];
        for(int i=0; i<A[0].length; i=i+1) {
            B[i] = Math.max(A[0][i], A[1][i]);
        }
        if(B.length == 1)
            return B[0];
        if(B.length == 2) {
            return Math.max(B[0], B[1]);
        }
        ans[ans.length-1] = B[ans.length-1];
        ans[ans.length-2] = B[ans.length-2];
        max = Math.max(ans[ans.length-1], ans[ans.length-2]);
        secondMax = Math.min(ans[ans.length-1], ans[ans.length-2]);
        if(ans[ans.length-1] > ans[ans.length-2]) {
            maxIdx = ans.length-1;
        } else {
            maxIdx = ans.length-2;
        }
        helper(B, ans);
        return max;
    }

    public static void helper(int[] B, int[] ans) {

        for(int i=ans.length-3; i>=0; i--) {
            if(i+1 == maxIdx) { // if maximum value is from adjacent index, then consider next to adjacent as max
                ans[i] = B[i] + secondMax;
            } else {
                ans[i] = B[i] + max;
            }
            if(ans[i] >= secondMax) {
                secondMax = ans[i];
            }
            if(ans[i] >= max) {
                secondMax = max;
                max = ans[i];
                maxIdx = i;
            }
        }

    }
}
