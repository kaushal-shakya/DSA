package scaler.sorting;

import java.util.Arrays;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] A = {6,3,4,2,7,2,1};
        int[] result = smallestNumber(A);

        for (int a : result){
            System.out.print(a + " ");
        }
    }

    public static int[] smallestNumber(int[] A) {
        int[] freq = new int[10];

        //this is maintaing the frequency of digit at corresponding index in freq array
        // Eg. count of 0 at 0th index
        // count of 1 at 1st index
        //count of 2 at 2nd index and so on
        for(int i = 0; i < A.length; i++)
        {
            freq[A[i]]++;
        }
        int[] temp = new int[A.length];
        int idx = 0;
        for(int i = 0; i < 10; i++){
            if(freq[i] == 0)
                continue;

            int f = freq[i];
            int j = 0;
            while(j < f){
                temp[idx] = i;
                j++;
                idx++;
            }
        }

        return temp;
    }

}
