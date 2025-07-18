package scaler.arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[] A = {52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70};
        int B = 19;

        System.out.println(solve(A,B));
    }

    public static int solve(int[] A, int B)
    {
        int minSwaps = 0;
        int windowSize = 0;
        //calculate window size, check elements less than or equal to B
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] <= B)
                windowSize++;
        }

        //Handling first window, check in window where element greater than B
        for(int i = 0; i < windowSize; i++)
        {
            if(A[i] > B)
                minSwaps++;
        }

        int startIndex = 0;
        int endIndex = windowSize;
        int currentWindowSwaps = minSwaps;
        while (endIndex < A.length)
        {
//          check incoming and outgoing element in window
//          if outgoing element is less than or equal to B, no change to minSwaps otherwise minSwaps-- ;
            if(A[startIndex] > B)
                currentWindowSwaps--;

//            if incoming element is less than or equal to B minSwaps, otherwise min
            if(A[endIndex] > B)
                currentWindowSwaps++;

            minSwaps = Math.min(currentWindowSwaps, minSwaps);

            startIndex++;
            endIndex++;
        }

        return minSwaps;
    }
}
