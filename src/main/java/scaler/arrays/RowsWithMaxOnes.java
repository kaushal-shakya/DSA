package scaler.arrays;

public class RowsWithMaxOnes {

    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{0,0,1,1},{0,0,1,1},{1,1,1,1}};
        System.out.println(solve(A));
    }

    public static int solve(int[][] A)
    {   int row = -1;
        int ans = -1;
        int maxOnes = 0;
        int i = 0;
        int j = A.length-1;

        while (i < A.length && j >= 0)
        {
            if(A[i][j] != 0){
                maxOnes++;
                j--;
            }
            else {
                if(maxOnes > ans)
                {
                    ans = maxOnes;
                    row = i;
                }

                maxOnes = 0;
                j = A.length-1;
                i++;
            }
        }
        if( j == -1)
        {
            return i;
        }
        return row;
    }
}
