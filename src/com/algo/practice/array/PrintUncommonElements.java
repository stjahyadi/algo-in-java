package com.algo.practice.array;
import java.util.HashSet;
import java.util.Set;

public class PrintUncommonElements {

	public static void main(String[] args) {
		int arr1[] = { 10, 20, 30 };
		int arr2[] = { 20, 25, 30, 40, 50 };
		print(solution(arr1, arr2));
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(", ");
		}
	}

	public static int[] solution(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		int i = 0, j = 0;
		/*while (i < nums1.length && j < nums2.length) {
			if (!set.contains(nums1[i]))
				set.add(nums1[i]);
			else
				set.remove(nums1[i]);

			if (!set.contains(nums2[j]))
				set.add(nums2[j]);
			else
				set.remove(nums2[j]);
			
			i++;j++;
		}*/
		for (int num : nums1) {
			if (!set.contains(num))
				set.add(num);
			else
				set.remove(num);
		}

		for (int num : nums2) {
			if (!set.contains(num))
				set.add(num);
			else
				set.remove(num);
		}
		return set.stream().mapToInt(Integer::intValue).toArray();
	}
}
