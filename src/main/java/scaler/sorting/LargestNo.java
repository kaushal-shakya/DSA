package scaler.sorting;

import java.util.*;

class LargestNumberComaparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        String fir = String.valueOf(i1);
        String sec = String.valueOf(i2);
        String firSec = fir + sec;
        String secFir = sec + fir;
        int cmp = firSec.compareTo(secFir);
// fir > sec : >0
// fir < sec :
        if (cmp > 0) {
            return -1;
        } else if (cmp < 0) {
            return 1;
        }
        return 0;
    }
}

public class LargestNo {

    public static void main(String[] args) {
        // Convert int[] to List<Integer>
        int[] A = {0,1,0};
        List<Integer> list = new ArrayList<>();

        for (int val : A) {
            list.add(val); // Autoboxing
        }

        String ans = largestNumber1(list) ;
        //Seperate handling for string containing zeroes only
        for (int i = 0; i < ans.length(); i++) {
            char currentChar = ans.charAt(i);
            if(currentChar != '0')
                System.out.println(ans);
        }
        System.out.println("0");
    }
    public static String largestNumber1(List<Integer> nums) {
        Collections.sort(nums, new LargestNumberComaparator());
        String ans = "";
        for (int i = 0; i < nums.size(); i++) {
            ans += nums.get(i);
        }
        return ans;
    }
}
