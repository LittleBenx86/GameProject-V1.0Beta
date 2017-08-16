package com.unicorn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormateUtils {
	
	private static final DateTimeFormateUtils dateTimeFormatUtils = new DateTimeFormateUtils();
	
	/**
	 * 单例设计模式
	 */
	private DateTimeFormateUtils() {
		// TODO Auto-generated constructor stub
	}

	public static DateTimeFormateUtils getDatetimeformatutils() {
		return dateTimeFormatUtils;
	}
	
	public String formateOperation(Date date,String formateReg) {
		SimpleDateFormat formate = new SimpleDateFormat(formateReg);
		return formate.format(date);
	}
}
