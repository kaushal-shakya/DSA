package sc.dp;

public class JumpGame2 {
    private int helper(int[] A, int idx) {
        if(idx == A.length-1)
            return 0;

        if(idx >= A.length)
            return 0;

        if(A[idx] == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= A[idx]; i++) {
            if(idx+i <= A.length-1 && A[idx+i] != 0)
                ans = Math.min(ans, 1+ helper(A, idx+i));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[] A) {
        if(A[0] == 0)
            return -1;
        return helper(A, 0);
    }

}

class JumpGameMain2 {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 4};
        JumpGame2 obj = new JumpGame2();
        System.out.println(obj.solve(A));
    }
}
