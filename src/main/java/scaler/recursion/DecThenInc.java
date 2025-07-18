package scaler.recursion;

public class DecThenInc {
    public static void main(String[] args) {
        decreasing(5);
        increasing(5);
        System.out.println();
    }

    public static void decreasing(int A) {
        if(A == 0)
            return;

        System.out.print(A + " ");
        decreasing(A-1);
    }

    public static void increasing(int A) {
        if(A == 0)
            return;

        increasing(A-1);
        System.out.print(A + " ");
    }
}
