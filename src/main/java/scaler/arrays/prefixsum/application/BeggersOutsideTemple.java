package scaler.arrays.prefixsum.application;

public class BeggersOutsideTemple {

    public static void main(String[] args) {
        int[][] queries = { {1, 3}, {4, 2}, {2, 1}, {1, -1} };
        int[] A = new int[7];

        int[] B = solve(A, queries);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

    public static int[] solve(int[] A, int[][] queries)
    {
        for(int i = 0; i < queries.length; i++)
        {
            int index = queries[i][0];
            int value = queries[i][1];
            A[index] += value;
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
