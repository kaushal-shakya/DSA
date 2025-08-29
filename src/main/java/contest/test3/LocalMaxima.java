package contest.test3;

public class LocalMaxima {
    public static void main(String[] args) {
        int[] A = {1,2,1,3,5,6,4};
        System.out.println(A[localMaxima(A)]);
    }

    private static int localMaxima(int[] A)
    {
        int start = 0;
        int end= A.length-1;

        int mid = -1;
        while (start <= end)
        {
            mid = start + (end-start)/2;
            if( ( mid == A.length-1 || A[mid] > A[mid+1] ) &&             // If first element is local maxima
                    ( mid == 0 || A[mid] > A[mid-1] )    // If last element is local maxima
            )
            {
                return mid;
            } else if ( (mid == 0) || ( A[mid] < A[mid+1] ) ) { //
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

}
