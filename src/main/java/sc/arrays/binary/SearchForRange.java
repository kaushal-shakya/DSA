package sc.arrays.binary;

public class SearchForRange {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10 };
        int[] result=searchRange(A, 1);
        for (int i : result)
            System.out.println( i + " ");
    }

    public static int[] searchRange(final int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int[] ans = {-1,-1};

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(A[mid] == target)
            {   ans[0] = mid;
                ans[1] = mid;
                for(int i = mid-1; i >= 0; i--){
                    if(A[i] == target)
                        ans[0] = i;
                }
                for(int i = mid+1; i < A.length; i++){
                    if(A[i] == target)
                        ans[1] = i;
                }

                return ans;
            } else if(A[mid] > target)
            {
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}
