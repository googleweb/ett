/**
 * @(#)CollectionUtil.java 
 * 
 * create by x_chenbiwu at 2008-3-7
 * 
 * Copyright 2008 fivemen,Inc. All rights reserved.
 * 
 * fivemen proprietary/confidential.Use is subject to license terms
 */
package com.austin.base.commons.util;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

/**
 * <p>Description:</p>
 * <p>集合工具类，对集合的丄1�7些操纄1�7/p>
 * @author x_chenbiwu
 *
 */
public class CollectionUtil {
	
	
	private CollectionUtil()
	{
		
	}
	/*********************************************************************************
                                 以下是验证集合参数方泄1�7
	 *********************************************************************************/
	/**
	 * 验证集合参数
	 * @param collection
	 * @return 如果集合为null或�1�7�没有对象存在，返回眄1�7
	 */
	public static boolean isNullOrNothing(final Collection collection)
	{
		return collection==null||collection.isEmpty();
	}
	
	/**
	 * 验证集合参数
	 * @param dict
	 * @return 如果集合为null或�1�7�没有对象存在，返回眄1�7
	 */
	public static boolean isNullOrNothing(final Dictionary dict)
	{
		return dict==null||dict.isEmpty();
	}
	
	/**
	 * 验证集合参数
	 * @param map
	 * @return 如果集合为null或�1�7�没有对象存在，返回眄1�7
	 */
	public static boolean isNullOrNothing(final Map map)
	{
		return map==null||map.isEmpty();
	}
	
	/**
	 * 验证集合参数
	 * @param array
	 * @return 如果集合为null或�1�7�没有对象存在，返回眄1�7
	 */
	public static boolean isNullOrNothing(final Object[] array)
	{
		return array==null||array.length==0;
	}
	/*********************************************************************************
    							以上是验证集合参数方泄1�7
	 *********************************************************************************/

}
