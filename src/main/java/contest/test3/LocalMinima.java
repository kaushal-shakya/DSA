package contest.test3;

public class LocalMinima {
    public static void main(String[] args) {
        int[] A = {3,6,1,0,9,15,8};
        System.out.println(localMinima(A));
    }

    //reduce search space
    public static int localMinima(int[] A)
    {
        int start = 0;
        int end = A.length-1;

        while (start <= end)
        {
            int mid = start + (end-start)/2;

            if( ( mid == 0 || A[mid] < A[mid-1] )  &&
                    (mid == A.length-1 || A[mid] < A[mid+1])
                )
            {
                return A[mid];
            } else if (mid == 0 || A[mid] < A[mid-1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }
        return -1;
    }


}
