package scaler.linkedlist;

public class PrintKth {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList();
        System.out.println(kthElement(head, 5));
    }

    public static int kthElement(ListNode A,  int k)
    {
        ListNode temp = A; // store A into temp so that head is not misplaced
        int i  = 0; // index = 0
        while( i < k && temp != null) // if only one ele, then
        {
            temp = temp.next;
            i++;
        }

        return temp != null ? temp.val : -1; //
    }
}
