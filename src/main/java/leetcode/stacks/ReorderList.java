package leetcode.stacks;

import scaler.linkedlist.ListNode;

import java.util.Stack;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList();
        reorderList(head);
        ListNode.printLinkedList(head);
    }

    public static void reorderList(ListNode head)
    {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        int lengthOfLL = 0;
        while (temp != null)
        {
            st.push(temp);
            temp = temp.next;
            lengthOfLL++;
        }
        temp = head;
        int k = (lengthOfLL+1)/2; // Why +1 ? I want to ensure my loop runs x/2 times for even, x/2+1 times for odd.
                                    // So, by adding +1, k remains same for even. and odd increases by 1.

        while (k > 0 && !st.isEmpty() && temp != null)
        {
            ListNode worker = temp;
            temp = temp.next;
            ListNode top = st.pop();
            worker.next = top;
            top.next = null;
            if(k != 1)
                top.next = temp;
            k--;
        }

    }
}
