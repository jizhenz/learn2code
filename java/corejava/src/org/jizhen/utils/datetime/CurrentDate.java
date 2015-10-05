/**
 * 
 */
package org.jizhen.utils.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Use a specific day and time to define the format pattern:
 *     2000-12-31 23:59:59:000
 * 
 * 
 * @author jizhen
 *
 */
public final class CurrentDate {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	
	private CurrentDate() {}
	
	public static String format(String pattern) {
		switch (pattern) {
			case "20001231235959":
				simpleDateFormat.applyPattern("yyyyMMddHHmmss");
				return simpleDateFormat.format(new Date());
			case "20001231":
				simpleDateFormat.applyPattern("yyyyMMdd");
				return simpleDateFormat.format(new Date());
			case "2000-12-31":
				simpleDateFormat.applyPattern("yyyy-MM-dd");
				return simpleDateFormat.format(new Date());
			case "12/31/2000":
				simpleDateFormat.applyPattern("MM/dd/yyyy");
				return simpleDateFormat.format(new Date());
			default:
				throw new IllegalArgumentException("Invalid format pattern for current date!");
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(CurrentDate.format("20001231235959"));
		System.out.println(CurrentDate.format("20001231"));
		System.out.println(CurrentDate.format("2000-12-31"));
		System.out.println(CurrentDate.format("12/31/2000"));

	}

}
