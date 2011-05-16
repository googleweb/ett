package com.austin.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author austin
 * 基本的查询接口类
 */
public interface IBaseDao {
	
	/**
	 * @param sql 统计语句
	 * @return 统计语句返回的统计结果个数
	 */
	public int count(String sql);
	/**
	 * @param sql 执行统计语句
	 * @param paramValues 参数值集合
	 * @return 统计的结果数目，或者返回一个可转化成int的对象
	 */
	public int count(String sql,Object... paramValues);
	
	public Object get(Class modelClass,Serializable id);
	public Object get(String modelClassName,Serializable id);
	public Object findByNamedParam(String sql,String[] paramNames,Object[] values);
	public Object findByExample(Object obj);
	public Object findByExample(Object obj,Page page);
	public Object findByNamedParam(String sql,String paramName,Object value);
	
	public List getAll(String sql);
	public List getAllByPage(final String sql,final Page page);
	public boolean saveOrUpdate(Object model);
	public boolean saveOrUpdateCollection(Collection models);
	public boolean delete(Object model);
	public boolean update(Object model);
	
	
	public boolean bulkUpdate(String sql);
	public boolean bulkUpdate(String sql, Object value);
	public boolean bulkUpdate(String sql, Object[] values);
	
	public boolean deleteAll(Collection models);
	
	

}
