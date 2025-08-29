package contest.test3;

import java.util.Scanner;

public class FirstOccurenceBS {
    public static void main(String[] args) {
        int[] A = {4,7,8,10,11,11,12};
        System.out.println(firstOccurence(A, 11));

    }

    public static int firstOccurence(int[] A, int target)
    {
        int start = 0;
        int end = A.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;

            if(target > A[mid])
            {
                start = mid+1;
            } else if(target < A[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}
