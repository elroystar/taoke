package com.derhede.taoke.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	/**
	 * 格式化日期
	 * @param source
	 * @param format yyyy-mm-dd
	 * @return
	 */
	public static  String dateFormatToString(String source,String format) {
		if(source==null||"".equals(source)) return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		return dateFormat.format(source);
	}
	
	/**
	 * 格式化日期
	 * @param source
	 * @param format yyyy-mm-dd
	 * @return
	 */
	public static  String dateFormatToString(Date source,String format) {
		if(source==null||"".equals(source)) return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		return dateFormat.format(source);
	}
	
	public static String firstToUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
	}
	
	public static String firstToLower(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
	}
	
}
