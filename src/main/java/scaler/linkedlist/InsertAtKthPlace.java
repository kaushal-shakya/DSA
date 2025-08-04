package scaler.linkedlist;

import java.util.Scanner;

public class InsertAtKthPlace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = ListNode.createLinkedList();

        System.out.println("Enter the value for newly inserted node : ");
        int value = scanner.nextInt();
        System.out.println("Enter new node position : ");
        int pos = scanner.nextInt();
        ListNode temp = head;

        // Node is inserted at beginning
        if(pos == 0){
            ListNode ll = ListNode.createNode(value);
            ll.next = temp;
            head = ll;
        }

        ListNode prevNode = ListNode.getKthNode(head, pos-1);
        if(prevNode != null){
            ListNode.insertNodeAtK(value, prevNode);
        }else {
            while (temp.next != null)
            {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(value);
            temp.next = newNode;
        }

        ListNode.printLinkedList(head);
    }
}
