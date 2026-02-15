package sc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProdSubArray {

//    public static int maxProduct(List<Integer> A) {
//        int[] dpPositive = new int[A.size()];
//        int[] dpNegative = new int[A.size()];
//        int abhiTakPositiveMax = 1 ;
//
////        System.out.println("currPositive   |" + "  abhiTakMax  " + "|  A.get(i)");
//        for(int i = 0; i < A.size(); i++) {
//            int currPositive = abhiTakPositiveMax * A.get(i);
////            System.out.println(currPositive   + "   |  " + abhiTakPositiveMax + "   |    " + A.get(i));
//            if(currPositive >= abhiTakPositiveMax) {
//                abhiTakPositiveMax = currPositive;
//            } else {
//                abhiTakPositiveMax = 1;
//            }
//            dpPositive[i] = currPositive;
//        }
//
//        int curr = A.get(0);
//        dpNegative[0] = curr;
//        for (int i = 1; i < A.size(); i++) {
//            curr = curr * A.get(i);
//            dpNegative[i] = curr;
//            if(curr == 0)
//                curr = 1;
//        }
//
//        int maxPos = Arrays.stream(dpPositive).max().getAsInt();
//        int maxNeg = Arrays.stream(dpNegative).max().getAsInt();
//        return Math.max(maxPos, maxNeg);
//    }


//    public static int maxProduct(List<Integer> A) {
//
//    }


    public static void main(String[] args) {
//        Integer[] A = { -3, 1,-2 };
        Integer[] A = {-2,-3,-3};
//        Integer[] A = {1,0,0,0,0,0,-2,0,-2,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,-2,0,0,0,0,0,0,0,-1,-2,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,2,0,0,0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-3,0,0,0,0,-3,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,2,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,-3,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,-2,3,0,0,0,0,0,0,-2,-3,-3,0,0,0,0,0,0,0,0,0,0,1,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-3,0,-2,0,0,0,2,-3,0,0,0,0};
        System.out.println(Arrays.asList(A));
//        System.out.println(maxProduct(Arrays.asList(A)));
    }
}
