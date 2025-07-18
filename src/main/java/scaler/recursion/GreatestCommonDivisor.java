package scaler.recursion;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(2, 2));
        System.out.println(gcd(1,0));
        System.out.println(gcd(0, 8));
        System.out.println(gcd(4,6));
        System.out.println(gcd(6,4));
    }

    public static int gcd(int A, int B) {
        // if gcd(0,4) => non-zero is ans ie. 4
        if(A == 0)
            return B;
        // if gcd(4,0) => non-zero is ans ie. 4
        if( B == 0)
            return A;

        // both A and B are equal => any one could be ans
        if(A == B)
            return A;


        if(A > B)
            return gcd(A%B, B); //used extended ecluid alogrithm
        else
            return gcd(B,A);   // handle cases where A < B, swap while calling recursion
    }
}
