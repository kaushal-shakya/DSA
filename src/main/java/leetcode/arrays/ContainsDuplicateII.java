package leetcode.arrays;

import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        System.out.println(containsNearbyDuplicateUsingHashMap(arr, 1));
    }

    // Using HashMap
    public static boolean containsNearbyDuplicateUsingHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                int previousIndex = map.get(nums[i]);
                if(Math.abs(i - previousIndex) > k){
                    map.replace(nums[i], i);
                }else{
                    return true;
                }
            }
        }
        return false;
    }




}
