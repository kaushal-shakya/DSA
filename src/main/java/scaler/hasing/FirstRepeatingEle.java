package scaler.hasing;

import java.util.HashMap;

public class FirstRepeatingEle {
    public static void main(String[] args) {
        int[] A = {8,15,1,10,5,19,19,3,5,6,6,2,8,2,12,16,3};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int ans = Integer.MAX_VALUE;

        //HashMap<number at ith place, first_occurring_index>
        HashMap<Integer, Integer> set = new HashMap<>();
        for( int i = 0; i < A.length; i++ )
        {   //check element[i] is present
            //find index, update ans only if there exists a repeating element before
            //{8,15,1,10,5,19,19,3,5,6,6,2,8,2,12,16,3} | 8 is the first repeating element | 19, 3, 6 are also repeating
            if( set.containsKey(A[i]) ){
                int index = set.get(A[i]);
                if(index < ans){
                    ans = index;
                }
            }else{
                set.put(A[i], i);
            }
        }


        return ans != Integer.MAX_VALUE ? A[ans] : -1 ;
    }
}
