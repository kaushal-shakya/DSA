package sc.arrays;

import java.util.ArrayList;

public class RotateKTimes {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        System.out.println(rotateKTimes(a, 2));
    }


    public static ArrayList<Integer> rotateKTimes(ArrayList<Integer> A, int B) {
        Reverse(A, 0, A.size()-1);
        Reverse(A, 0, B-1);
        Reverse(A, B, A.size()-1);

        return A;
    }

    private static void Reverse(ArrayList<Integer> A, int firstIndex, int endIndex){
        while(firstIndex < endIndex)
        {
            int temp = A.get(firstIndex);
            A.set(firstIndex, A.get(endIndex));
            A.set(endIndex, temp);
            firstIndex++;
            endIndex--;
        }
    }
}
