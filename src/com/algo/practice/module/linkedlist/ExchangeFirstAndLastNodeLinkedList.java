package com.algo.practice.module.linkedlist;

public class ExchangeFirstAndLastNodeLinkedList {
	public static void main(String[] args) {
		int[] arr = {6, 1, 2, 3, 4, 5 }; // Output: 5 1 2 3 4 6
		ListNode head = LinkedListUtility.arrayToList(arr);
		LinkedListUtility.printList(exchangeValues(head));
		//LinkedListUtility.printList(exchangeNodes(head));
		
		
		int[] arr2 = {5, 4, 3, 2, 1 }; // Output: 1 4 3 2 5
		ListNode head2 = LinkedListUtility.arrayToList(arr2);
		LinkedListUtility.printList(exchangeValues(head2));
	}
	
	public static ListNode exchangeValues(ListNode head) {
		ListNode tail = head;
		while(tail.next != null && tail.next != head) {
			tail = tail.next;
		}
		
		int tmp = tail.val;
		tail.val = head.val; 
		head.val = tmp;
		return head;
	}
	
	public static ListNode exchangeNodes(ListNode head) {
		ListNode tail = head;
		while(tail.next != null && tail.next != head) {
			tail = tail.next;
		}
		tail.next = head.next;
        head.next = tail.next;
        tail.next = head;
        head = head.next;
        return head;
	}
}
