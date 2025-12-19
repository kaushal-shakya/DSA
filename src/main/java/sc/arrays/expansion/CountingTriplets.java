package sc.arrays.expansion;

public class CountingTriplets {
    public static void main(String[] args) {
        int[] input = {2,1,3,5,7,4};
        System.out.println(solve2(input));
        System.out.println(solve(input));
    }

//    Time complexity = O(n2)
    public static int solve2(int[] A)
    {
        int triplet = 0;

        // Why not started with i = 0 ? There will not be any smaller number beyond index 0, Hence, no triplets
        // Why ended with i=A.length-1 ? There will not be any greater number beyond index, Hence, no triplets
        for(int i = 1; i < A.length-1; i++)
        {
            int current = A[i];
            int j = i;
            int smaller = 0;
            int greater = 0;
            while(j >= 0)
            {
                if(A[j] < A[i])
                    smaller++;
                j--;
            }
            j = i+1;
            while(j < A.length)
            {
                if(A[j] > A[i])
                    greater++;
                j++;
            }
            triplet += smaller * greater;
        }
        return triplet;
    }



//  Brute Force: Here, we are moving to all the triplets and checking the A[i] < A[j] < A[k]
    //Time complexity : O(N3)
    public static int solve(int[] A) {
        int triplet = 0;
        for( int i =0 ; i < A.length; i++)
        {
            for(int j = i+1; j < A.length; j++)
            {
                for(int k = j+1; k < A.length; k++)
                {
                    if(A[i] < A[j] && A[j] < A[k] && A[i] < A[k]){
                        triplet++;
                    }
                }
            }
        }
        return triplet;
    }
}
