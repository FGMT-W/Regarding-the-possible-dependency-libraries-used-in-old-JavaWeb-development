/**
 * 
 */
package com.ujiuye.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @Title: DateTool.java
* @author: yanbo.deng
* @date: 2019年9月23日 下午7:52:20
* @Description:
*/
public class DateTool {
	private static SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//字符串转日期
	public static Date stringToDate(String dateStr) {
		try {
			return sdFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	//日期转字符串
	public static String dateToString(Date dtDate) {
		return sdFormat.format(dtDate);
	}
}


