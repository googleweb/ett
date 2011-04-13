/**
 * 
 */
package com.ett.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 * 基本的泛型操作接叄1�7
 */
public interface IGenericDao<T> extends IDao {

	/**
	 * @param id 主键对象
	 * @return 获取的泛型对豄1�7
	 */
	T get(Serializable id);

	/**
	 * @return 获取扄1�7有的对象结果列表
	 */
	List<T> getAll();
	
	/**
	 * @param sql 查询语句
	 * @param page 分页对象
	 * @return 查询的对象结果列衄1�7
	 */
	List<T> getAll(String sql,Page page);
	
	
	/**
	 * @param sql 查询语句
	 * @param page 分页对象
	 * @return 查询的对象结果列衄1�7
	 */
	List<T> getAll(String sql);
	
	/**
	 * @param sql 查询语句
	 * @param paramValues 参数值集各1�7
	 * @param page 分页对象
	 * @return 查询的对象结果列衄1�7
	 */
	List<T> getAll(String sql,Page page,Object... paramValues);

	/**
	 * @param entity 保存丄1�7个实例对豄1�7
	 */
	void save(T entity);

	/**
	 * @param entity 移除丄1�7个实例对豄1�7
	 */
	void remove(T entity);

	/**
	 * @param id 根据主键移除丄1�7个实例对豄1�7
	 */
	void removeById(Serializable id);
	
}
