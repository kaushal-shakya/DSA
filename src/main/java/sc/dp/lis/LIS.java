package sc.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {

    //LIS using binary search
    public int helper_binary_search(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int index = binarySearch(sorted, nums[i]);

            if(index == sorted.size()) {
                sorted.add(nums[i]);
            } else {
                sorted.set(index, nums[i]);
            }
        }

        return sorted.size();
    }

    private int binarySearch(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

    public int helper_bottomup(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLIS = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLIS = Math.max(dp[i], maxLIS );
                }
            }
        }

        return maxLIS;
    }

    public int helper_topdown(int[] nums, int idx, int prev, int[][] dp) {
        if(idx == nums.length) {
            if(prev >= 0 && prev != Integer.MIN_VALUE)
                dp[idx][prev]=0;

            return 0;
        }

        if(  prev >= 0 && prev != Integer.MIN_VALUE && dp[idx][prev] != Integer.MIN_VALUE)
            return dp[idx][prev];

        int pick = 0;
        if(prev == Integer.MIN_VALUE || (idx < nums.length && nums[prev] < nums[idx])) {
            pick = 1 + helper_topdown(nums, idx+1,  idx, dp);
        }

        int npick = helper_topdown(nums, idx+1, prev, dp);
        if(prev >= 0 && prev != Integer.MIN_VALUE)
            dp[idx][prev] = Math.max(pick, npick);

        return Math.max(pick, npick);
    }

    public int helper_recursive(int[] nums, int idx, int prev) {
        if(idx == nums.length) {
            return 0;
        }

        int pick = 0;
        if(idx < nums.length && prev < nums[idx]) {
            pick = 1 + helper_recursive(nums, idx+1,  nums[idx]);
        }

        int npick = helper_recursive(nums, idx+1, prev);

        return Math.max(pick, npick);
    }

    public int lengthOfLIS(int[] nums) {
//        return helper_recursive(nums, 0, Integer.MIN_VALUE);

//        int[][] dp = new int[2501][2501];
//        for(int i=0; i < dp.length; i++) {
//            Arrays.fill(dp[i], Integer.MIN_VALUE);
//        }
//        return helper_topdown(nums, 0, Integer.MIN_VALUE, dp);

        return helper_bottomup(nums);
    }
}

class LISMain {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LIS l = new LIS();
        System.out.println(l.helper_bottomup(nums));
    }
}
