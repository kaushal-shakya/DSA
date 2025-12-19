package sc.linkedlist;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList();
        ListNode reversedHead = reverseList(head);
        ListNode.printLinkedList(reversedHead);
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
