package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/search-suggestions-system/ */
public class SearchSuggestionsSystem {
	public static void main(String[] args) {
		String[] products1 = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord1 = "mouse";
		
		/*
		Output: [
		["mobile","moneypot","monitor"],
		["mobile","moneypot","monitor"],
		["mouse","mousepad"],
		["mouse","mousepad"],
		["mouse","mousepad"]
		]
		*/
		print(solution(Arrays.asList(products1), searchWord1));
		print(suggestedProducts(products1, searchWord1));
		
		String[] products2 = {"havana"};
		String searchWord2 = "havana";
		//Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
		print(solution(Arrays.asList(products2), searchWord2));
		print(suggestedProducts(products2, searchWord2));
		
		String[] products3 = {"bags","baggage","banner","box","cloths"};
		String searchWord3 = "bags";
		//Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
		print(solution(Arrays.asList(products3), searchWord3));
		print(suggestedProducts(products3, searchWord3));
	}

	public static List<List<String>> solution(List<String> repository, String customerQuery) {
		List<List<String>> finalResult = new ArrayList<>();
		if (repository == null || repository.size() == 0 || customerQuery == null || customerQuery.isEmpty())
			return finalResult;

		Collections.sort(repository);
		for (int i = 0; i < customerQuery.length(); i++) {
			char c = customerQuery.charAt(i);
			List<String> filteredList = new ArrayList<>();
			for (String item : repository) {
				if (i < item.length() && c == item.charAt(i)) {
					filteredList.add(item);
				}
			}

			List<String> intermediateResult = new ArrayList<>();
			for (int j = 0; j < 3 && j < filteredList.size(); j++) {
				intermediateResult.add(filteredList.get(j));
			}

			finalResult.add(intermediateResult);
			repository = filteredList;
		}
		return finalResult;
	}
	
	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> finalResult = new ArrayList<>();
        Arrays.sort(products);
        for(int i=0;i<searchWord.length();i++){
            String s = searchWord.substring(0, i+1);
            List<String> filteredList = new ArrayList<>();
            for(String product : products) {
                if(product.startsWith(s)) {
                	filteredList.add(product);
                }
            }
            
			List<String> intermediateResult = new ArrayList<>();
			for (int j = 0; j < 3 && j < filteredList.size(); j++) {
				intermediateResult.add(filteredList.get(j));
			}
			
			finalResult.add(intermediateResult);
        }
        return finalResult;
    }

	public static void print(List<List<String>> main) {
		System.out.println("===START===");
		for (List<String> subMain : main) {
			int i = 0;
			for (String item : subMain) {
				System.out.print(item);
				if (i < subMain.size() - 1)
					System.out.print(", ");
				i++;
			}
			System.out.println();
		}
		System.out.println("===END===");
	}
}
