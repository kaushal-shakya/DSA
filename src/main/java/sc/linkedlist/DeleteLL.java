package sc.linkedlist;

import java.util.Scanner;

public class DeleteLL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = ListNode.createLinkedList();
        System.out.println("Enter B-th node from the linked list to be deleted : ");
        int val = scanner.nextInt();

        ListNode newhead = solve(head, val);
        ListNode.printLinkedList(newhead);
    }

    public static ListNode solve(ListNode A, int B) {
        ListNode temp = A;
        //delete first element
        if ( B == 0 ){
           A = temp.next;
            return A;
        }
        ListNode preNode = ListNode.getKthNode(temp, B - 1);
        ListNode delNode = ListNode.getKthNode(temp, B);

        preNode.next = delNode.next;
        return A;
    }
}
