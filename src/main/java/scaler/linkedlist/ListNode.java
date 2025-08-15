package scaler.linkedlist;

import java.util.List;
import java.util.Scanner;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int data){
        this.val = data;
        this.next = null;
    }

    public static ListNode createNode(int val){
        return new ListNode(val);
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
            if(value != -1){
                ll = new ListNode(value);
                temp.next = ll;
                temp = ll;
            }
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

    public static void insertNodeAtK(int value , ListNode prev){
        ListNode newNode = new ListNode(value);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public static ListNode getKthNode(ListNode A,  int k)
    {
        ListNode temp = A; // store A into temp so that head is not misplaced
        int i  = 0; // index = 0
        while( i < k && temp != null) // if only one ele, then
        {
            temp = temp.next;
            i++;
        }

        return temp;
    }
//
//    public static ListNode deleteNode(ListNode head, int deleteValue){
//        ListNode temp = head;
//        if (temp == null)
//            return temp;
//
//        if(temp.val == deleteValue){
//            head = head.next;
//            return head;
//        }
//
//        while(temp.next != null){
//
//        }
//    }
}
