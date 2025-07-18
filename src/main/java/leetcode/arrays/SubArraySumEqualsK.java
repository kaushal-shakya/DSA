package leetcode.arrays;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        System.out.println(subarraySum(arr, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSumArray = prefixSum(nums);
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i; j < nums.length; j++)
            {
                if(i == 0){
                    if(prefixSumArray[j] == k)
                        count++;
                }
                else
                {
                    if(i-1 >= 0 && (prefixSumArray[j]- prefixSumArray[i-1]) == k)
                        count++;
                }
            }
        }
        return count;
    }

    public static int[] prefixSum(int[] nums)
    {   int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        return prefixsum;
    }
}
