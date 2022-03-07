package com.algo.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	//Backtracking approach: choose - explore - unchoose
	public static void main(String[] args) {
		//printChar(permute(new char[] {'A','A', 'B'}));
		print(permuteUnique(new int[] { 1, 1, 1 }));
		//print(permute(new int[] { 1, 2, 3 }));
//		print(permute(new int[] { 0, 1 }));
//		print(permute(new int[] { 1 }));
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> listOfNums = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		helperUnique(nums, used, listOfNums, sublist);
		return listOfNums;
	}

	private static void helperUnique(int[] nums, boolean[] used, List<List<Integer>> listOfNums,
			List<Integer> sublist) {
		if (nums.length == sublist.size()) {
			listOfNums.add(new ArrayList<>(sublist));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && used[i - 1])
				continue;
			sublist.add(nums[i]);
			used[i] = true;
			helperUnique(nums, used, listOfNums, sublist);
			used[i] = false;
			sublist.remove(sublist.size() - 1);
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> listOfNums = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		helper(nums, listOfNums, sublist);
		return listOfNums;
	}

	private static void helper(int[] nums, List<List<Integer>> listOfNums, List<Integer> sublist) {
		if (nums.length == sublist.size()) {
			listOfNums.add(new ArrayList<>(sublist));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!sublist.contains(nums[i])) {
				sublist.add(nums[i]);
				helper(nums, listOfNums, sublist);
				sublist.remove(sublist.size()-1);
			}
		}
	}
	
	public static List<List<Character>> permute(char[] c){
		List<List<Character>> result = new ArrayList<>();
		backtrack(c, result, new ArrayList<Character>(), new boolean[c.length]);
		return result;
	}
	
	public static void backtrack(char[] c, List<List<Character>> result, List<Character> sublist, boolean[] used) {
		if(c.length == sublist.size()) {
			result.add(new ArrayList<>(sublist));
			return;
		}
		
		for (int i = 0; i < c.length; i++) {
			if(used[i]) continue;
			if(i > 0 && c[i-1] == c[i] && !used[i-1]) continue;
			sublist.add(c[i]);
			used[i] = true;
			backtrack(c, result, sublist, used);
			sublist.remove(sublist.size()-1);
			used[i] = false;
		}
	}

	public static void print(List<List<Integer>> listOfNums) {
		System.out.println("===START===");
		for (List<Integer> nums : listOfNums) {
			for (Integer num : nums) {
				System.out.print(num);
			}
			System.out.println();
		}
		System.out.println("===END===");
	}
	
	public static void printChar(List<List<Character>> listOfChars) {
		System.out.println("===START===");
		for (List<Character> chars : listOfChars) {
			for (Character c : chars) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println("===END===");
	}
}
