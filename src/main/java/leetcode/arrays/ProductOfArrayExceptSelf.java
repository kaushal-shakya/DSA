package leetcode.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ans = productExceptSelf(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] left = prefixProduct(nums);
        int[] right = suffixProduct(nums);

        for(int i=0; i < nums.length; i++)
        {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    static int[] prefixProduct(int[] A)
    {
        int[] prefix = new int[A.length];
        prefix[0] = 1;
        for(int j = 1; j < A.length; j++)
        {
            prefix[j] = prefix[j-1] * A[j-1];
        }
        return prefix;
    }

    static int[] suffixProduct(int[] A)
    {
        int[] suffix = new int[A.length];
        suffix[A.length-1] = 1;

        for(int j = A.length-2; j >=0 ; j--)
        {
            suffix[j] = suffix[j+1] * A[j+1];
        }

        return suffix;
    }
}
