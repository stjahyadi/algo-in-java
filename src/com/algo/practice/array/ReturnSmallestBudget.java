package com.algo.practice.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnSmallestBudget {
	public static void main(String[] args) {
		List<Integer> days = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 15));
		// Expected: 1850

		// List<Integer> days = new ArrayList<Integer>(Arrays.asList(21, 38));
		// Expected: 1300

		// List<Integer> days = new ArrayList<Integer>(Arrays.asList(1, 2, 8, 11, 30));
		// Expected: 2950 = 2300 + 650
		System.out.println(solution(days));
	}

	public static int solution(List<Integer> days) {
		int total = 0;
		Map<Integer, Integer> opt = new HashMap<Integer, Integer>();
		opt.put(1, 650);
		opt.put(7, 1200);
		opt.put(14, 1900);
		opt.put(30, 2300);

		int index = 0;
		int duration = 1;
		List<Integer> budgets = new ArrayList<Integer>();
		for (int i = 1; i < days.size(); i++) {
			if (days.get(index) + 1 == days.get(i)) {
				index++;
				duration++;
				budgets.add(0, duration);
				continue;
			} else {
				budgets.add(duration);
			}
		}

		for (Integer i : budgets) {
			Integer budget = opt.getOrDefault(i, 0);
			if (budget != 0)
				total += budget;
		}

		return total;
	}

	public static int solution2(List<Integer> days) {
		int total = 0;
		Map<Integer, Integer> opt = new HashMap<Integer, Integer>();
		opt.put(1, 650);
		opt.put(7, 1200);
		opt.put(14, 1900);
		opt.put(30, 2300);

		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < days.size(); i++) {
			if(days.get(index) + 1 == days.get(i)) {
				//map.put
			}
		}

		return total;
	}
}
