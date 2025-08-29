package contest.test3;

public class BinarySearch {
    public static void main(String[] args) {

    }


    public int indexOfTargetElement(int[] A, int target)
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
            }
        }
        return -1;
    }

}
