package com.algo.practice.module.iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergedSortedIterator {
	/*
	You have N iterators (streams) that return elements in sorted order.
	Your goal is to create a top-level iterator that will return all elements from all iterators combined, but also in the sorted order.

	Example:
	- iterator `A`: *1, 3, 7*
	- iterator `B`: *1, 2, 5, 7, 11, 20*
	- iterator `C`: *0, 4*
	- output iterator: *0, 1, 1, 2, 3, 4, 5, 7, 7, 11, 20
	*/
	public static void main(String[] args) {
		List<Integer> it1 = Arrays.asList(1, 3, 7);
		List<Integer> it2 = Arrays.asList(1, 2, 5, 7, 11, 20);
		List<Integer> it3 = Arrays.asList(0, 4);
		print(merge2Iter(it1.iterator(), it2.iterator())); // 1 1 2 3 5 7 7 11 20 
		
		List<Iterator<Integer>> iters = Arrays.asList(it1.iterator(), it2.iterator(), it3.iterator());
		print(merge(iters)); // 0, 1, 1, 2, 3, 4, 5, 7, 7, 11, 20
	}

	public static Iterator<Integer> merge(List<Iterator<Integer>> iters) {
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(iters.size());
		for(Iterator<Integer> iter : iters) {
			while(iter.hasNext())
				pq.add(iter.next());
		}
		while (!pq.isEmpty()) {
            Integer curr = pq.poll();
            result.add(curr);
        }
		return result.iterator();
	}
	
	public static Iterator<Integer> merge2Iter(Iterator<Integer> it1, Iterator<Integer> it2) {
		List<Integer> result = new ArrayList<Integer>();
		Integer num1 = it1.hasNext() ? it1.next() : null;
		Integer num2 = it2.hasNext() ? it2.next() : null;
		while (num1 != null && num2 != null) {
			if (num1 <= num2) {
				result.add(num1);
				num1 = it1.hasNext() ? it1.next() : null;
			} else {
				result.add(num2);
				num2 = it2.hasNext() ? it2.next() : null;
			} 
		}

		while (num1 != null) {
			result.add(num1);
			num1 = it1.hasNext() ? it1.next() : null;
		}
		while (num2 != null) {
			result.add(num2);
			num2 = it2.hasNext() ? it2.next() : null;
		}

		return result.iterator();
	}

	public static void print(Iterator<Integer> iter) {
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
}
