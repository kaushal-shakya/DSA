package sc.linkedlist;

public class StartingNodeOfCycle {

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
        System.out.println(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
            if(s == f) {
                s = head;
                while(s != f)
                {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }
}
