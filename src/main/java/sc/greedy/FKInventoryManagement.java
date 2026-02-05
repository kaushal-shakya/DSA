package sc.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair1 {
    int expiry;
    int profit;

    Pair1(int expiry, int profit) {
        this.expiry = expiry;
        this.profit = profit;
    }
}

class OrderingLogic implements Comparator<Pair1> {
    @Override
    public int compare(Pair1 o1, Pair1 o2) {
        if(o1.expiry < o2.expiry)
            return -1;
        else if (o1.expiry > o2.expiry)
            return 1;
        else
            return 0;
    }
}

public class FKInventoryManagement {

    public static int solve(int[] A, int[] B) {
        ArrayList<Pair1> al = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            al.add(new Pair1(A[i], B[i]));
        }
//        al.sort(new OrderingLogic());
        Collections.sort(al, new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                if(o1.expiry < o2.expiry)
                    return -1;
                else if (o1.expiry > o2.expiry)
                    return 1;
                else
                    return 0;
            }
        });
        int time = 0;
        PriorityQueue<Integer> profitPQ = new PriorityQueue<>();

        for (int i = 0; i < al.size(); i++) {
            int expiry = al.get(i).expiry;
            int profit = al.get(i).profit;

            if(time < expiry) {
                profitPQ.add(profit);
                time++;
            } else {
                if(profit > profitPQ.peek()) {
                    profitPQ.remove();
                    profitPQ.add(profit);
                }
            }
        }

        int ans = 0;
        while (!profitPQ.isEmpty()) {
            ans += profitPQ.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 3};
        int[] B = {5, 6, 1, 3, 9};

        System.out.println(solve(A, B));
    }

}
