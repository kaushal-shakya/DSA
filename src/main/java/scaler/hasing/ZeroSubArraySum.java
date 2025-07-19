package scaler.hasing;

import java.util.HashSet;

public class ZeroSubArraySum {
    public static void main(String[] args) {
        int[] A = {-1,1};
        System.out.println(solve(A));
    }

// Calculate prefix sum,
// From prefix sum, if any value is zero => then there is sub array with 0 sum
// If there are duplicates within prefix array => then sub array sum within duplicate elements is zero.

    public static int solve(int[] A) {

        long[] prefix = getPrefixSum(A);
        HashSet<Long> set = new HashSet<>();

        for (long j : prefix) {
            if(j == 0)
                return 1;
            set.add(j);
        }

        if(set.size() != prefix.length)
            return 1;

        return 0;
    }

    public static long[] getPrefixSum(int[] A)
    {
        long[] prefix = new long[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix[i] = prefix[i-1]+A[i];
        }
        return prefix;
    }

}
