package scaler.arrays.prefixsum;

public class EvenNumberRange {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[][] B = {{0, 2}, {2,4}, {1,4}};
        int[] result = solve(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


    public static int[] solve(int[] A, int[][] B) {
        int[] pe = getprefixEvenArray(A);

        int[] result = new int[B.length];

        for(int i = 0; i < B.length; i++)
        {
            if(B[i][0] == 0){
                result[i] = pe[B[i][1]] ;
            } else
            {
                result[i] = pe[B[i][1]] - pe[B[i][0]-1];
            }
        }
        return result;
    }

    static int[] getprefixEvenArray(int[] A)
    {
        int[] pe = new int[A.length];
        pe[0] = A[0] % 2 == 0 ? 1 : 0;

        for(int i = 1; i < A.length; i++)
        {
            if(A[i]%2==0)
            {
                pe[i] = pe[i-1]+1;
            }else{
                pe[i] = pe[i-1];
            }
        }
        return pe;
    }
}
