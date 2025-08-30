package contest.test3;

//Problem Statement: https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
// Given an array/list of length ‘N’, where the array/list represents the boards and each element of the
// given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards.
// Consider that each unit of a board takes 1 unit of time to paint.
// You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the
// constraint that any painter will only paint the continuous sections of boards.

//Example 1:
//Input Format: N = 4, boards[] = {5, 5, 5, 5}, k = 2
//Result: 10
//Explanation: We can divide the boards into 2 equal-sized partitions, so each painter gets 10 units of the board and the
// total time taken is 10.
//
//Example 2:
//Input Format: N = 4, boards[] = {10, 20, 30, 40}, k = 2
//Result: 60
//Explanation: We can divide the first 3 boards for one painter and the last board for the second painter.
//
//We can allocate the boards to the painters in several ways but it is clearly said in the question that we have to allocate
// the boards in such a way that the painters can paint all the boards in the minimum possible time. The painters will work
// simultaneously.

import java.util.Arrays;

public class PainterPartitionTest {

    public static void main(String[] args) {
        int A = 4;
        int B = 2;
        int[] C = {5,5,5,5};
        System.out.println(binarySearchOnMinimization(C, B, A) );
    }

    //Binary Search on Answer ( Minimization )
    public static int binarySearchOnMinimization(int[] A, int painters, int boards)
    {
        int maxRangeOfAnswer = getMaxRange(A);
        int minRangeOfAnswer = getMinRange(A);
        int ans = 0;
        int start = minRangeOfAnswer, end = maxRangeOfAnswer;
        while (start <= end){
            int mid = start + (end - start) / 2; // try with

            if(isPossibleToPaintByGivenPainters(A, painters, mid)){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return (int) (ans % 10000003); //  take care of brackets

    }


    private static boolean isPossibleToPaintByGivenPainters(int[] A, int painters, long mid)
    {
        long noOfPainters = 1;
        long sum = 0;
        for(int i = 0; i < A.length; i++)
        {
            sum += A[i];
            if(sum > mid) {
                sum = A[i];

                noOfPainters++;
            }
        }
        return noOfPainters <= painters;
    }



    private static int getMinRange(int[] A) {
        int max = Integer.MIN_VALUE;
        for(int i : A){
            max = Math.max(max, i);
        }
        return max;
    }

    private static int getMaxRange(int[] A) {
        return Arrays.stream(A).sum();
    }

}
