public class NextPermutation {

    public static void main(String[] args) {
//        int[] A = {769, 533};
        int[] A = {769, 533};
        int result[]  = solve(A);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solve(int[] A){
        int n = A.length;
        int i = n-2;
        // traverse from right to left, to find the element which change could lead to next bigger ele
        while(i > 0){
            if(A[i] < A[i+1])
                break;
            i--; // stores the index of ele to be swapped
        }

        int min = Integer.MAX_VALUE;
        int j = i+1;
        int k = -1;
        //finding element which is just greater than A[i]
        for(; j < n; j++){
            if((A[j] > A[i]) && (A[j] < min)){
                min = A[j];
                k = j;
            }
        }
        if(k != -1){
            int temp = A[k];
            A[k] = A[i];
            A[i] = temp;
            return reverse(A, i+1, A.length-1);
        }else {

            return reverse(A, 0, A.length-1);
        }
    }

    public static int[] reverse(int[] A, int i, int j){
        while(i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
    }
}
