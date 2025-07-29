package leetcode.arrays.kadane;

public class MaxProductSA {
    public static void main(String[] args) {
//        int[] A = {2,3,-2,4};
//        int[] A = {0,2};
//        int[] A = {-2,0,-1};
//        int[] A = {2,-3,-4};
        int[] A = {-1,-2,-9,-6};
        System.out.println(maxProduct2(A));
    }

//    Brute force
    public static int maxProduct1(int[] nums)
    {
        int current_product = 1;
        int global_product = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                while (i <= j)
                {
                    current_product *= nums[i];
                    i++;
                }

                global_product = Math.max(current_product, global_product);
            }
        }
        return global_product;
    }

//    negative * negative = positive (can turn a small product into a large one).
//    positive * negative = negative (can turn a large product into a small one).
//    any_number * 0 = 0 (resets the product).
    public static int maxProduct2(int[] nums) {
        int global_max = nums[0];
        int current_min_product = nums[0];
        int current_max_product = nums[0];

        for(int i = 1; i < nums.length; i++){

            int temp_max_product = current_max_product;

//          Negative numbers can flip the sign and potentially turn a very small (negative) product into a very large (positive) one, we can't just track the maximum product.
//          We need to track both the maximum and minimum products ending at the current position.
//
            current_max_product = Math.max(nums[i], Math.max(temp_max_product * nums[i], current_min_product * nums[i]) );


            current_min_product = Math.min(nums[i], Math.min(temp_max_product * nums[i], current_min_product * nums[i]) );
            global_max = Math.max(global_max, current_max_product);
        }

        return global_max;

    }
}
