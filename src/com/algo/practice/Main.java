package com.algo.practice;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;




public class Main {
	
	public static String convertToFormat(String number) {
		String s = number;
		try {
			double amount = Double.parseDouble(number);
			DecimalFormat formatter = new DecimalFormat("#,##0.000"); // DRSAT-682 - Resolved .23 show as 0.23
			s = formatter.format(amount);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return s;
	}
	
	private static String validateString(String input) {
		boolean valid = input.matches("[-_. A-Za-z0-9]+\\.?[A-Za-z]+?");
		//"^[a-zA-Z][ ]*$"
		System.out.println(valid);
		if(!valid) {
			throw new RuntimeException("Input " + input + " is invalid");
		}
		return input;
	}

	public static String convertToFormatWithBracket(String number) {
		if(number == null)
			return null;
		
		String orgValue = number;
		String s = number.replace("(", "");
		s = s.replace("-", "");
		s = s.replace(")", "");
		if(isNumeric(s)) {
			s = convertToFormat(s);
			if (orgValue.contains("(") || orgValue.contains("-")) {
				s = "(" + s + ")";
			}
			return s;
		}
		return number;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null || strNum.equals("")) {
			return false;
		}
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static String formatMessage(String pattern, Object... objects) {
		MessageFormat mf = new MessageFormat(pattern);
		Object[] obj = new Object[objects.length];
		for (int i = 0; i < objects.length; i++) {
			obj[i] = objects[i];
		}
		return mf.format(obj);
	}
	
	public static void validateRegex() {
//		String text = "asd ad_a-123";
//		Pattern pattern = Pattern.compile("^[A-Za-z_ |-][A-Za-z0-9_ |-]*$");
//		Matcher matcher = pattern.matcher(text);
//        boolean matches = matcher.matches();
//        System.out.println(matches);
        
        //const regExpBetween = /^((\\d{1,4})(\\.\\d{1,2})?)[-]((\\d{1,4})(\\.\\d{1,2})?)$/;
        //const regExp = /^((((?:<>)|(?:<)|(?:<=)|(?:>)|(?:>=)|(?:=)))(\d{1,4})(\.\d{1,2})?)$/;
        //String value = "0-9.99";
		//String value = "<>121.112";
		String value = "10";
        Pattern pattern2 = Pattern.compile("^((\\d{1,4})(\\.\\d{1,2})?)([-]?)((\\d{1,4})(\\.\\d{1,2})?)$");
		Matcher matcher2 = pattern2.matcher(value);
		boolean matches2 = matcher2.matches();
		System.out.println(matches2);
		
		//String value = "<=10";
		Pattern pattern3 = Pattern.compile("^((((?:<>)|(?:<)|(?:<=)|(?:>)|(?:>=)|(?:=)))(\\d{1,4})(\\.\\d{1,2})?)$");
		Matcher matcher3 = pattern3.matcher(value);
		boolean matches3 = matcher3.matches();
		System.out.println(matches3);
		
		if(!matches2 && !matches3){
			System.out.println("Threshold Value is invalid, please enter a valid Threshold Value[e.g.,<>10,<1,>100,>=10,<=10,=20,0-9.99]");
		}

	}
	
	public static void testDateTimeFormat() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String input = "08-Jan-2020";
		LocalDate dateTime = LocalDate.parse(input, dateFormat);
		java.sql.Date v = java.sql.Date.valueOf(dateTime);
		System.out.println("Convert to java.sql.Date :" + v);

		String str = dateFormat.format(v.toLocalDate());
		System.out.println("Convert to String :" + str);
	}
	
