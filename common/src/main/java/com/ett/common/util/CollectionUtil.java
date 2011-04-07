/**
 * @(#)CollectionUtil.java 
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

/**
 * <p>Description:</p>
 * <p>闆嗗悎宸ュ叿绫伙紝瀵归泦鍚堢殑涓�浜涙搷绾�/p>
 * @author x_chenbiwu
 *
 */
public class CollectionUtil {
	
	
	private CollectionUtil()
	{
		
	}
	/*********************************************************************************
                                 浠ヤ笅鏄獙璇侀泦鍚堝弬鏁版柟娉�
	 *********************************************************************************/
	/**
	 * 楠岃瘉闆嗗悎鍙傛暟
	 * @param collection
	 * @return 濡傛灉闆嗗悎涓簄ull鎴栬�呮病鏈夊璞″瓨鍦紝杩斿洖鐪�
	 */
	public static boolean isNullOrNothing(final Collection collection)
	{
		return collection==null||collection.isEmpty();
	}
	
	/**
	 * 楠岃瘉闆嗗悎鍙傛暟
	 * @param dict
	 * @return 濡傛灉闆嗗悎涓簄ull鎴栬�呮病鏈夊璞″瓨鍦紝杩斿洖鐪�
	 */
	public static boolean isNullOrNothing(final Dictionary dict)
	{
		return dict==null||dict.isEmpty();
	}
	
	/**
	 * 楠岃瘉闆嗗悎鍙傛暟
	 * @param map
	 * @return 濡傛灉闆嗗悎涓簄ull鎴栬�呮病鏈夊璞″瓨鍦紝杩斿洖鐪�
	 */
	public static boolean isNullOrNothing(final Map map)
	{
		return map==null||map.isEmpty();
	}
	
	/**
	 * 楠岃瘉闆嗗悎鍙傛暟
	 * @param array
	 * @return 濡傛灉闆嗗悎涓簄ull鎴栬�呮病鏈夊璞″瓨鍦紝杩斿洖鐪�
	 */
	public static boolean isNullOrNothing(final Object[] array)
	{
		return array==null||array.length==0;
	}
	/*********************************************************************************
    							浠ヤ笂鏄獙璇侀泦鍚堝弬鏁版柟娉�
	 *********************************************************************************/

}
