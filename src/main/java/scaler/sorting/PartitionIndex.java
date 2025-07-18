package scaler.sorting;

public class PartitionIndex {
    public static void main(String[] args) {
        int[] A = {6, 2, 0, 4, 5};
        System.out.println(partition(A));
    }

    public static int partition(int[] arr) {
        // Code Here
        return helper(arr, 0, arr.length-1);
    }

    public static int helper(int[] A, int s, int e)
    {
        int pivot = A[e];
        int l  = s;
        int r = e-1;

        while (l <= r){
            if(A[l] <= pivot)
                l++;
            else if (A[r] > pivot) {
                r--;
            }else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }

        int temp = A[e-1];
        A[e-1] = A[r];
        A[r] = temp;

        return  r+1;
    }
}
