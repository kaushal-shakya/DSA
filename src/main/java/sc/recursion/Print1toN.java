package sc.recursion;

public class Print1toN {
    public static void main(String[] args) {
        int a = 10;
        solve(a);
        System.out.println();
    }

    public static void solve(int A) {
        if(A == 1)
        {
            System.out.print(A+" ");
            return;
        }

        solve(A-1);
        System.out.print(A+" ");

    }
}
