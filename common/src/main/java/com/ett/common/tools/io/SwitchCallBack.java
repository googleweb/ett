/**
 * SwitchCallBack.java create by chen at 2008-11-23 ,下午12:05:50
 * NotMavenTest by ft.comp
 */
package com.ett.common.tools.io;

/**
 * 判断丄1�7个对象是否符合条仄1�7
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public interface SwitchCallBack {

	/**
	 * 判断丄1�7个对象是否符合要汄1�7
	 * @param obj 待判断对豄1�7
	 * @return 是否符合要求，符合返回true
	 */
	boolean verify(Object obj);
}
