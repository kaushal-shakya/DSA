package sc.hasing;

import java.util.HashMap;

public class KSubArraySum {

    public static void main(String[] args) {
        int[] A = {-5,-22,25,40,-5,-16,7,14,-28,39,-42,-13,-27,37,-11,3,25,-15,-17,-40,25,21,-2,3,-23,28,-1,12,-46,45,-4,5,-22,36,-9,-2,-40,14,32,-36,
                22,19,-16,46,1,-37,-28,44,24,31,-4,-14,8,45,8,-44,-21,35,34,-15,-10,36,-5,10,42,4,-20,-14,-3,-19,-41,-45,8,-16,-13};
        System.out.println(solve(A, -21));
    }


    //If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same,
    // it means the sum of the elements lying in between those indices is zero.
    public static int solve(int[] A, int B) {

        int count = 0;
        long a = 0;
        //It contains <sum_i, no. of occurrences of sum_i>
        HashMap<Long, Integer> set = new HashMap<>();

        for (long j : A) {
            //this is for replacing prefix sum calculation, sum upto previous elements + current element is a
            // prefix sum up to current element
            a += j;
            //This is used to include single element in final ans, if condition is true
            if(a == B ){
                count++;
            }
            //Target = what should be present in previous sums
            long target = a-B;

            if(set.containsKey(target)){
                //Why adding freq ?
                //Because it is possible any sum occurred n no of times, then sub array from each such sum should be counted
                int freq = set.get(target);
                count = count + freq;

            }

            // Update frequency of current sum
            set.put(a, set.getOrDefault(a, 0) + 1); // update freq
        }

        return count;
    }
}


