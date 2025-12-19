package sc.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountParis {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 5, 1, 2));
        System.out.println(solve(input , 8));
    }

    public static int solve(ArrayList<Integer> A, int B)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;

        for(int a : A){
            int target = B - a;
            if(freq.containsKey(target))
            {
                ans += freq.get(target);
            }

            if(freq.containsKey(a)){
                int times = freq.get(a);
                times++;
                freq.put(a, times);
            }else {
                freq.put(a,1);
            }
        }
        return ans;
    }

}
