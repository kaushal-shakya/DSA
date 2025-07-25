package scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedOverLappingIntervals {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> input  = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1,3)),
                        new ArrayList<>(Arrays.asList(2,6)),
                        new ArrayList<>(Arrays.asList(8,10)),
                        new ArrayList<>(Arrays.asList(15,18))
                )
        );

        ArrayList<ArrayList<Integer>> ans = solve(input);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int a1 = A.get(0).get(0);
        int b1 = A.get(0).get(1);

        for(int i = 1; i < A.size(); i++)
        {
            int a2 = A.get(i).get(0);
            int b2 = A.get(i).get(1);

            if(a2 <= b1) { // Overlapping
                a1 = Math.min(a1,a2);
                b1 = Math.max(b1,b2);
            }
            else { //Non-overlapping
               ArrayList<Integer> temp = new ArrayList<>();
               temp.add(a1);
               temp.add(b1);
               ans.add(temp);
               a1 = a2;
               b1 = b2;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a1);
        temp.add(b1);
        ans.add(temp);

        return ans;
    }

}
