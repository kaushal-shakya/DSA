package scaler.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 3, 1, 2));

        System.out.println(solve(A,B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> ans = new ArrayList<>();

        for( int a : A ) {
            if(map.containsKey(a))
            {
                int freq = map.get(a);
                freq++;
                map.put(a, freq);
            }
            else
            {
                map.put(a,1);
            }
        }

        for(int b : B)
        {
            int freq = map.getOrDefault(b, -1);
            if(freq > 0){
                ans.add(b);
                freq--;
                map.put(b, freq);
            }
        }

        return ans;
    }

}
