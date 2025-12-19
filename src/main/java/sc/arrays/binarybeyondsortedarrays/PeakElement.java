package sc.arrays.binarybeyondsortedarrays;

//LC: Problem
public class PeakElement {
    public static void main(String[] args) {
//        int[] A = {1,2};
//        int[] A = {2,3};
        int[] A = {1,1000000000,1000000000};
        System.out.println(A[anyLocalMaxima(A)]);
    }

    public static int anyLocalMaxima(int[] A) {
        return  helper(A, 0, A.length-1) ;
    }

    public static int helper(int[] A, int start, int end)
    {
        int mid = -1;
        while (start <= end)
        {
            mid = start + (end-start)/2;
            if( ( mid == A.length-1 || A[mid] >= A[mid+1] ) &&             // If first element is local maxima
                    ( mid == 0 || A[mid] >= A[mid-1] )    // If last element is local maxima
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
