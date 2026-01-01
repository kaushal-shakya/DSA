package sc.queues;

import java.util.*;

public class ParkingIcreCreamTruck {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 7, 1, 3, 6));
//        System.out.println(slidingMaximum(A, 6));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1));
        System.out.println(slidingMaximum(A, 2));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(648,614,490,138,657,544,745,582,738,229,775,665,876,448,
//                4,81,807,578,712,951,867,328,308,440,542,178,637,446,882,760,354,523,935,277,158,698,536,165,892,327,
//                574,516,36,705,900,482,558,937,207,368));
//        System.out.println(slidingMaximum(A, 9));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < A.size(); i++) {
            //Remove indices that are out of window
            while(!dq.isEmpty() && dq.peekFirst() <= i-B ) {
                dq.pollFirst();
            }
            //Remove smaller element
            while(!dq.isEmpty() && A.get(dq.peekLast()) < A.get(i)) {
                dq.pollLast();
            }
            //Add element
            dq.addLast(i);

            if(i >= B-1){
                result.add(A.get(dq.peekFirst()));
            }
        }
        return result;
    }
}
