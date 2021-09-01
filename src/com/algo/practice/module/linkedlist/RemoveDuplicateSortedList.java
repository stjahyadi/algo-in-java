package com.algo.practice.module.linkedlist;

public class RemoveDuplicateSortedList {
	public static void main(String[] args) {
		//ListNode l1 = LinkedListUtility.arrayToList(new int[] { 1, 1, 2, 3, 3, 3 });
		//ListNode l1 = LinkedListUtility.arrayToList(new int[] { 0, 0, 0, 0, 0 });
		ListNode l1 = LinkedListUtility.arrayToList(new int[] { 0, 0, 0, 0, 3 });
		ListNode output = removeDuplicate(l1);
		LinkedListUtility.printList(output);
	}
	
	public static ListNode removeDuplicate(ListNode head) {
		if(head == null)
			return null;
		
		ListNode current = head;
		while(current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			}else
				current = current.next;
		}
		return head;
	}
	
}
