/**
 * DateUtil.java create by chen at 2008-12-17 ,涓嬪崍02:44:42
 * lineup by ft.comp
 */
package com.ett.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 鏃堕棿杞崲宸ュ叿
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class DateUtil {
	
	public static String[] dayOfWeekChinese = new String[] { "鏄熸湡涓�", "鏄熸湡浜�", "鏄熸湡涓�", "鏄熸湡鍥�", "鏄熸湡浜�", "鏄熸湡鍏�", "鏄熸湡鏃�"};
	
	public static String getDayOfWeekChinese(int dayofweek)
	{
		return dayOfWeekChinese[dayofweek-1];
	}
	
	public static Date addMonths(Date date,int adds)
	{
		return add(date,Calendar.MONTH,adds);
	}
	public static Date addYears(Date date,int adds)
	{
		return add(date,Calendar.YEAR,adds);
	}
	public static Date addDays(Date date,int adds)
	{
		return add(date,Calendar.DATE,adds);
	}
	public static Date add(Date date,int type,int adds)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(type, adds); 
        return c.getTime();
	}
	public static String parseString(Date date) throws ParseException
	{
		return parseString(date,"yyyy-MM-dd");
	}
	public static String parseString(Date date,String formater) throws ParseException
	{
		SimpleDateFormat sf=new SimpleDateFormat(formater);
		return sf.format(date);
	}
	
	public static Date parseDate(String date) throws ParseException
	{
		return parseDate(date,"yyyy-MM-dd");
	}
	public static Date parseDate(String date,String formater) throws ParseException
	{
		SimpleDateFormat sf=new SimpleDateFormat(formater);
		return sf.parse(date);
	}
	
	/**
	 * 杩斿洖鍛ㄤ竴鍒板懆涓冿紝鍒嗗埆涓��
	 * @param date 鏃ユ湡
	 * @return 鍛ㄥ嚑
	 */
	public static int getDayOfWeek(Date date)
	{
		Calendar   aCalendar=Calendar.getInstance();//閲岄潰鍙互鐩存帴鎻掑叆date绫诲瀷   
        aCalendar.setTime(date);  //浠庢槦鏈熷ぉ鍒版槦鏈熷叚锛屽垎鍒槸1鍒�
        int day=aCalendar.get(Calendar.DAY_OF_WEEK);
        if(day==1)
        {
        	return 7;
        }
        return day-1;
     
	}

}
