/**
 * @(#)PublicUtil.java 
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * <p>Description:</p>
 * <p>公用的工兄1�7/p>
 * @author x_chenbiwu
 *
 */
public class PublicUtil {
	protected static final Log log = LogFactory.getLog(PublicUtil.class);
	
     private PublicUtil()
     {
    	 
     }
     /**
      * 验证对象是否为空或�1�7�字符串为空，或者集合没有包含对豄1�7,如果该参数可用，返回true
      * @param obj 验证对象
      * @return true验证失败
      */
	public static boolean validArgument(final Object obj)
	{
		boolean result=true;
		//参数为null的时倄1�7 instanceof 执行结果为null
		if(obj==null)
		{
			result=false;
		}
		else if(obj instanceof String)
		{
			result=!StringUtil.isNullOrEmpty((String)obj);
			
		}
		else if(obj instanceof Collection)
		{
			result=!CollectionUtil.isNullOrNothing((Collection)obj);
			
			
		}
		else if(obj instanceof Dictionary)
		{
			result=!CollectionUtil.isNullOrNothing((Dictionary)obj);
		}
		else if(obj instanceof Map)
		{
			result=!CollectionUtil.isNullOrNothing((Map)obj);
		}
		else if(obj instanceof Object[])
		{
			result=!CollectionUtil.isNullOrNothing((Object[])obj);
		}
		else
		{
			result=(obj!=null);
		}
		if(!result)
		{
			//LogFactoryWrapper.warn(obj);
		}
		return result;
	}

}