	public static void main(String[] args) {
		validateRegex();
		Date tradingFromDate = convertStringToUtilDate("2015-12-13", "yyyy-MM-dd");
		Date tradingToDate = convertStringToUtilDate("2021-12-13", "yyyy-MM-dd");
		Integer difference = daysBetween(tradingFromDate, tradingToDate);
		if (difference != null && difference > 30 ) {
			System.out.println("End Date must be within 30 days from Start Date");
		}
		
		int a3 = 0;
		Integer a1 = a3;
		int a2 = 5;
		System.out.println(a1 == 0);
		System.out.println(new Integer(5) == new Integer(5));
        System.out.println(new Integer(500) == new Integer(500));

        System.out.println(Integer.valueOf(5) == Integer.valueOf(5));
        System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
		
		validateString("11-06-2020_30_Monthly_Run.zip");
		
		Integer p = 0;
		int o = 1;
		System.out.println(p == o);
		testDateTimeFormat();
		
		Boolean actionToBeStopped = Boolean.TRUE;
		Boolean isWithinCutoff = Boolean.FALSE;
		isWithinCutoff = Boolean.TRUE;
		actionToBeStopped = !isWithinCutoff;
		System.out.println(actionToBeStopped);
		
		String[] data = {"/TEST", "/TIST"};
		List<String> pl = Arrays.asList(data);
		String str = String.join(",", data);
		System.out.println(str.contains("TEST"));
		
		System.out.println("*** Normalization ***");
		 
        String filename = "X:\\JCG\\.\\org.apache.commons.io.FilenameUtils Example\\notes.txt";
        System.out.println("Before: " + filename);
        String normalized = FilenameUtils.normalize(filename);
        System.out.println("After single dot normalization: " + normalized);
		System.out.println("After Sanitize Path Variable " + Paths.get(normalized).toUri());
         
        filename = "X:\\JCG\\articles\\..\\notes.txt";
        System.out.println("Before: " + filename);
        normalized = FilenameUtils.normalize(filename);
        System.out.println("After double dot normalization: " + normalized);    
        System.out.println("After Sanitize Path Variable " + Paths.get(normalized).getFileName().toString());
        
        System.out.println(FilenameUtils.normalize("asdsad.xls"));
        System.out.println(Paths.get(FilenameUtils.normalize("asdsad.xls")).getFileName().toString());
        
        
		
		
		java.sql.Date tradingDate = new java.sql.Date(new Date().getTime());
		System.out.println(tradingDate);
		System.out.println(convertToFormatWithBracket("136773.973"));
		
		System.out.println(formatUtilDate(new Date()));
		format();
		
		
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
		File file = new File(path);
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
		
		byte a = 1;
		a += 5;
		byte b = (byte)(a+2);
		System.out.println(b);
		
		//
		float one = 12.2F;
		double two = 12.1F;
		System.out.println(one + two);
		
		String aa = "Some".concat("String");
		aa.concat("String");
		System.out.println(aa);
		
//		for ( ; ; ) {
//		    System.out.println();
//		}
		
	}
	
	public static Date convertStringToUtilDate(String utilDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
		Date date = null;
		try {
			date = formatter.parse(utilDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		return date;
	}
	
	public static Date formatUtilDate(Date utilDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(utilDate);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Integer daysBetween(Date fromDate, Date toDate) {
		if (null == fromDate || null == toDate) {
			return null;
		} else {
			return (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
		}
	}
	
	public static Date getCurrentDomainDateWithTimeSt() {
		final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String s = sdf.format(getCurrentUtilDate());
		Date date = null;
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	public static Date getCurrentUtilDate() {
		final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";
		return getCurrentUtilDate(DATE_FORMAT);
	}

	/**
	 * Get the current java.util.Date in the desired format
	 * 
	 * @return {@link Date}
	 */
	public static Date getCurrentUtilDate(String format) {
		
		Date currentDate = new Date();
		DateFormat df = new SimpleDateFormat(format);
		String currentDateStr = df.format(currentDate);

		Date returnDate = null;
		try {
			returnDate = df.parse(currentDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDate;
	}
	
	private static void format() {
		final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String s = sdf.format(getCurrentUtilDate());
		Date date = null;
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
	}

	private void someMethod() {
	    //variable needs to be initialized
		//int a;
	    //`System.out.println(a);
		
		byte a = 3;
		byte b = 8;
		byte c = (byte) (a + b);
	}
	
}

class SomeClass{
	// Correct
	public void someMethodOne(String... varargOne) {}
	
}

class ClassOne {
	static String a = "AA";
    void someMethod() {}
    public static void methodOne(){}
}
class ClassTwo extends ClassOne {
    protected void someMethod() {}
    public static void methodOne(){}
}

class SomeClass1 {
    static int someMethod() {
        return 5; 
    }
}
class AnotherClass {
	int a[] = new int[5]; //init with size
	int b[] = new int[] {1, 2, 3}; //init with value
    void someMethod() {
        SomeClass1 someClass = new SomeClass1();
        someClass.someMethod();
    }
}