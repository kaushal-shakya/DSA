package contest.test3;

import java.util.Arrays;

public class AllocateMinimumPages {
    public static void main(String[] args) {
//        int[] A = {12,34,67,90};
//        int k = 2;
        int[] A = {15, 17, 20};
        int k = 5;
//        int[] A = {15, 10, 19, 10, 5, 18, 7};
//        int k = 5;

        System.out.println(binarySearchOnMinimization(A, k));
    }

    public static int binarySearchOnMinimization(int[] A, int B){

        if(A.length < B) // if books is less than total number of students, this means few students will left without any books
            return -1;

        int start = getAnsMinRange(A);
        int end = getAnsMaxRange(A);

        int ans = -1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if(isPossibleConfiguration(A, B, mid)){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossibleConfiguration(int[] A,
                                                   int k, // k is no of students
                                                   int mid){ // mid is maximum allowed pages
        int students = 1;
        int sum = 0; // no of pages allocated initially to student
        for(int a : A){
            if(a > mid) // if a single book page is greater than maximum allowed page
                return false;
            sum += a;
            if( sum > mid ) {
                sum = a;
                students++;
            }
        }

        return students <= k;
    }

    private static int getAnsMaxRange(int[] A){
        return Arrays.stream(A).sum();
    }

    private static int getAnsMinRange(int[] A){
        int max = Integer.MIN_VALUE;
        for(int a : A){
            max = Math.max(max, a);
        }
        return max;
    }
}
