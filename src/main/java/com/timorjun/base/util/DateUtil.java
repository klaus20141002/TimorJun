/******************************************************************************
 * @File name   :      DateYtil.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月9日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年7月9日 下午12:59:14        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.timorjun.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  DateUtil for common use
 */
public class DateUtil {
	private static SimpleDateFormat dateFormat;
	private DateUtil() {}
	
	static {
		dateFormat = new SimpleDateFormat();
	}
	
	/**yyyy_mm_dd  2017-08-09*/
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/**yyyy-MM-dd HH:mm:ss  2017-08-09 13:03:23 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**yyyy-MM-dd HH:mm  2017-08-09 13:03 */
	public static final String YYYY_MM_DD_HH_MM = "";
	
	/**
	 * @Date        :      2017年7月9日
	 * @param date
	 * @param pattern
	 * @return apply pattern then parse , return pattern-style date String
	 * @throws Exception
	 */
	public static String parseString(Date date, String pattern) throws Exception {
		dateFormat.applyPattern(pattern);
		return dateFormat.format(date);
	}
	
	
	
	
	
	/**
	 * @Date        :      2017年7月9日
	 * @param date
	 * @param pattern
	 * @return apply pattern then parse , return pattern-style date
	 * @throws Exception
	 */
	public static Date parseDate(String date, String pattern) throws Exception {
		dateFormat.applyPattern(pattern);
		return dateFormat.parse(date);
	}
	
	
	
	

}
