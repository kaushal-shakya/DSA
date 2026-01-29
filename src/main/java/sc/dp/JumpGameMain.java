package sc.dp;


import java.util.Arrays;

//55. Jump Game leetcode
class JumpGame {


    private boolean helper_tabulation(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        int i = 1;
        while (i <= nums.length-1) {
            int j = i-1;
            while (j >= 0) {
                if(dp[j] && j+nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
                j--;
            }
            i++;
        }
        return dp[nums.length-1];
    }

    private boolean helper(int[]nums, int start, int[] dp) {
        if(start == nums.length-1) {
            dp[start+1] = 1;
            return true;
        }

        if(start < 0 || start >= nums.length) {
            dp[start+1] = 0;
            return false;
        }

        if(dp[start+1] != -1) {
            dp[start+1]= 0;
            return false;
        }

        boolean isPossibleToReachLast = false;
        int maxPossibleSteps = nums[start];
        for(int i=1; i <= maxPossibleSteps; i++) {
            isPossibleToReachLast = (isPossibleToReachLast) || helper(nums, start+i, dp);
        }

        if(isPossibleToReachLast){
            dp[start+1] = 1;
        } else
            dp[start+1] = 0;

        return dp[start+1] == 1;
    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
//        return helper(nums, 0, dp);
        return helper_tabulation(nums);
    }
}

public class JumpGameMain {
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(jg.canJump(nums));
    }
}
