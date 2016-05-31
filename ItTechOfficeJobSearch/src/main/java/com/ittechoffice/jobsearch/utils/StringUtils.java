package com.ittechoffice.jobsearch.utils;

public class StringUtils {
	public static String removeLastChar(String str){
		str = str.substring(0, str.length()-1);
		return str;
	}
	
	public static String removeFirstLastChar(String str){
		str = str.substring(1);
		str = str.substring(0, str.length()-1);
		return str;
	}
}
