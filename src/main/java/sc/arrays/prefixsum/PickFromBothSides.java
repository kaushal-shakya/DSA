package sc.arrays.prefixsum;

public class PickFromBothSides {
    public static void main(String[] args) {
        int[] A = {-533,-666,-500,169,724,478,358,-38,-536,705,-855,281,-173,961,-509,-5,942,-173,436,-609,-396,902,-847,-708,-618,421,-284,718,895,447,726,-229,538,869,912,667,-701,35,894,-297,811,322,-667,673,-336,141,711,-747,-132,547,644,-338,-243,-963,-141,-277,741,529,-222,-684,35};
        System.out.println(solve(A, 48));
//        int[] A = {5, -2, 3 , 1, 2};
//        System.out.println(solve(A, 3));
    }

    public static int solve(int[] A, int B) {
        int[] prefix = getPrefixSum(A);
        int[] suffix = getSuffixSum(A);

//        for(int i = 0; i < prefix.length; i++)
//        {
//            System.out.print(prefix[i]+" ");
//        }
//        System.out.println();
//
//        for(int i = 0; i < suffix.length; i++)
//        {
//            System.out.print(suffix[i]+" ");
//        }

        int sum = Integer.MIN_VALUE;
        sum = Math.max(suffix[B-1], prefix[B-1]);
//        sum = Math.max(sum, );
        for(int i =  1, j = B-i; i+j<=B; i++)
        {
            int p = prefix[i-1];
            int s = suffix[j-1];
            sum = Math.max(sum, p+s);
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
