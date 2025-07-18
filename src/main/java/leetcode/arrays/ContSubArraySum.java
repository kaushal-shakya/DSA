package leetcode.arrays;

public class ContSubArraySum {
    public static void main(String[] args) {
        int[] A = {0,0};
        System.out.println(checkSubarraySum(A, 1));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] p = getPrefixSum(nums);
        if(nums.length < 2)
            return false;
        for(int i = 0; i < nums.length; i++)
        {
            if(p[i]!=0 && p[i]%k == 0)
                return true;
        }

        for(int i = 1; i < nums.length; i++)
        {
            int windowSize = nums.length-i;
            while(windowSize >= 2)
            {
                int diff = p[i+windowSize-1] - p[i-1];
                windowSize--;
                if(diff%k == 0)
                    return true;
            }
        }
        return false;
    }

    public static int[] getPrefixSum(int[] nums)
    {
        int[] p = new int[nums.length];
        p[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            p[i] = p[i-1] + nums[i];
        }
        return p;
    }
}
