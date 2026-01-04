package sc.linkedlist;

public class ReorderLL {
    public static void main(String[] args) {
        ListNode A = ListNode.createNode(1);
        ListNode B = ListNode.createNode(2);
        ListNode C = ListNode.createNode(3);
        ListNode D = ListNode.createNode(4);
        ListNode E = ListNode.createNode(5);
        ListNode F = ListNode.createNode(6);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = null;

        ListNode head = A;
        ListNode reorderListHead = reorderList(head);
        ListNode.printLinkedList(reorderListHead);
    }

    public static ListNode reorderList(ListNode A) {
        ListNode middleNode = getMiddle(A);
        ListNode t1 = A;
        ListNode originalTail, t2 = traverse(A);
        ListNode reverseNode = reverseList(middleNode.next);

        ListNode tailNodeOfReverseLL = traverse(reverseNode);
        tailNodeOfReverseLL.next = middleNode;
        middleNode.next = null;

        ListNode temp1 = null, temp2 = null;
        while(t1 != null && t1 != t2) {
            temp1 = t1.next;
            temp2 = t2.next;
            t1.next = t2;
            t2.next = temp1;
            t1 = temp1;
            t2 = temp2;
        }

        return A;
    }

    public static ListNode traverse(ListNode t) {
        while(t.next != null) {
            t = t.next;
        }
        return t;
    }

    public static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head){
        ListNode temp = head;
        ListNode curr = temp;
        ListNode prev = null;

        while (curr != null){
            ListNode agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        head = prev;
        return head;
    }
}
