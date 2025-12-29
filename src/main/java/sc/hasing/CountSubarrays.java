package sc.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountSubarrays {
    public static void main(String[] args) {
//        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(79,78,46,36,51,56,84,85,4,26,38,23,76,62,98,41,8,79,98,84,81,14,77));
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(93,9,12,32,97,75,32,77,40,79,61,42,57,19,64,16,86,47,41,67,76,63,24,10,25,96,1,30,73,91,70,65,53,75,5,19,65,6,96,33,73,55,4,90,72,83,54,78,67,56,8,70,43,63));

//        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5,3,2,3,1,4));

        System.out.println(solve(al));
    }

    public static int solve(ArrayList<Integer> A) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        for(int i = r;  i < A.size(); i++){
            int key = A.get(i);
            if( !map.containsKey(key) ) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key)+1);
                while(A.get(l) != key){
                    map.remove(A.get(l));
                    l++;
                }
                map.put(A.get(l), map.get(A.get(l))-1);
                l++;
            }
            ans += (r-l+1);
            r++;
        }

        return (int) (ans % (Math.pow(10,9)+7));
    }
}
