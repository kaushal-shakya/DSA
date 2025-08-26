package scaler.arrays.binarybeyondsortedarrays;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 8, 9};
        int B = 3;
        int ans = aggressiveCows(A, B);
        System.out.println(ans);
    }

    public static int aggressiveCows(int[] A, int B) {

        Arrays.sort(A);
        int s = minDistanceBetweenConsecutiveElements(A);
        int e = A[A.length-1] - A[0];
        int ans = 0;
        while(s <= e)
        {
            int mid = s + (e-s)/2;
            if(check(A, B, mid)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }


    static boolean check(int[] A, int k, int mid)
    {
        int count = 1;
        int last = 0;
        for(int i = 0; i < A.length; i++)
        {
            int distance = A[i] - A[last];
            if(distance >= mid){
                last = i;
                count++;
            }
        }
        if(count < k){
            return false;
        }
        return true;
    }

    static int minDistanceBetweenConsecutiveElements(int[] A)
    {
        int minDis = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++)
        {
            minDis = Math.min(minDis, A[i]-A[i-1]);
        }
        return minDis;
    }
}
