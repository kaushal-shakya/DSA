package scaler.arrays.subarrays;

import java.util.ArrayList;

public class AllSubArrays {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(allSubArrays(a));
    }

    public static ArrayList<ArrayList<Integer>> allSubArrays(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < A.size(); i++)
        {   ArrayList<Integer> subArrays = new ArrayList<>();
            for(int j = i; j < A.size(); j++){
                subArrays = getAllSubArraysFromIthIndex(A, i, j);
                result.add(subArrays);
            }

        }
        return result;
    }

    private static ArrayList<Integer> getAllSubArraysFromIthIndex(ArrayList<Integer> A, int startIndex, int endIndex)
    {
        ArrayList<Integer> allSubArrays = new ArrayList<>();
        for(int i = startIndex; i <= endIndex; i++)
        {
            allSubArrays.add(A.get(i));
        }
        return allSubArrays;
    }
}
