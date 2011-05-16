/**
 * @(#)StringUtil.java 
 * 
 * create by x_chenbiwu at 2008-3-7
 * 
 * Copyright 2008 fivemen,Inc. All rights reserved.
 * 
 * fivemen proprietary/confidential.Use is subject to license terms
 */
package com.austin.base.commons.util;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Description:</p>
 * <p>字符串操作工具类</p>
 * @author x_chenbiwu
 *
 */
public class StringUtil {
	
	protected static final Log log = LogFactory.getLog(StringUtil.class);
	/**
	 * 默认的空字符丄1�7
	 */
	public static final String EmptyString="";
	
	 private StringUtil()
     {
    	 
     }
	
	/**
	 * <p>如果是为空或耄1�7""返回真，否则偄1�7p>
	 * @param arg 被验证的字符丄1�7
	 * @return 如果是为空或耄1�7""返回真，否则偄1�7
	 */
	public static boolean isNullOrEmpty(final String arg)
	{
		return arg==null||EmptyString.equals(arg);
	}
	
	/**
	 * @param map 参数Map
	 * @param key key
	 * @param value 倄1�7
	 */
	public static void addParamterToMap(HashMap map,String key,Object value)
	{
		log.info("增加参数＄1�7"+key+"值："+value+"到HashMap丄1�7");
		map.put(key, value);
		/*if(map.containsKey(key))
		{
			map.remove(key);
		}*/
		
	}
	
	/**
	 * @param map 字符串参数的HashMap
	 * @return 组成的字符串参数
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
			log.info("参数Map中的key为："+key);
			obj=map.get(key);
			log.info("参数Map中的Value为："+obj);
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
		log.info("由HashMap组成的字符串参数为："+result);
		return result;
	}
	
	/**
	 * @param map 打印HashMap
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
	 * @param url 参数url
	 * @return 参数处理后放入一个map
	 */
	public static HashMap getParamters(String url)
	{
		log.info("霄1�7要获取参数的url为："+url);
		HashMap<String,String> map=new HashMap<String, String>();
		int index=url.indexOf("?");
		if(index!=-1)
		{
			url=url.substring(index+1);
			log.info("url的参数是＄1�7"+url);
			//String[] array=str.split("?");
			String[] array2=url.split("&");
			log.info("url的参数个数是＄1�7"+array2.length);
			for(String s:array2)
			{
				log.info("参数＄1�7"+s);
				String[] array=s.split("=");	
				if(array.length==2)
				{
					log.info("加入参数key＄1�7"+array[0]+" value:"+array[1]+"到map丄1�7");
					map.put(array[0], array[1]);
				}
				else
				{
					log.info("加入参数key＄1�7"+array[0]+" value:到map丄1�7");
					map.put(array[0], "");
				}
				
			}
			
		}
		
		return map;
		
		
	}
	

}
