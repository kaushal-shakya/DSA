package sc.arrays.prefixsum;

public class PrefixSuffix {
    public static void main(String[] args) {
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        System.out.println(solve(A, B));

    }

    public static int solve(int[] A, int B) {
        int[] prefix = getPrefixSum(A);
        int[] suffix = getSuffixSum(A);

        int sum = Integer.MIN_VALUE;
        for(int i =  1, j = B-i; i+j<=B; i++)
        {
            sum = Math.max(sum, prefix[i-1] + suffix[B-i-1]);
        }
        return sum;
    }

    // Sum from left to right
    static int[] getPrefixSum(int[] A)
    {
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix[i] = prefix[i-1] + A[i];
        }
        return prefix;
    }

    // Sum from right to left
    static int[] getSuffixSum(int[] A)
    {
        int[] suffix = new int[A.length];
        suffix[0] = A[A.length-1];

        for (int i=A.length-2, j=1; i >= 0; i--, j++) {
            suffix[j] = suffix[j-1] + A[i];
        }
        return suffix;
    }
}
