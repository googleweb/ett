/**
 * DateUtil.java create by chen at 2008-12-17 ,下午02:44:42
 * lineup by ft.comp
 */
package com.ett.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换工具
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class DateUtil {
	
	public static String[] dayOfWeekChinese = new String[] { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};
	
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
	 * 返回周一到周七，分别丄1�7�1�7
	 * @param date 日期
	 * @return 周几
	 */
	public static int getDayOfWeek(Date date)
	{
		Calendar   aCalendar=Calendar.getInstance();//里面可以直接插入date类型   
        aCalendar.setTime(date);  //从星期天到星期六，分别是1刄1�7
        int day=aCalendar.get(Calendar.DAY_OF_WEEK);
        if(day==1)
        {
        	return 7;
        }
        return day-1;
     
	}

}
