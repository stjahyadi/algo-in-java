package com.algo.practice;
import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
    
    public Node(){
        this(0, 0);
    }
}

public class LRUCache {
	Node head;
	Node tail;
	Map<Integer, Node> cache;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		Node t = cache.get(key);
		update(t);
		return t.value;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node t = cache.get(key);
			t.value = value;
			// move to tail
			update(t);
		} else {
			if (cache.size() == capacity) {
				// delete head
				cache.remove(head.key);
				remove(head);
			}

			// add to tail
			Node node = new Node(key, value);
			add(node);
			cache.put(key, node);
		}
	}

	private void update(Node node) {
		remove(node);
		add(node);
	}

	private void add(Node node) {
		Node after = head.next;
		head.next = node;
		node.prev = head;
		node.next = after;
		after.prev = node;
	}

	private void remove(Node node) {
		Node before = node.prev, after = node.next;
		before.next = after;
		after.prev = before;
	}
}

