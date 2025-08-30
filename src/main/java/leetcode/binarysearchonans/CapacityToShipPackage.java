package leetcode.binarysearchonans;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

import java.util.Arrays;

public class CapacityToShipPackage {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(solve(A, days));
    }

    private static int solve(int[] A, int B)
    {
        int start = getAnsMinRange(A);
        int end = getAnsMaxRange(A);

        int ans = 0;
        while (start <= end) {
            int mid = start + (end-start) / 2;

            if(isPossibleConfiguration(A, B, mid)){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return ans;
    }

    //This function is to check whether
    private static boolean isPossibleConfiguration(int[] A, int k, int mid) // mid represents configuration of ship weight
    {
        int maxAllowedWeight = mid;
        int ships = 1;
        int weight = 0;
        for(int a : A){
            weight += a;
            if(weight > maxAllowedWeight){
                weight = a;
                ships++;
            }
        }
        return ships <= k;
    }


    private static int getAnsMinRange(int[] A){
        int max = Integer.MIN_VALUE;
        for(int a : A){
            max = Math.max(max, a);
        }
        return max;
    }

    private static int getAnsMaxRange(int[] A){
        return Arrays.stream(A).sum();
    }


}
