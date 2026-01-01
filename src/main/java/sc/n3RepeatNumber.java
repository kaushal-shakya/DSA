package sc;

import java.util.*;

public class n3RepeatNumber {

    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(1000441, 1000441, 1000994);
        System.out.println(repeatedNumber(in));
    }

    public static int repeatedNumber(final List<Integer> a) {
        int length = a.size();
        int cond = length/3;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : a) {
            if(!map.containsKey(ele)) {
                map.put(ele, 1);
            } else
            {
                map.put(ele, map.get(ele)+1);
            }
        }
        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value > cond){
                ans = key;
            }

        }
        return ans;
    }
}
