package com.algo.practice.array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingArray {
	public static void main(String[] args) {
		String[] words = { "mass", "as", "hero", "superhero" };
		stringMatching(words).stream().forEach(a -> System.out.println(a));
	}

	public static List<String> stringMatching(String[] words) {
		if(words == null || words.length == 0)
            return new ArrayList<>();
        
        Set<String> set = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j)
					continue;

				if (words[i].indexOf(words[j]) != -1)
					set.add(words[j]);
			}
		}
		return new ArrayList<>(set);
	}
}
