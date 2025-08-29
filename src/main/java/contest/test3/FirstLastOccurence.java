package contest.test3;

import java.util.Arrays;

public class FirstLastOccurence {
    public static void main(String[] args) {
        int[] A = {4,7,8,10,11,11,12};
        int[] result = firstlastOccurence(A, 11);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] firstlastOccurence(int[] A, int target)
    {
        int [] ans = new int[2];
        ans[0] = firstOccurence(A, target);
        ans[1] = lastOccurence(A, target);

        return ans;
    }

    private static int lastOccurence(int[] A, int target) {
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
                start = mid+1;
            }
        }
        return ans;
    }


    private static int firstOccurence(int[] A, int target)
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
