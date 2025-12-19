package sc.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public static void main(String[] args) {
       int result = solve1(0, new ArrayList<>(Arrays.asList(35,16,70,33,32,89,59,79,84,64,59,30,98,25,23,58,57,83,3,4,80,
               38,87,63,44,70,93,65,72,34,69,96,96,48,5,70,73,58,82,62,49,97,91,40,28,56,61,93,47,14,93,75,90,91,3,48,99,41,
               49,32,26,34,50,25,2,58,50,84,14,76,77,28,46,52,33,71,74,40,55,41,32,4,66,35,9,71,45,95,55,78,85,1,43,57,16,68,
               15,1,0,51)));

       System.out.println(result);
    }


    public static int solve1(int A, ArrayList<Integer> B) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int a : B) {
            //First check, A-a difference is present in temp or not,
            //this will prevent pairing an element with itself. How ?
            //Suppose A = 12, a = 6 from index 3 [4,5,2,6,3,2,9,6], we will check whether 12-6 is present in
            // set or not, not present add
            //for a = 6 from index 7, 12-6 present ? pair exist so return 1
            if(temp.contains(A-a))
                return 1;

            //Once it is verified
            temp.add(a);
        }

        return 0;
    }

    //First approach
    public static int solve(int A, ArrayList<Integer> B) {
        Set<Integer> temp = new HashSet<Integer>();
        //in initial approach, we thought to add all elements to set from arraylist
        for (int a : B){
                temp.add(a);
        }

        //check whether A-B[i] difference is present in set or not
        //this approach leads to a problem pairing with itself.
        for(int a : B){
            if(temp.contains(A-a))
                return 1;
        }
        return 0;
    }
}
