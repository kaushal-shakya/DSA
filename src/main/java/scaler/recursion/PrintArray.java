package scaler.recursion;

public class PrintArray {
    public static void main(String[] args) {
        int[] a = {6, -2, 5, 3};
        printArray(a, 0);
        System.out.println();
    }

    public static void printArray(int[] A,  int s){

        if(s == A.length){
            return;
        }
        System.out.print(A[s]+ " ");
        printArray(A, s+1);
    }
}
