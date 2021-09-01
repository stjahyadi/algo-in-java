package com.algo.practice;

public class TimeConversion {
	public static void main(String[] args) {
		System.out.println(timeConversion("12:40:22AM")); // 00:40:22
		System.out.println(timeConversion("07:05:45PM")); // 19:05:45
		System.out.println(timeConversion("06:40:03AM")); // 06:40:03
		System.out.println(timeConversion("12:45:54PM")); // 12:45:54
	}

	public static String timeConversion(String s) {
		String[] format = s.split(":");
		int hh = Integer.parseInt(format[0]);
		int mm = Integer.parseInt(format[1]);
		int ss = Integer.parseInt(format[2].substring(0, 2));
		String ampm = format[2].substring(2, 4);
		if ("AM".equals(ampm) && hh == 12)
			hh = 0;
		else
			hh += 12;

		return String.format("%02d:%02d:%02d", hh, mm, ss);
	}
}
