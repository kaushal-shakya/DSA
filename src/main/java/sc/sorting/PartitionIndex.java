package sc.sorting;

public class PartitionIndex {
    public static void main(String[] args) {
        int[] A = {6, 2, 0, 4, 5};
        System.out.println(partition(A));
    }

    public static int partition(int[] arr) {
        // Code Here
        return helper(arr, 0, arr.length-1);
    }

//   Idea : we will be keep all pivot less than element to left of pivot
//      Rest to the right of pivot
    public static int helper(int[] A, int s, int e)
    {
        int pivot = A[e];
        int l  = s;
        int r = e-1;

        //at loop end, l will be on element greater than pivot
        while (l <= r){
            //if A[left] is LTE to pivot, it means valid position. So increment l
            if(A[l] <= pivot)
                l++;
            else if (A[r] > pivot) { //if A[right] is GT pivot, it means valid position. So decrement r
                r--;
            }else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }
// At loop end, l will be on element greater than pivot
// swap pivot with l index element will do the partitioning
        int temp = A[l];
        A[l] = pivot;
        A[e] = temp;

        return  l;
    }
}
