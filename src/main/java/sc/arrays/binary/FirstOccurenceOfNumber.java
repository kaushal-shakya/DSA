package sc.arrays.binary;

public class FirstOccurenceOfNumber {
    public static void main(String[] args) {
        int[] A = {-5,-5,-3,0,0,1,5,5,5,5,5,5,5,10,10,15,15} ;
        System.out.println(firstOccurence(A, 5, 0, A.length-1));

    }

    private static int firstOccurence(int[] A, int target, int start, int end)
    {
        int ans = 0;


        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(A[mid] < target){
                start = mid+1;
            } else if (A[mid] > target) {
                end = mid-1;
            }else {
                ans = mid;
                end = mid-1;
            }
        }

        return ans;
    }


}
