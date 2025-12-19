package sc.sorting;

import java.util.Arrays;
import java.util.Comparator;

class FactorsComapartorAsc implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        int factorA = FactorSort.countFactors(i1);
        int factorB = FactorSort.countFactors(i2);
        if (factorA < factorB) {
            return -1;
        } else if (factorA > factorB) {
            return 1;
        }
        if (i1 < i2) {
            return -1;
        } else if (i1 > i2) {
            return 1;
        }
        return 0;
    }
}
class FactorsComapartorDsc implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        int factorA = FactorSort.countFactors(i1);
        int factorB = FactorSort.countFactors(i2);
        if (factorA < factorB) {
            return 1;
        } else if (factorA > factorB) {
            return -1;
        }
        if (i1 < i2) {
            return 1;
        } else if (i1 > i2) {
            return -1;
        }
        return 0;
    }
}

public class FactorSort {
    public static void main(String[] args) {
        Integer[] arr = {9, 3, 10, 6, 4, 8};
        sortOnFactorsAsc(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortOnFactorsAsc(Integer[] arr) {
        //Arrays.sort(arr);
        //Arrays.sort(arr, new FactorsComapartorAsc());
        Arrays.sort(arr, new FactorsComapartorDsc());
    }

    public static int countFactors(int no) {
        int cnt = 0;
        for (int i = 1; i <= no; i++) {
            if (no % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
