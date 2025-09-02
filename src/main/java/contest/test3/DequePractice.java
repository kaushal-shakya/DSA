package contest.test3;

import java.util.Deque;
import java.util.LinkedList;

public class DequePractice {
    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedList<>();
        deq.addFirst(1);
        deq.addLast(2);
        deq.addLast(3);
        deq.addFirst(0);

        System.out.println(deq);
    }
}
