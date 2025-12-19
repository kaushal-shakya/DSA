package sc.modular;

public class Power {
    public static void main(String[] args) {
        System.out.println(pow(-1, 1, 20)); // Example usage
    }

    public static int pow(int A, int B, int C) {
        if(A == 0)
            return 0;
        if(B == 0)
            return 1;

        long ans = pow(A, B/2, C) % C;

        ans = (ans * ans )% C;
        if(B%2 == 1){
            ans = (ans * A) % C;
        }
        ans = (ans + C) % C; // Ensure non-negative result
        return (int) ans;
    }
}
