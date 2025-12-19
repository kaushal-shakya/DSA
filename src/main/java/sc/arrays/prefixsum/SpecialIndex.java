package sc.arrays.prefixsum;

public class SpecialIndex {
    public static void main(String[] args) {
        int[] A = {1, 1,1};
        System.out.println(solve(A));
    }


    public static int solve(int[] A) {
        int[] pe = getPrefixSumEvenIndicesArray(A);
        int[] po = getPrefixSumOddIndicesArray(A);


        int count = 0;
        for(int i = 0; i < A.length; i++)
        {   int se = 0;
            int so = 0;
            if(i == 0)
            {
                se = po[A.length-1] - po[0];
                so = pe[A.length-1] - pe[0];
            }else{
                so = po[i-1] + pe[A.length-1] - pe[i];
                se = pe[i-1] + po[A.length-1] - po[i];
            }
            if(se == so){
                count++;
            }
        }
        return count;
    }


    static int[] getPrefixSumEvenIndicesArray(int[] A)
    {
        int[] pe = new int[A.length];
        pe[0] = A[0];
        for(int i = 1; i < A.length; i++)
        {
            if(i%2 == 0)
            {
                pe[i] = pe[i-1]+A[i];
            }else{
                pe[i] = pe[i-1];
            }
        }
        return pe;
    }

    static int[] getPrefixSumOddIndicesArray(int[] A)
    {
        int[] po = new int[A.length];
        po[0] = 0;

        for(int i = 1; i < A.length; i++)
        {
            if(i%2 != 0)
            {
                po[i] = po[i-1]+A[i];
            }else{
                po[i] = po[i-1];
            }
        }
        return po;
    }
}
