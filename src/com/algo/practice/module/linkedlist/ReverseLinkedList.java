package com.algo.practice.module.linkedlist;

public class ReverseLinkedList {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		//LinkedListUtility.printList(reverseList(LinkedListUtility.arrayToList(arr)));
		LinkedListUtility.printList(reverseListRecursive(LinkedListUtility.arrayToList(arr)));
		
		int[] arr2 = { 5, 1, 2, 3, 4 };
		LinkedListUtility.printList(reverseListRecursive(LinkedListUtility.arrayToList(arr2)));
		
	}
	
	public static ListNode reverseListRecursive(ListNode head) {
		if(head == null || head.next == null ) return head;
		ListNode last = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
	
	public static ListNode reverseList(ListNode head) {
        
        /*
        p prev
        n next
        c current
        h head
        
        NULL - 1 -> 2 -> 3 - NULL
        p n    c
        
                p    
        NULL <- 1 -> 2 -> 3 - NULL
                     n
                     c
                     
                     p
        NULL <- 1 <- 2 -> 3 - NULL
                          n
                          c
                          
                          h
                          p
        NULL <- 1 <- 2 <- 3 - NULL
                              n
                              c
        */
        //System.out.println("BEFORE");
        //printList(head);
        ListNode prev = null, next = null;
        ListNode current = head;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        
        return head;
    }
}
