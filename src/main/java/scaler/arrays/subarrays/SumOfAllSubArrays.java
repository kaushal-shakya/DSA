package scaler.arrays.subarrays;

public class SumOfAllSubArrays {

    public static void main(String[] args) {

    }


    public int maxSubarray(int A, int B, int[] C) {
        int[] prefixsum = getPrefixSum(C, A);
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < A; i++)
        {
            for(int j = i; j < A; j++)
            {   int sum = -1;
                if( i == 0 )
                {
                    sum = prefixsum[j];
                }else
                {
                    sum = prefixsum[j] - prefixsum[i-1];
                }

                if(sum > result && sum <= B)
                {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static int[] getPrefixSum(int[] C, int A)
    {
        int[] prefixsum = new int[A];
        prefixsum[0] = C[0];
        for(int i = 1; i < A; i++)
        {
            prefixsum[i] = prefixsum[i-1] + C[i];
        }
        return prefixsum;
    }
}
