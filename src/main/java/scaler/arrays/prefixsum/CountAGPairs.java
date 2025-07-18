package scaler.arrays.prefixsum;

public class CountAGPairs {
    public static void main(String[] args) {
        String input = "ABCGAG";
        System.out.println(solve(input));
    }

    public static Long solve(String A) {

        long agpairs = 0;
        long g = 0;
        for(int i = A.length()-1; i >=0; i--)
        {
            if(A.charAt(i) == 'G') {
                g++;
            } else if (A.charAt(i) == 'A') {
               agpairs += g;
            }
        }
        return agpairs;
    }

}
