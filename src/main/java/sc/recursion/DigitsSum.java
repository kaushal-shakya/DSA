package sc.recursion;

public class DigitsSum {
    public static void main(String[] args) {
        System.out.println(solve(2134));
    }

    public static int solve(int A){
        if(A == 0){
            return 0;
        }

        int digit = A % 10;
        int ans = solve(A/10);
        return ans + digit;
    }
}
