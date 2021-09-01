package com.algo.practice.module.linkedlist;

public class ReverseLinkedListII {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		LinkedListUtility.printList(reverseList(LinkedListUtility.arrayToList(arr), 2, 4));
	}

	public static ListNode reverseList(ListNode head, int left, int right) {
		ListNode current = head;
		ListNode prev = null, next = null;
		while(current != null) {
			if(current.val == left) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
		}
		head = prev;
		return head;
	}
}
