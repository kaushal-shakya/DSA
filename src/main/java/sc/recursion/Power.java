package sc.recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(power1(2,5));
        System.out.println(power2(2,5));

    }
// Optimized approach
    public static long power2(int A, int B)
    {
        if(B == 0){
            return 1;
        }

        long ans = power2(A, B/2);
        if(B % 2 == 0)
        {
            return ans*ans;
        }
            return ans*ans*A;
    }

    public static int power1(int a, int b){
        // b == 0 is to handle a^0,
//        b == 1 , return a would also work, but a^0 case won't be handle
        if(b == 0){
            return 1;
        }
        int ans = a * power1(a,b-1);
        return ans;
    }
}
