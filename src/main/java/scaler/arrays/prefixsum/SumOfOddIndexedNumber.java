package scaler.arrays.prefixsum;

import java.util.Arrays;

public class SumOfOddIndexedNumber {
    public static void main(String[] args) {
        int[] A = {2, 8, 3, 9, 15};
        int[][] B = {{1, 4}, {0,2}, {2,3}};
        int[] result = sumOfOddIndexedElements(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static int[] sumOfOddIndexedElements(int[] A, int[][] B) {
        int[] po = getPrefixSumOddArray(A);

        for (int i = 0; i < po.length; i++) {
            System.out.println(po[i]);
        }

        int[] result = new int[B.length];

        for(int i = 0; i < B.length; i++)
        {
            if(B[i][0] == 0){
                result[i] = po[B[i][1]];
            } else
            {
                result[i] = po[B[i][1]] - po[B[i][0]-1] ;
            }
        }
        return result;
    }

    static int[] getPrefixSumOddArray(int[] A)
    {
        int[] po = new int[A.length];
        po[0] = 0;

        for(int i = 1; i < A.length; i++)
        {
            if(i%2 != 0)
            {
                po[i] = po[i-1]+A[i];
            }else{
                po[i] = po[i-1];
            }
        }
        return po;
    }
}
