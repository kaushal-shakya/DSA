package sc.arrays.binary;

import java.util.*;

public class ElementsRemoval {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1,2,5,7,4);
        System.out.println(solve(al));
    }

    public static int solve(List<Integer> A) {
        Collections.sort(A);
        int size = A.size()-1;
        int sum = sum(A);
        int cost = 0;
        while(size >= 0) {
            cost += sum;
            sum = sum - A.get(size);
            size--;
        }
        return cost;
    }

    public static int sum(List<Integer> A) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
        }
        return sum;
    }
}
