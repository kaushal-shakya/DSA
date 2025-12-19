package sc.arrays.binary;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
//        int[] A = {1, 1, 7};
        int []A = {1,1,2,3,3,4,4,8,8};
        System.out.println(search(A));

    }

    private static int search(int[] A ){
        int s = 0, e = A.length-1;
        int mid = 0;
        while (s <= e)
        {
            mid = s + (e-s)/2;
            if(mid-1 >= 0 && mid+1 <= A.length-1 && A[mid] != A[mid-1] && A[mid] != A[mid+1] ){
                return A[mid];
            }else if(mid-1 >= 0 && A[mid] == A[mid-1]) // mid-1 is first occurrence
            {
                if((mid-1) % 2 == 0){
                    s = mid + 1;
                } else {
                    e = mid - 2;
                }
            }else { // this block means mid is the first occurrence
                if(mid % 2 == 0) {
                    s = mid + 2;
                }else {
                    e = mid - 1;
                }
            }
        }
        return A[mid];
    }
}