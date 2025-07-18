package scaler.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindEleInArray {
    public static void main(String[] args) {
        int[] A= {4,5,3,1,5,4,5};
        List<Integer> result = solve(A, 5);
        System.out.println(result);
    }



    public static List<Integer> solve(int[] A, int target){

        List<Integer> ans = new ArrayList<>();
         findIndices(A, target, ans, 0);
         return ans;
    }

    public static void findIndices(int[] A, int target, List<Integer> ans, int idx)
    {
        //If  idx == A.length-1, then check is required
//        if(idx == A.length-1)
//        {
//            if(A[idx] == target)
//                ans.add(idx);
//            return ans;
//        }

//        Here idx == A.length, target element check is not required
        if(idx == A.length)
        {
            return ;
        }

        if(A[idx] == target)
            ans.add(idx);

        findIndices(A, target, ans, idx+1);
    }

}
