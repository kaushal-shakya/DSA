package scaler.arrays.prefixsum.application;

public class BeggersOutsideTempleV2 {

    public static void main(String[] args) {
        int[][] queries = { {1, 2, 10}, {2, 3, 20}, {2, 5, 25} };
        int[] A = new int[5];

        int[] B = solve(A, queries);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

    public static int[] solve(int[] A, int[][] queries)
    {
        for(int i = 0; i < queries.length; i++)
        {
            int sindex = queries[i][0];
            int eindex = queries[i][1];
            int value = queries[i][2];

            A[sindex-1] += value;
            if(eindex < A.length)
            {
                A[eindex] -= value;
            }
        }

        return prefixsum(A);
    }

    private static int[] prefixsum(int[] nums)
    {   int[] prefixSumArray = new int[nums.length] ;
        prefixSumArray[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
        }
        return prefixSumArray;
    }
}
