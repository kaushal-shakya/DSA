package sc.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {1, 4, 10, 2, 1, 5};
        quicksort(A, 0,A.length-1);
        for(int i : A)
        {
            System.out.print(i + " ");
        }
    }

    public static void quicksort(int[] A, int s, int e)
    {
        if(s >= e)
            return;

        int pivotIndex = PartitionIndex.helper(A, s,e);
        quicksort(A, s, pivotIndex-1);
        quicksort(A, pivotIndex+1, e);
    }

}
