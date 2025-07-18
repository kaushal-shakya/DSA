package scaler.sorting;

public class MergeAlgo {
    public static void main(String[] args) {
        int[] A = {3,29,3,0,-1,9,43,89,2,5};
        solve(A);

        for (int i = 0; i < A.length; i++)
        {
            System.out.print(A[i] + " ");
        }
    }

    public static void solve(int[] A) {
        int[] temp = new int[A.length];
        mergesort(A, temp,0, A.length-1);
    }

    public static void mergesort(int[] A, int[] temp, int l, int r)
    {
        if(l == r){
            return ;
        }

        int mid = l + (r-l)/2;
        mergesort(A, temp,l, mid);
        mergesort(A, temp,mid+1, r);

        merge(A, temp, l, mid, r);
    }

//    this is for merging two sorted array, How ?
//
    public static void merge(int[] A, int[] temp, int l, int mid, int r) {
        int i = l;
        int j = mid+1;
        int k = l;

        while( i <= mid && j <= r )
        {
            if ( A[i] <= A[j] ) {
                temp[k] = A[i];
                i++;
                k++;
            } else
            {
                temp[k] = A[j];
                j++;
                k++;
            }
        }

        while( i <= mid){
            temp[k] = A[i];
            i++;
            k++;
        }

        while( j <= r){
            temp[k] = A[j];
            j++;
            k++;
        }

        for(int m = l; m <= r; m++) {
            A[m] = temp[m];
        }
    }
}
