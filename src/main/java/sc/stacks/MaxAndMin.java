package sc.stacks;

public class MaxAndMin {
        public static int solve(int[] A) {
            int n = A.length;
            int[] diff = new int[n];
            int maxI = Integer.MIN_VALUE;
            int minI = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                if(A[i] > maxI) {
                    maxI = A[i];
                }
                if(A[i] < minI) {
                    minI = A[i];
                }
                diff[i] = maxI-minI;
            }
            long sum = 0;
            for(int i = n-1; i > 0; i--) {
                long temp = ((diff[i]*i) % (int)(Math.pow(10, 9) + 7)) ;
                sum = ((sum+temp) % (int)(Math.pow(10, 9) + 7));
            }

            return (int)(sum % ((int)(Math.pow(10, 9) + 7)));
        }

    public static void main(String[] args) {
//        int[] A = {992387,932142,971117,934674,988917,967890,948508,970347};

//        int[] A = {5,5,5,5,5};
        int[] A = {5,8,3,2,9,0};
        System.out.println(solve(A));
    }

}
