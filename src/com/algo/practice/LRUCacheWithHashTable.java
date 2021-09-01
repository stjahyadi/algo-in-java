package com.algo.practice;
import java.util.LinkedHashMap;

public class LRUCacheWithHashTable {
	private LinkedHashMap<Integer, Integer> cache;
	private int capacity;

	public LRUCacheWithHashTable(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			int value = cache.remove(key);
			cache.put(key, value);
			return value;
		} else
			return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else {
			if (isFull()) {
				int firstItem = cache.entrySet().iterator().next().getKey();
				cache.remove(firstItem);
			}
		}
		cache.put(key, value);
	}

	public boolean isFull() {
		return cache.size() == capacity;
	}
}
