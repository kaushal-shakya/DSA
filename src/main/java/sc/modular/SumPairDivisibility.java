package sc.modular;

import java.util.ArrayList;
import java.util.Collections;

public class SumPairDivisibility {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        System.out.println(solve(A, 2));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> freq = new ArrayList<>(Collections.nCopies(B,0));
        for( Integer ele : A )
        {
            int mod = ele % B;
            int i = freq.get(mod);
            freq.set(mod,++i);
        }

        //Reminder = 0
        int freq_zero = freq.get(0);
        int ans = ( ((freq_zero % B ) * (freq_zero-1) % B) % B ) / 2;

        //for handling cases from 1 to B-1
        int l = 1;
        int r = B - 1;
        while(l < r)
        {
            int freq_left = freq.get(l);
            int freq_right = freq.get(r);
            ans += ( ( freq_left % B ) * (freq_right % B) ) % B;
            l++;
            r--;
        }

        //if l == r
        if(l == r){
            int freq_left = freq.get(l);
            ans += (( (freq_left % B ) * ((freq_left - 1) % B )) % B )/2;
        }
        return ans;
    }


}
