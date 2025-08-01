package scaler.linkedlist;

import java.util.Scanner;

public class PrintLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList();
        solve(head);
    }

    public static void solve(ListNode A) {
        ListNode temp = A;

        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
