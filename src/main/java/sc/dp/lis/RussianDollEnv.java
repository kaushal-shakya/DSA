package sc.dp.lis;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pair {
    int width;
    int height;

    public Pair(int w, int h) {
        width = w;
        height = h;
    }
}

public class RussianDollEnv {

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

    public int helper(int[] nums, int idx, int prev) {
        if(idx == nums.length) {
            return 0;
        }

        int pick = 0;
        if(idx < nums.length && prev < nums[idx]) {
            pick = 1 + helper(nums, idx+1,  nums[idx]);
        }

        int npick = helper(nums, idx+1, prev);

        return Math.max(pick, npick);
    }

    public int maxEnvelopes(int[][] envelopes) {
        ArrayList<Pair> env = new ArrayList<Pair>();
        for (int i = 0; i < envelopes.length; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];

            env.add(new Pair(w, h));
        }

        env.sort(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.width < p2.width) {
                    return -1;
                } else if (p1.width > p2.width) {
                    return 1;
                } else {
                    if (p1.height < p2.height) {
                        return 1;
                    } else if (p1.height > p2.height) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < env.size(); i++) {
//            System.out.println(env.get(i).width + " " + env.get(i).height);
            nums[i] = env.get(i).height;
        }

        return helper(nums, 0, Integer.MIN_VALUE);
    }
}

class RussianDollMain {
    public static void main(String[] args) {
        int[][] envelopes = {{2,3},{4,6},{3,7},{4,8}};
        RussianDollEnv rde = new RussianDollEnv();
        System.out.println(rde.maxEnvelopes(envelopes));
    }
}
