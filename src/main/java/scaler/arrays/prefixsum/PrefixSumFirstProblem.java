package scaler.arrays.prefixsum;

import java.util.ArrayList;

public class PrefixSumFirstProblem {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
//        [7,3,1,5,5,5,1,2,4,5]
        a.add(7);
        a.add(3);
        a.add(1);
        a.add(5);
        a.add(5);
        a.add(5);
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(5);
//[[6,9],[2,9],[2,4],[0,9]]
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> B1 = new ArrayList<>();
        B1.add(6);
        B1.add(9);
        B.add(B1);
        ArrayList<Integer> B2 = new ArrayList<>();
        B2.add(2);
        B2.add(9);
        B.add(B2);
        ArrayList<Integer> B3 = new ArrayList<>();
        B3.add(2);
        B3.add(4);
        B.add(B3);
        ArrayList<Integer> B4 = new ArrayList<>();
        B4.add(0);
        B4.add(9);
        B.add(B4);

        System.out.println(a);
        System.out.println(B);

        System.out.println(rangeSum(a, B));
    }

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int q = B.size();
        ArrayList<Long> prefixSum = getPrefixSum(A);

        ArrayList<Long> result = new ArrayList<>();

        for(int i = 0; i < q; i++)
        {   long sum = 0;
            int l = B.get(i).get(0);
            int r = B.get(i).get(1);

            if(l == 0)
            {
                sum = prefixSum.get(r);
            }else
            {
                sum = prefixSum.get(r) - prefixSum.get(l-1);
            }
            result.add(sum);
        }

        return result;
    }

    public static ArrayList<Long> getPrefixSum(ArrayList<Integer> A)
    {
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0).longValue());

        for(int i = 1; i < A.size(); i++)
        {
            prefixSum.add(prefixSum.get(i-1) + A.get(i) );
        }
        return prefixSum;
    }
}
