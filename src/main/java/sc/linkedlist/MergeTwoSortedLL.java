package sc.linkedlist;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createLinkedList();
        ListNode list2 = ListNode.createLinkedList();

        ListNode result = mergeTwoLists(list1, list2);
        ListNode.printLinkedList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        ListNode ansHead = null;
        ListNode ansTail = null;
        ListNode h1 = list1;
        ListNode h2 = list2;
        while(h1 != null && h2 != null) {

            if(h1.val < h2.val) {
                if(ansHead == null) {
                    ansHead = h1;
                    ansTail = h1;
                } else {
                    ansTail.next = h1;
                    ansTail = ansTail.next;
                }
                h1 = h1.next;
            } else {
                if(ansHead == null) {
                    ansHead = h2;
                    ansTail = h2;
                } else {
                    ansTail.next = h2;
                    ansTail = ansTail.next;
                }
                h2 = h2.next;
            }
        }

        if(h1 != null) {
            ansTail.next = h1;
        }
        if(h2 != null) {
            ansTail.next = h2;
        }
        return ansHead;
    }
}
