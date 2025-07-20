package scaler.arrays.twod;

public class SearchInRowAndColumnSortedMatrix {
    public static void main(String[] args) {
//        int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
//        System.out.println(solve(A, 2));
        int[][] A = {{1,2}, {3,3}};
        System.out.println(solve(A, 3));
    }

    public static int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int i = 1; // row
        int j = m; // column
        int min = Integer.MAX_VALUE;
        //run this loop until reached to first column and last row
        while(i <= n && j >= 0)
        {
            if( A[i-1][j-1] == B ){
                if ( (i * 1009 + j )  < min){
                        min = i * 1009 + j;
                }
            }
            //Why breaking on j == 1 ?
            //Because acc to below if condition, we would have checked in column first and then in rows.
            if( j == 1 )
                break;

            //This condition makes sure that we are checking B in column first then in rows
            if (A[i-1][j-1] >= B) {
                j--; // shifting columns
            } else {
                i++; // shifting rows
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
