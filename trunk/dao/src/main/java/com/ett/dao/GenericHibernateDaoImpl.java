/**
 * 
 */
package com.ett.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ett.common.util.GenericUtil;


/**
 * @author chen
 * @param <T> 泛型
 * 泛型的1�7
 */
public abstract class GenericHibernateDaoImpl<T> extends HibernateDaoSupport implements IGenericDao<T> {
	protected static Logger log = Logger.getLogger(GenericHibernateDaoImpl.class);
	
	protected Class<T> entityClass;// DAO扄1�7管理的Entity类型.
	
	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public GenericHibernateDaoImpl() {
		entityClass = GenericUtil.getSuperClassGenricType(getClass());
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#get(java.io.Serializable)
	 */
	public T get(Serializable id) {
		if(log.isDebugEnabled())
		{
			log.debug("GenericHibernateDaoImpl....this.getHibernateTemplate()=="+this.getHibernateTemplate());
			boolean conn=true;
			try {
				conn = this.getHibernateTemplate().getSessionFactory().getCurrentSession().connection().isClosed();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				log.debug("当前连接的状态HibernateException："+e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.debug("当前连接的状态SQLException："+e);
			}
			if(!conn)
			{
				//this.getHibernateSessionFactory().openSession();
			}
			log.debug("当前连接的状态："+String.valueOf(conn));
		}
		return (T)this.getHibernateTemplate().load(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#getAll()
	 */
	public List<T> getAll() {
		return this.getHibernateTemplate().loadAll(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#getAll(java.lang.String, com.ft.common.dao.Page)
	 */
	public List<T> getAll(String sql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll(String sql) {
		
		return this.getHibernateTemplate().find(sql);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#getAll(java.lang.String, com.ft.common.dao.Page, java.lang.Object[])
	 */
	public List<T> getAll(String sql, Page page, Object... paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#removeById(java.io.Serializable)
	 */
	public void removeById(Serializable id) {
		this.getHibernateTemplate().delete(this.get(id));
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IGenericDao#save(java.lang.Object)
	 */
	public void save(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeCount(java.lang.String)
	 */
	public int executeCount(String sql) {
		List countlist = getHibernateTemplate().find(sql);
		int result =  (Integer)countlist.get(0);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeCount(java.lang.String, java.lang.Object[])
	 */
	public int executeCount(String sql, Object... paramValues) {
		List countlist = getHibernateTemplate().find(sql,paramValues);
		int result =  (Integer)countlist.get(0);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeObject(java.lang.String)
	 */
	public Object executeObject(String sql) {
		List countlist = getHibernateTemplate().find(sql);
		Object result =  countlist.get(0);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeObject(java.lang.String, java.lang.Object[])
	 */
	public Object executeObject(String sql, Object... paramValues) {
		List countlist = getHibernateTemplate().find(sql,paramValues);
		Object result =  countlist.get(0);
		return result;
	}

	
}
