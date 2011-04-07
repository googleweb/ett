/**
 * @(#)PublicUtil.java 
 * 
 * create by x_chenbiwu at 2008-3-7
 * 
 * Copyright 2008 fivemen,Inc. All rights reserved.
 * 
 * fivemen proprietary/confidential.Use is subject to license terms
 */
package com.ett.common.util;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * <p>Description:</p>
 * <p>鍏敤鐨勫伐鍏�/p>
 * @author x_chenbiwu
 *
 */
public class PublicUtil {
	protected static final Log log = LogFactory.getLog(PublicUtil.class);
	
     private PublicUtil()
     {
    	 
     }
     /**
      * 楠岃瘉瀵硅薄鏄惁涓虹┖鎴栬�呭瓧绗︿覆涓虹┖锛屾垨鑰呴泦鍚堟病鏈夊寘鍚璞�,濡傛灉璇ュ弬鏁板彲鐢紝杩斿洖true
      * @param obj 楠岃瘉瀵硅薄
      * @return true楠岃瘉澶辫触
      */
	public static boolean validArgument(final Object obj)
	{
		boolean result=true;
		//鍙傛暟涓簄ull鐨勬椂鍊� instanceof 鎵ц缁撴灉涓簄ull
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
