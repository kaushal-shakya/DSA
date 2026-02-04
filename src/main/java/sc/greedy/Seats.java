package sc.greedy;

import java.util.ArrayList;

public class Seats {

    public static int seats(String A) {
        int n = A.length();
        ArrayList<Integer> xPositions = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(A.charAt(i) == 'x') xPositions.add(i);
        }

        int m = xPositions.size();
        int mid = m/2;
        int result = 0;
        int left = mid-1;
        int right = mid+1;
        int k = 1;
        while(left >= 0) {
            result += xPositions.get(mid) - k - xPositions.get(left);
            --left;
            k++;
        }
        k = 1;
        while(right < m) {
            result += xPositions.get(right) - xPositions.get(mid) - k;
            right++;
            k++;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "....x..xx...x..";
        System.out.println(seats(s));
    }
}
