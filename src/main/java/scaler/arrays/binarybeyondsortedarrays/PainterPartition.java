package scaler.arrays.binarybeyondsortedarrays;

public class PainterPartition {

    //Intitution : we have to reduce the search space
    // Steps :
    // 1. Find the search space.
    public static void main(String[] args) {
        int A = 1;
        int B = 1000000;
        int[] C = {1000000, 1000000};
        System.out.println(paint(A, B, C) );
    }

    public static int paint(int A, int B, int[] C) {

        long[] result = helper(C);
        long start = result[0]; //min amount to time taken under constraints paint a board, unlimited painters
        long end = result[1]; //max amount of time taken under constraints to paint all board, if we have 1 painters

        //searchSpace = [minValue, maxValue]
        long ans = 0;
        while(start <= end)
        {
            long mid = start + (end-start)/2;
            boolean possible = isPossible(C, A, mid);
            if(possible){
                ans = mid % 10000003;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int) ( ( (ans % 10000003) * ( B % 10000003) ) % 10000003 ); // do take care of brackets
    }

    public static long[] helper(int[] C)
    {
        long[] temp = new long[2];
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for( long i : C )
        {
            sum += i % 10000003;
            max = Math.max(max, i);
        }
        temp[0] = max;
        temp[1] = sum;

        return temp;
    }

    static boolean isPossible(int[] A, int k, long mid)
    {
        long noOfPainters = 1; // start with one painter
        long sum = 0; // initially painted no board
        for(long len : A)
        {
            sum = (sum+len)%10000003; // board painted by current painter
            if(sum > mid) { // if painter painted mid no of boards, add new painter
                sum = len; // Why not 0 ? Because on condition break, we would have already included the mid+1,
                            // which leads to condition failure. So we have to keep track of that board
                noOfPainters++;
            }
        }
//        if(noOfPainters > k)
//            return false;
//
//        return true;
        return noOfPainters <= k; // replacement of above if and return statement, for subject clarity
    }
}
