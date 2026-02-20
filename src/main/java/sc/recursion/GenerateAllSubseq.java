package sc.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubseq {
    static List<Integer> subSeq = new ArrayList<>();
    public static void printSubsequences(int[] A, int idx) {
        if(idx == A.length) {
            System.out.println(subSeq);
            return;
        }

        subSeq.add(A[idx]);
        printSubsequences(A, idx+1);
        subSeq.remove(subSeq.size()-1);
        printSubsequences(A, idx+1);
    }

    public static void main(String[] args) {
        int[] input = {1,2, 1, 5};
        printSubsequences(input, 0);
    }
}
