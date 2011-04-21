/**
 * 
 */
package com.ett.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author chen
 * 基本的数据库操作对象，每个应用只存在1�个实例
 */
@SuppressWarnings("unchecked")
public interface IBaseDao extends IDao {
	
	
	HibernateTemplate getSelfHibernateTemplate();
	
	/**
	 * @param entityClass 实例类名
	 * @param id 主键对象
	 * @return 获取的泛型对象
	 */
	Object get(Class entityClass,Serializable id);
	

	/**
	 * @param 专门支持hibernate的方法
	 * @return
	 */
	SessionFactory getHibernateSessionFactory();

	/**
	 * @param entityClass 实例类名
	 * @return 获取实例有的对象结果列表
	 */
	List getAll(Class entityClass);
	
	/**
	 * @param sql 查询语句
	 * @return 查询的对象结果列表
	 */
	List getAll(String sql);
	
	/**
	 * @param sql 查询语句
	 * @param page 分页对象
	 * @return 查询的对象结果列表
	 */
	List getAll(String sql,Page page);
	
	/**
	 * @param sql 查询语句
	 * @param paramValues 参数值集合
	 * @param page 分页对象
	 * @return 查询的对象结果列表
	 */
	List getAll(String sql,Page page,Object... paramValues);

	/**
	 * @param entityClass 
	 * @param entity 保存一个实例对象
	 */
	
	void save(Object entity);

	/**
	 * @param entityClass 实体类
	 */
	void remove(Object entity);

	/**
	 * @param entityClass 实体类
	 * @param id 根据主键移除一个实例对象
	 */
	void removeById(Class entityClass,Serializable id);
	
	void batchUpdate(final String sql);
	
}
