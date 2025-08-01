package scaler.linkedlist;

import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int data){
        this.val = data;
        this.next = null;
    }

    public static ListNode createLinkedList(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter linked list element : ");
        int value = scanner.nextInt();
        ListNode head = new ListNode(value);
        ListNode temp = head;
        ListNode ll = null;
        while (value != -1) {
            System.out.println("Enter next element or -1 to end : ");
            value = scanner.nextInt();
            ll = new ListNode(value);
            temp.next = ll;
            temp = ll;
        }
        return head;
    }

    public static void printLinkedList(ListNode A) {
        ListNode temp = A;

        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
