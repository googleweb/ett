/**
 * @(#)StringUtil.java 
 * 
 * create by x_chenbiwu at 2008-3-7
 * 
 * Copyright 2008 fivemen,Inc. All rights reserved.
 * 
 * fivemen proprietary/confidential.Use is subject to license terms
 */
package com.ett.common.util;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Description:</p>
 * <p>瀛楃涓叉搷浣滃伐鍏风被</p>
 * @author x_chenbiwu
 *
 */
public class StringUtil {
	
	protected static final Log log = LogFactory.getLog(StringUtil.class);
	/**
	 * 榛樿鐨勭┖瀛楃涓�
	 */
	public static final String EmptyString="";
	
	 private StringUtil()
     {
    	 
     }
	
	/**
	 * <p>濡傛灉鏄负绌烘垨鑰�""杩斿洖鐪燂紝鍚﹀垯鍋�p>
	 * @param arg 琚獙璇佺殑瀛楃涓�
	 * @return 濡傛灉鏄负绌烘垨鑰�""杩斿洖鐪燂紝鍚﹀垯鍋�
	 */
	public static boolean isNullOrEmpty(final String arg)
	{
		return arg==null||EmptyString.equals(arg);
	}
	
	/**
	 * @param map 鍙傛暟Map
	 * @param key key
	 * @param value 鍊�
	 */
	public static void addParamterToMap(HashMap map,String key,Object value)
	{
		log.info("澧炲姞鍙傛暟锛�"+key+"鍊硷細"+value+"鍒癏ashMap涓�");
		map.put(key, value);
		/*if(map.containsKey(key))
		{
			map.remove(key);
		}*/
		
	}
	
	/**
	 * @param map 瀛楃涓插弬鏁扮殑HashMap
	 * @return 缁勬垚鐨勫瓧绗︿覆鍙傛暟
	 */
	public static String makeParamter(HashMap map)
	{
		StringBuilder sb=new StringBuilder();
		String result=null;
		java.util.Iterator iterator=map.keySet().iterator();
		String key=null;
		Object obj=null;
		boolean flag=iterator.hasNext();
		while(iterator.hasNext())
		{
			key=iterator.next().toString();
			log.info("鍙傛暟Map涓殑key涓猴細"+key);
			obj=map.get(key);
			log.info("鍙傛暟Map涓殑Value涓猴細"+obj);
			if(obj==null)
			{
				obj="";
			}
			sb.append(key);
			sb.append("=");
			sb.append(obj.toString());
			sb.append("&");
		}
		result=sb.toString();
		if(flag)
		{
			result=result.substring(0,result.length()-1);
		}
		log.info("鐢盚ashMap缁勬垚鐨勫瓧绗︿覆鍙傛暟涓猴細"+result);
		return result;
	}
	
	/**
	 * @param map 鎵撳嵃HashMap
	 */
	public static void printMap(HashMap map)
	{
		java.util.Iterator iterator=map.keySet().iterator();
		Object key=null;
		Object obj=null;
		while(iterator.hasNext())
		{
			key=iterator.next();
			obj=map.get(key);
			System.out.println("key:"+key+" value:"+obj);
			
		}
	}
	
	/**
	 * @param url 鍙傛暟url
	 * @return 鍙傛暟澶勭悊鍚庢斁鍏ヤ竴涓猰ap
	 */
	public static HashMap getParamters(String url)
	{
		log.info("闇�瑕佽幏鍙栧弬鏁扮殑url涓猴細"+url);
		HashMap<String,String> map=new HashMap<String, String>();
		int index=url.indexOf("?");
		if(index!=-1)
		{
			url=url.substring(index+1);
			log.info("url鐨勫弬鏁版槸锛�"+url);
			//String[] array=str.split("?");
			String[] array2=url.split("&");
			log.info("url鐨勫弬鏁颁釜鏁版槸锛�"+array2.length);
			for(String s:array2)
			{
				log.info("鍙傛暟锛�"+s);
				String[] array=s.split("=");	
				if(array.length==2)
				{
					log.info("鍔犲叆鍙傛暟key锛�"+array[0]+" value:"+array[1]+"鍒癿ap涓�");
					map.put(array[0], array[1]);
				}
				else
				{
					log.info("鍔犲叆鍙傛暟key锛�"+array[0]+" value:鍒癿ap涓�");
					map.put(array[0], "");
				}
				
			}
			
		}
		
		return map;
		
		
	}
	

}
