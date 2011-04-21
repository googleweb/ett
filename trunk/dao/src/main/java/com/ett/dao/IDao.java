/**
 * 
 */
package com.ett.dao;

import java.util.List;

/**
 * @author chen
 * 数据库接口，供IGenericDao和IEntityDao使用
 */
public interface IDao {
	

	/**
	 * @param sql 执行统计语句
	 * @return 统计的结果数目，或者返回一个可转化成int的对象
	 */
	int executeCount(String sql);
	
	/**
	 * @param sql 执行统计语句
	 * @param paramValues 参数值集合
	 * @return 统计的结果数目，或者返回一个可转化成int的对象
	 */
	int executeCount(String sql,Object... paramValues);
	
	
	/**
	 * @param sql 执行的返回单值的语句
	 * @return 返回的单值或者null
	 */
	Object executeObject(String sql);
	
	/**
	 * @param sql 执行的返回单值的语句
	 * @param paramValues 参数值集各1�7
	 * @return 返回的单值或者null
	 */
	Object executeObject(String sql,Object... paramValues);
	
	void save(Object entity);
	
	






}
