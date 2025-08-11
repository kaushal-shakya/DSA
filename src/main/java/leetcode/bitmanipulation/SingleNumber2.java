package leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.LinkedList;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] input = {2,3,3,2,3,2,7,6,6,6};
        System.out.println(singleNumber(input));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
