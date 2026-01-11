package sc.heaps;

import java.util.*;

class HeapImpl1 {
    private ArrayList<Integer> al ;

    public HeapImpl1(ArrayList<Integer> al) {
        this.al = al;
    }

    public void insert(int k) {
        upheapify(k);
    }

    private void upheapify(int k) {
        al.add(k);
        int i = al.size()-1;

        while(i > 0) {
            int parIndex = (i-1)/2;
            if ( al.get(parIndex) > al.get(i) ) {
                int temp = al.get(i);
                al.set(i, al.get(parIndex));
                al.set(parIndex, temp);
                i = parIndex;
            } else {
                break;
            }
        }
    }
}

public class HeapUsingArray {

    public static void main(String[] args) {
        int[] A = {5, 13, -2, 11, 27, 31, 0, 19};

        ArrayList<Integer> al = new ArrayList<>();
        HeapImpl1 h = new HeapImpl1(al);

        for (int i = 0; i < A.length; i++) {
            h.insert(A[i]);
        }

        int[] result = new int[al.size()];

        for(int i = 0; i < result.length; i++) {
            result[i] = al.get(i);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
