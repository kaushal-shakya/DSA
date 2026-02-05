package sc.greedy;

public class DistributeCandy {


    public static int candy(int[] A) {
        int[] left = new int[A.length];
        left[0] = 1;
        // scanning from left
        for (int i = 1; i < A.length; i++) {
            if(A[i] > A[i-1])
                left[i] = left[i-1] + 1;
            else
                left[i] = 1;
        }

        int[] right = new int[A.length];
        right[A.length-1] = 1;
        // scanning from left
        for (int i = A.length-2; i >= 0; i--) {
            if(A[i] > A[i+1])
                right[i] = right[i+1] + 1;
            else
                right[i] = 1;
        }

        int candies = 0;
        for (int i =0; i< A.length; i++) {
            candies += Math.max(left[i], right[i] );
        }

        return candies;
    }

    public static void main(String[] args) {
        int[] A = {1, -5, 2, 1};
        System.out.println(candy(A));
    }
}
