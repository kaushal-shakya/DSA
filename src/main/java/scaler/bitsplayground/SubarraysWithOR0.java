package scaler.bitsplayground;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarraysWithOR0 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0));

        System.out.println(subarraysWithOR1(A));
    }

    public static int subarraysWithOR1(ArrayList<Integer> A) {
        int n = A.size();
        int totalSubArray = (n*(n+1))/2;
        int subArrayWithOR0 = subarraysWithOR0(A);
        return totalSubArray - subArrayWithOR0;
    }

    public static int subarraysWithOR0(ArrayList<Integer> A) {
        int ans = 0;
        int zeroes = 0;

        for (Integer integer : A) {
            if (integer == 0) {
                zeroes++;
            } else {
                ans += ((zeroes) * (zeroes + 1)) / 2;
                zeroes = 0;
            }
        }

        ans += (((zeroes * (zeroes+1))) / 2);

        return ans;
    }

}
