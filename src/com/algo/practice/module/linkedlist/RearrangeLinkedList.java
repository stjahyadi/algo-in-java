package com.algo.practice.module.linkedlist;

import java.util.Stack;

public class RearrangeLinkedList {
	public static void main(String[] args) {
		ListNode l1 = LinkedListUtility.arrayToList(new int[] { 1, 2, 3, 4 }); // Expected: 1 -> 4 -> 2 -> 3
		LinkedListUtility.printList(solution(l1));

		ListNode l2 = LinkedListUtility.arrayToList(new int[] { 1, 2, 3, 4, 5 }); // Expected: 1 -> 5 -> 2 -> 4 -> 3
		//LinkedListUtility.printList(solution(l2));
	}

	public static ListNode solution(ListNode node) {
		Stack<Integer> stack = new Stack<>();
		while (node != null) {
			node = node.next;
		}

		return null;
		// return head;
	}

}
