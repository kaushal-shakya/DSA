package sc.heaps;

import java.util.ArrayList;
import java.util.Arrays;

class HeapImpl {
    private ArrayList<Integer> al ;

    public HeapImpl(ArrayList<Integer> al) {
        this.al = al;
    }

    public void insert(int k) {
        upheapify(k);
    }

    private void upheapify(int k) {
        al.add(k);
        int i = al.size()-1;

        while(i > 0) {
            int par = (i-1)/2;
            if(al.get(par) > al.get(i)) {
                int temp = al.get(i);
                al.set(i, al.get(par));
                al.set(par, temp);
                i = par;
            }else {
                break;
            }
        }
    }

}

public class HeapMain {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        HeapImpl h = new HeapImpl(al);
//        h.insert(2);
//        h.insert(4);
//        h.insert(5);
//        h.insert(11);
//        h.insert(6);
//        h.insert(7);
//        h.insert(8);
//        h.insert(20);
//        h.insert(12);
//        h.insert(3);
//        5, 13, -2, 11, 27, 31, 0, 19
        h.insert(5);
        h.insert(13);
        h.insert(-2);
        h.insert(11);
        h.insert(27);
        h.insert(31);
        h.insert(0);
        h.insert(19);
//        h.insert(12);
//        h.insert(3);
        System.out.println(al);
    }
}
