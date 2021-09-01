package com.algo.practice.module.linkedlist;

public class LinkedListUtility {
	public static ListNode arrayToList(int[] arr) {
		ListNode head = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			ListNode current = new ListNode(arr[i]);
			current.next = head;
			head = current;
		}
		return head;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null)
				System.out.print(" -> ");
			node = node.next;
		}
		System.out.println();
	}
}
