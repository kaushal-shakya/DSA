package leetcode.arrays;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] A = {2,3,1,2,4,3};
        int B = 7;
//        System.out.println(minSubArrayLen(B, A));
        System.out.println(minSubArrayLen2(B, A));
    }

// Optimized Approach
    public static int minSubArrayLen2(int target, int[] nums) {
    int length = Integer.MAX_VALUE;
    int left=0, right = 0;
    int currentWindowSum = nums[left];

    while(right != nums.length-1)
    {
        if(currentWindowSum < target){
            right++;
            currentWindowSum += nums[right];
        }else {
            if(right-left < length)
                length = right-left;
            currentWindowSum -= nums[left];
            left++;
        }
    }

    return length;
}



    //  O(n)  Approach one
    public static int minSubArrayLen(int target, int[] nums) {
        int[] prefix = getprefixsum(nums);
        int length = 0;

        //edge case : sum of all the array elements is not equal to and greater than target
        if(prefix[nums.length-1] < target)
        {
            return 0;
        }
        // Initially got length
        for(int i = 0; i < nums.length; i++)
        {
            if(prefix[i] < target){
                length++;
            }else
            {
                length++;
                break;
            }
        }

        for(int i = 1; i < nums.length && i+length-2 < nums.length; i++){
            int value = prefix[i+length-2] - prefix[i-1];
            if(value >= target)
            {
                length = length - 1;
            }

        }

        return length;
    }

    static int[] getprefixsum(int[] nums)
    {
        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        return prefixsum;
    }
}
