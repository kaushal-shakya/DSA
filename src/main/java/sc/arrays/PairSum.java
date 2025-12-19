package sc.arrays;

import java.util.ArrayList;

public class PairSum {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        System.out.println(solve(a, 4));
    }

    public static int solve(ArrayList<Integer> A, int B) {

        for(int i = 0; i < A.size(); i++){
            for(int j = i+1; j < A.size(); j++){
                if((A.get(i) + A.get(j)) == B)
                {
                    return 1;
                }
            }
        }

        return 0;
    }
}
