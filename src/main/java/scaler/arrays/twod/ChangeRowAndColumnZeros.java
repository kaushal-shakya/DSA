package scaler.arrays.twod;

public class ChangeRowAndColumnZeros {

//  You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
//  Specifically, make entire ith row and jth column zero.
    public static void main(String[] args) {
        int [][]A = {{1,2,3,4},
        {5,6,7,0},
        {9,2,0,4}}  ;

        solve(A);
        for(int i = 0 ; i < A.length; i++)
        {   System.out.print("[");
            for(int j = 0; j < A.length; j++)
            {
                System.out.print(A[i][j] +" ");
            }
            System.out.println("]");
        }
    }


    public static int[][] solve(int[][] A) {

        // Row wise traversal first : and making all non-zero row values as -1
        for( int i = 0; i < A.length; i++)
        {
            int flag = 0;
            for(int j = 0; j < A[i].length; j++)
            {
                if(A[i][j] == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
            {
                for(int j = 0; j < A[i].length; j++)
                {
                    if(A[i][j] != 0)
                    {
                        A[i][j] = -1;
                    }
                }
            }
        }

        // Column wise traversal first : and making all non-zero column values as -1
        for(int i = 0; i < A.length; i++)
        {   int flag = 0;
            for(int j = 0 ; j < A.length; j++)
            {
                if(A[j][i] == 0){
                    flag = 1;
                    break;
                }
            }

            if(flag == 1)
            {
                for(int j = 0; j < A.length; j++)
                {
                    if(A[j][i] != 0)
                    {
                        A[j][i] = -1;
                    }
                }
            }
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(A[i][j] == -1)
                    A[i][j] = 0;
            }
        }

        return A;
    }

}
