package com.algo.practice.module.string;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find101Pattern {
	public static void main(String[] args) {
		String str1 = "1001ab010abc01001"; // 2
		System.out.println(patternCount2(str1));

		String str2 = "1101001"; // 2
		System.out.println(patternCount2(str2));

		String str3 = "100001abc10110011001"; // 4
		System.out.println(patternCount2(str3));
	}

	public static int patternCount(String str) {
		String regex = "10+1";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str);
		int counter = 0;
		while (m.find()) {
			// As last character of current match
			// is always one, starting match from that index
			m.region(m.end() - 1, str.length());
			counter++;
		}
		return counter;
	}

	public static int patternCount2(String str) {
		char last = str.charAt(0);
		int counter = 0;
		int i = 1;
		while (i < str.length()) {
			if (last == '1' && str.charAt(i) == '0') {
				while (str.charAt(i) == '0') {
					i++;
				}
				if (str.charAt(i) == '1')
					counter++;
			}
			last = str.charAt(i);
			i++;
		}
		return counter;
	}
}
