package sc.arrays.binarybeyondsortedarrays;

public class LocalMinima {

    static int localMinima(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if( (mid == 0 || arr[mid] < arr[mid-1] ) && (mid == arr.length-1 || arr[mid] < arr[mid+1] ) )
                return ans = arr[mid];
            else if(mid > 0 && arr[mid] > arr[mid-1]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 6, 3, 14, 5, 7, 4};
//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = {23, 8, 15, 2, 3};
        System.out.println(localMinima(arr));
    }
}
