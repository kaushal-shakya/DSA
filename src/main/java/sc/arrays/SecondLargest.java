package sc.arrays;

import java.util.ArrayList;

public class SecondLargest {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(34);
        a.add(21);
//        a.add(45);
        System.out.println(findSecondLargest(a));
    }

    public static int findSecondLargest(ArrayList<Integer> a) {
        int largest = -1;
        for(Integer item : a){
            if(item > largest)
                largest = item;
        }

        int secondLargest = -1;
        for(Integer item : a){
            if(item < largest && item > secondLargest)
                secondLargest = item;
        }
        return secondLargest;
    }
}
