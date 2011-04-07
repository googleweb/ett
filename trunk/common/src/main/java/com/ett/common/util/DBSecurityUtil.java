/**
 * 
 */
package com.ett.common.util;



/**
 * @author chen
 * 数据库操作工具，主要做一些简单的操作，比如字符串过滤，验证等
 */
public class DBSecurityUtil {
	
	public static String transferInsertField(String value)
	{
		StringBuffer buff=new StringBuffer();
		buff.append(value);
		return buff.toString();
	}

}
