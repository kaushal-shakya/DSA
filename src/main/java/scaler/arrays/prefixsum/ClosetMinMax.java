package scaler.arrays.prefixsum;

import java.util.Arrays;

public class ClosetMinMax {
    public static void main(String[] args) {
        int[] A = {343,291,963,165,152};

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int maxIndex = 0;
        int minIndex = 0;
        int max = A[0];
        int min = A[0];
        int diff = Integer.MAX_VALUE;

//        for (int i = 0; i < A.length; i++) {
//            if(A[i] > max)
//                max = A[i];
//            if(A[i] < min)
//                min = A[i];
//        }

        boolean isMaxFound = false;
        boolean isMinFound = false;
        for(int i = 1; i < A.length; i++)
        {
            if(A[i] >= max) {
                max = A[i];
                maxIndex = i;
                isMaxFound = true;
            }
            if(A[i] <= min){
                min = A[i];
                minIndex = i;
                isMinFound = true;
            }

            if(isMaxFound && isMinFound){
                if(Math.abs(maxIndex-minIndex) < diff){
                    diff = Math.abs(maxIndex - minIndex)+1;
                }
            }

        }

        return diff;
    }
}
