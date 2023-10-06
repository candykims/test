package com.jytpay.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能:通用的静态工具函数(用于日期和时间处理)
 * <p>Description: 通用工具类</p>
 */
public class DateTimeUtils {

	public final static String DATETIME_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	/**
	 * 把日期按照指定格式的转化成字符串
	 * @param date 日期对象
	 * @param formatStr 日期格式
	 * @return 字符串式的日期,格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTimeToString(Date date,String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}

    
}
