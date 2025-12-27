package sc.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = scanner.nextInt();
        System.out.println();
        System.out.println("Enter arraylist elements : ");
        for (int i = 0; i < size; i++) {
            int el = scanner.nextInt();
            al.add(el);
        }

        System.out.println(solve(al));
    }

    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        int[] prefix = new int[A.size()];
        prefix[0] = A.get(0);
        for(int i = 1; i < A.size(); i++)
        {
            prefix[i] = prefix[i-1] + A.get(i);
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < prefix.length; i++)
        {
            if(prefix[i] == 0)
                return i+1;

            if( !m.containsKey(prefix[i]) ) {
                m.put(prefix[i], i);
            }
            else {
                int idx = m.get(prefix[i]);
                ans = Math.max(i-idx, ans);
            }
        }
        return ans;
    }
}
