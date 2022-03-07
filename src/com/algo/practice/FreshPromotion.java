package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreshPromotion {
	public static void main(String[] args) {
//		List<List<String>> codeList = new ArrayList<>();
//		codeList.add(Arrays.asList(new String[] { "apple", "apple" }));
//		codeList.add(Arrays.asList(new String[] { "banana", "anything", "banana" }));
//		System.out.println(solution(codeList,
//				Arrays.asList(new String[] { "orange", "apple", "apple", "banana", "orange", "banana" }))); //Output: 1

		List<List<String>> codeList2 = new ArrayList<>();
		codeList2.add(Arrays.asList(new String[] {"anything", "apple"}));
		codeList2.add(Arrays.asList(new String[] {"banana", "anything", "banana"}));
		System.out.println(solution(codeList2,
				Arrays.asList(new String[] { "orange", "grape", "apple", "orange", "orange", "banana", "apple",
						"banana", "banana" }))); //Output: 0
		
//		List<List<String>> codeList3 = new ArrayList<>();
//		codeList3.add(Arrays.asList(new String[] {"apple", "apple"}));
//		codeList3.add(Arrays.asList(new String[] {"banana", "anything", "banana"}));
//		System.out.println(solution(codeList3, Arrays.asList(new String[] { "banana", "orange", "banana", "apple", "apple" }))); //Output: 0
//		
//		List<List<String>> codeList4 = new ArrayList<>();
//		codeList4.add(Arrays.asList(new String[] {"apple", "apple"}));
//		codeList4.add(Arrays.asList(new String[] {"apple", "apple", "banana"}));
//		System.out.println(solution(codeList4, Arrays.asList(new String[] { "apple", "apple", "apple", "banana" }))); //Output: 0
//		
//		List<List<String>> codeList5 = new ArrayList<>();
//		codeList5.add(Arrays.asList(new String[] {"apple", "apple"}));
//		codeList5.add(Arrays.asList(new String[] {"apple", "apple", "banana"}));
//		System.out.println(solution(codeList5, Arrays.asList(new String[] { "apple", "banana", "apple", "banana", "orange", "banana" }))); //Output: 0

	}


	private static boolean itemMatch(String code, String item) {
		if ("anything".equals(code))
			return true;
		else if (item.equals(code))
			return true;
		else
			return false;
	}

	public static int solution(List<List<String>> codes, List<String> shoppingCart) {
		int listIndex = 0;
		int listItemIndex = 0;
		boolean currListMatches = false;
		List<String> currList = codes.get(listIndex++);
		for (String item : shoppingCart) {
			String code = currList.get(listItemIndex);
			if (currListMatches && !itemMatch(code, item)) {
				listItemIndex = 0;
			} else if (itemMatch(code, item)) {
				currListMatches = true;
				listItemIndex++;
				if (listItemIndex == currList.size()) {
					if (listIndex == codes.size())
						return 1;

					currList = codes.get(listIndex++);
					currListMatches = false;
					listItemIndex = 0;
				}
			}
		}
		return 0;
	}
}
