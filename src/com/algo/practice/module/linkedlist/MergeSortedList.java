package com.algo.practice.module.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedList {
	public static void main(String[] args) {
		// ListNode l1 = arrayToList(new int[] { 1, 3, 8, 10 });
		// ListNode l2 = arrayToList(new int[] { 1, 4, 5, 6 });

		ListNode l1 = LinkedListUtility.arrayToList(new int[] { 10, 20, 30 });
		ListNode l2 = LinkedListUtility.arrayToList(new int[] { 1, 2, 3 });

		System.out.print("List1 = ");
		LinkedListUtility.printList(l1);
		System.out.println();
		System.out.print("List2 = ");
		LinkedListUtility.printList(l2);
		System.out.println();
		ListNode l3 = mergeSortedList(l1, l2);
		System.out.print("List3 = ");
		LinkedListUtility.printList(l3);

		ListNode l4 = LinkedListUtility.arrayToList(new int[] { 1, 4, 5 });
		ListNode[] nodes = new ListNode[] { l1, l2, l4 };
		ListNode output = mergeSortedKList(nodes);
		System.out.print("Output = ");
		LinkedListUtility.printList(output);
	}

	public static ListNode mergeSortedKList(ListNode[] listNodes) {
		if (listNodes.length == 0)
			return null;

		Queue<ListNode> queue = new LinkedList<ListNode>();
		for (ListNode node : listNodes)
			queue.add(node);

		while (queue.size() > 1) {
			ListNode l1 = queue.remove();
			ListNode l2 = queue.remove();
			ListNode merged = mergeSortedList(l1, l2);
			queue.add(merged);
		}
		return queue.remove();
	}

	public static ListNode mergeSortedList(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		while (l1 != null || l2 != null) {
			if (l2 == null || (l1 != null && l1.val < l2.val)) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		return head.next;
	}

}
