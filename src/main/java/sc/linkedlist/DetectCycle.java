package sc.linkedlist;

public class DetectCycle {

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
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
            if(s == f)
                return true;
        }
        return false;
    }
}
