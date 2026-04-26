package sc.arrays.prefixsum;

import java.util.HashMap;

public class LongestSASumZero {

    static int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        map.put(sum, -1);
        for(int i=0; i < arr.length; i++) {
            sum += arr[i];

            if(map.containsKey(sum) ) {
                int firstIdxOfSum = map.get(sum);
                maxLength=Math.max(maxLength, i-firstIdxOfSum);
            } else {
                map.put(sum, i);
            }

        }
        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public static void main(String[] args) {
//        int[] A = {15, -2, 2, -8, 1, 7, 10, 23};
//        int[] A = {1, 0, -4, 3, 1, 0};
//        int[] A = {2, 10, 4};
        int[] A = {-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println(maxLength(A));
    }
}
