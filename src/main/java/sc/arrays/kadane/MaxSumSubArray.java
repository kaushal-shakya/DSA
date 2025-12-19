package sc.arrays.kadane;


//Kadane's algorithm
public class MaxSumSubArray {


    public static void main(String[] args)
    {
//        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] A = {-2, 4, -5, 4, -5, 9, 4};
        int[] B = {-2,-1,-3};
        System.out.println(maxSubArray(B));
        System.out.println(maxSubArray2(B));
    }


    //Intitution : Not consider the subarray as part of the answer if its sum is less than 0.
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
                sum = 0; // This implementation implicitly handles the decision of "starting a new subarray or extending the current one."
            }
        }
        return max;
    }

    //  less code approach
    public static int maxSubArray2(final int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int j : A) {
            sum = Math.max(sum + j, j);
            max = Math.max(sum, max);
        }
        return max;
    }

}
