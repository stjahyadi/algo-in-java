package com.algo.practice;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FilenameUtils;



class Animal{
	private String name;
	
	
}


class Elephant extends Animal {
	public void sound() {
		
	}
}

public class Main2 {
	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}

		int n = haystack.length();
		int m = needle.length();
		int diff = n-m+1;
	
		int pointer = 0;
		for (int i = 0; i < diff; i++) {
			System.out.println("i = " + i + " and pointer = " + pointer);
			if (haystack.charAt(i) == needle.charAt(pointer)) {
				String str = haystack.substring(i, i + m);
				if(str.equals(needle))
					return i;
			}
		}
		return -1;
	}
	
	private static boolean isAlphanumeric(char c) {
        if (( c > '0' &&  c < '9') ||
            ( c > 'A' &&  c < 'Z') ||
            ( c > 'a' &&  c < 'z')) {
            return true;
        }
        return false;
    }
	
	public static void testIndexOf() {
		String str = "aabaa";
		String needle = "bba";
		System.out.println(str.indexOf(needle));
	}
	
	public static void testPath() {
		String filename = "/../app/DRCAPAppShare_old/test.pdf.gz";
		Path path = Paths.get(filename);
		try {
			System.out.println(path.toFile().getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = path.toFile();
		
	}
	
	public static String getSystemType(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") - 1,
                                  fileName.lastIndexOf("."));
    }
	
	private static String sanitizePathTraversal(String input) {
		Path p = Paths.get(input);
		return p.getFileName().toString();
	}
	
	private static java.util.Date firstUtilDateOfMonth(java.util.Date inputDate) {
		if (inputDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(inputDate);

			calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

			java.util.Date firstDayOfMonth = new java.util.Date(calendar.getTimeInMillis());
			return firstDayOfMonth;
		} else {
			return null;
		}
	}
	
	public static int getHours(java.util.Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.HOUR);
	}
	
	public static int getMinutes(java.util.Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	public static void utcToGmt() {
		String inputValue = "2021-08-03T08:13:22.000Z";
		Instant timestamp = Instant.parse(inputValue);
		ZonedDateTime losAngelesTime = timestamp.atZone(ZoneId.of("Asia/Singapore"));
		System.out.println(losAngelesTime);
	}
	
	public static void main(String[] args) {
		utcToGmt();
		System.out.println(Math.round((double)73/10));
		
		System.out.println(new Date());
		String[] aaa = {"abc", "2", "0"};
		List<String> aaa1 =  Arrays.asList(aaa);
		Collections.sort(aaa1);
		System.out.println(aaa1.get(2));
		System.out.println("apple".compareTo("banana"));
		
		String destFolderPath = "/app/DrcapAppShare/data/penalty/AccountingDataFile";
		String penaltyAdfFolderPath = "/app/DrcapAppShare/data/penalty/AccountingDataFile";
		String penAdfFilePrefix = "ADF_P_";
		String runId = "12312312";
		String adfBradfFileExtDat = "dat";
		String fileName = sanitizePathTraversal(penaltyAdfFolderPath + File.separator + penAdfFilePrefix + runId + "." + adfBradfFileExtDat);
		System.out.println(fileName);
		File adfFile = new File(penaltyAdfFolderPath + File.separator + FilenameUtils.normalize(fileName));
		
		String username = null;
		String applicationName = "MEUC";
		String realmName = "emcdev";
		String completeUrl = null;
		String host = "123";
		String str = String.join(",", username, applicationName, realmName, completeUrl, host, "%s"); 
		System.out.println(String.format(str, "SUCCESS").replace('\t', '_').replace('\n', '_').replace('\r', '_'));
		
		//java.util.Date d = convertStringToUtilDate("06-Jun-2021 08:03:50", "dd-MMM-yyyy HH:mm:ss");
		java.util.Date d = new java.util.Date();
		System.out.println(String.format("%02d%02d", getHours(d), getMinutes(d)));
		
		System.out.println(getSystemType("SG_Internal_Funds_Transfer_20210717_V2_D.csv"));
		java.util.Date dt = convertStringToUtilDate("2021-07-01", "yyyy-MM-dd");
		System.out.println("HERE "+firstUtilDateOfMonth(dt).toString());
		
		if("pdf".equalsIgnoreCase(FilenameUtils.getExtension("/app/DRCAPAppShare/data/rex/RexEmailNotification/REXnotification_04Jun2021_941.pdf"))) {
			System.out.println("PDF");
		}else {
			System.out.println("text");
		}
		
		String eventId = "123	";
		
		if(eventId != null)
			eventId = eventId.replace('1', '0').replace('\t', '_').replace('\n', '_').replace('\r', '_');
		
		System.out.println(eventId);
		
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		for(int i=0;i<list.size();i++) {
			System.out.println(list.remove(i));
		}
		System.out.println(list);
		
//		System.out.println("flower".indexOf("flow"));
//		
//		Integer no = null;
//		BigDecimal bi = new BigDecimal("2");
//		no = bi.intValue();
//		System.out.println(no+1);
//		
//		System.out.println(strStr("hello", "ll"));
//		testIndexOf();
//		System.out.println(isAlphanumeric('a'));
//		testPath();
//		convertStringToInteger();
	}
	
	public static java.util.Date convertStringToUtilDate(String utilDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
		java.util.Date date = null;
		try {
			date =  formatter.parse(utilDate);
		} catch (ParseException e) {
		}
		return date;
	}
	
	public static void convertStringToInteger() {
		String str = "123";
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			result = result * 10 + (str.charAt(i) - '0');
		}
	}

	public static void findNumberInString() {
		String input = "qwerty1qwerty2";
		int n = input.length();
		List<Integer> tmp = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			char c = input.charAt(i);
			try {
				tmp.add(Integer.valueOf(""+c));
			}catch(Exception ex) {
				System.out.println("Unable to convert alphabet " + c + " into numberic");
			}
		}
		Integer[] output = new Integer[tmp.size()];
		tmp.toArray(output);
		System.out.println(Arrays.toString(output));
	}
}
