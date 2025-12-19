package sc.linkedlist;

public class BreakCycle {

    public static void main(String[] args) {
        ListNode A = ListNode.createNode(3);
        ListNode B = ListNode.createNode(2);
        ListNode C = ListNode.createNode(0);
        ListNode D = ListNode.createNode(4);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = B;

        ListNode head = A;
        System.out.println(removeCycle(head));
    }

    public static ListNode removeCycle(ListNode A) {
        ListNode s = A;
        ListNode f = A;

        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
            if(s == f) {
                s = A;
                while(s.next != f.next)
                {
                    s = s.next;
                    f = f.next;
                }
                f.next = null;
            }
        }
        return A;
    }
}
