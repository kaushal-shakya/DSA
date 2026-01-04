package sc.maths.combinatorics;

public class SortedPermutationRank {
    public static void main(String[] args) {
        System.out.println(findRank("baedc"));
    }

    public static int findRank(String A) {
        int n = A.length();
        int rank = 0;
        for(int i = 0; i < n; i++)
        {
            int smallerCount = 0;
            for(int j = i+1; j < n; j++)
            {
                if(A.charAt(j) < A.charAt(i))
                    smallerCount++;
            }
            int contri = smallerCount * factorial(n-i-1);
            rank += contri;
        }
        return (rank+1)%1000003;
    }

    public static int factorial(int n)
    {
        if(n == 0 || n == 1)
            return n;

        return n * factorial(n-1)%1000003;
    }
}
