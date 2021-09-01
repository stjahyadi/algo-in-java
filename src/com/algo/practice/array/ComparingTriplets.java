package com.algo.practice.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparingTriplets {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 17, 28, 30 });
		List<Integer> b = Arrays.asList(new Integer[] { 99, 16, 8 });
		compareTriplets(a, b);
	}

	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(0);
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i))
				result.set(0, result.get(0)+1);
			else if (a.get(i) < b.get(i))
				result.set(1, result.get(1)+1);
			else
				continue;
		}
		return result;
	}
	
	public static List<Integer> solution(List<Integer> a, List<Integer> b){
		int alice = 0;
		int bob = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)) alice++;
			else if (a.get(i) < b.get(i))
				bob++;
			else
				continue;
		}

	    return Arrays.asList(new Integer[] {alice, bob});
	}
	
}
