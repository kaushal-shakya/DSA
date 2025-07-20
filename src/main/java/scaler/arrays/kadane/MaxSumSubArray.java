package scaler.arrays.kadane;


//Kadane's algorithm
public class MaxSumSubArray {


    public static void main(String[] args)
    {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(A));
    }


    //Intitution : Not consider the sub array as part of the answer if its sum is less than 0.
    //A sub array with a sum less than 0 will always reduce our answer and so this type of sub array
    //can't be a part of the sub array with maximum sum.
    public static int maxSubArray(final int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < A.length; i++)
        {
            sum += A[i];
            if(sum > max)
            {
                max = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return max;
    }

}
