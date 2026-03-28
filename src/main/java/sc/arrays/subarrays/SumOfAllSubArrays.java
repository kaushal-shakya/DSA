package sc.arrays.subarrays;

public class SumOfAllSubArrays {

    public static void main(String[] args) {
        int[] A = {3,-2,4,-1,2,6};
        System.out.println(contributionTechinque(A));
    }

//    Idea : In how many subarrays, element with index i will be present.
    public static int contributionTechinque(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int occ = (i+1) * (A.length-i);
            sum = sum + A[i] * occ;
        }
        return sum;
    }
}
