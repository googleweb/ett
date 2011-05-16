package com.austin.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.austin.base.commons.util.GenericUtil;


public class GenericHibernateBaseDao<T> extends HibernateDaoSupport implements IGenericDao<T> {
	
	protected Class<T> entityClass;// DAO扄1�7管理的Entity类型.
	
	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public GenericHibernateBaseDao() {
		entityClass = GenericUtil.getSuperClassGenricType(getClass());
	}


	public int count(String sql) {
		int result = ((Long)getHibernateTemplate().find(sql).listIterator().next()).intValue();
		return result;
	}

	public int count(String sql, Object... paramValues) {
		int result = ((Long)getHibernateTemplate().find(sql,paramValues).listIterator().next()).intValue();
		return result;
	}

	public T get(Class modelClass, Serializable id) {
		return (T)this.getHibernateTemplate().get(modelClass.getName(), id);
	}

	public T get(String modelClassName, Serializable id) {
		return (T)this.getHibernateTemplate().get(modelClassName, id);
	}

	public T findByNamedParam(String sql, String[] paramNames,
			Object[] values) {
		List list=this.getHibernateTemplate().findByNamedParam(sql, paramNames, values);
		if(list.size()>0)
		{
			return (T)list.get(0);
			
		}
		return null;
	}

	public T findByExample(Object obj) {
		List list=this.getHibernateTemplate().findByExample(obj);
		if(list.size()>0)
		{
			return (T)list.get(0);
			
		}
		return null;
	}

	public T findByExample(Object obj, Page page) {
		List list=this.getHibernateTemplate().findByExample(obj,page.getStartIndex(),page.getPageSize());
		if(list.size()>0)
		{
			return (T)list.get(0);
			
		}
		return null;
	}

	public T findByNamedParam(String sql, String paramName, Object value) {
		List list=this.getHibernateTemplate().findByNamedParam(sql,paramName,value);
		if(list.size()>0)
		{
			return (T)list.get(0);
			
		}
		return null;
	}

	public List<T> getAll(String sql) {
		List list=this.getHibernateTemplate().find(sql);
		if(list.size()>0)
		{
			return list;
			
		}
		return null;
	}

	public List<T> getAllByPage(String sql, Page page) {
		Session session = getHibernateTemplate().getSessionFactory()
		.getCurrentSession();
		//.openSession();
		Query query = session.createQuery(sql);
		query.setMaxResults(page.getPageSize());
		query.setFirstResult(page.getStartIndex());
		return query.list();
	}

	public boolean saveOrUpdate(Object model) {
		this.getHibernateTemplate().saveOrUpdate(model);
		return true;
	}

	public boolean saveOrUpdateCollection(Collection models) {
		this.getHibernateTemplate().saveOrUpdateAll(models);
		return true;
	}

	public boolean delete(Object model) {
		this.getHibernateTemplate().delete(model);
		return true;
	}

	public boolean update(Object model) {
		this.getHibernateTemplate().update(model);
		return true;
	}

	public boolean bulkUpdate(String sql) {
		int ret=this.getHibernateTemplate().bulkUpdate(sql);
		return ret>0;
	}

	public boolean bulkUpdate(String sql, Object value) {
		int ret=this.getHibernateTemplate().bulkUpdate(sql,value);
		return ret>0;
	}

	public boolean bulkUpdate(String sql, Object[] values) {
		int ret=this.getHibernateTemplate().bulkUpdate(sql,values);
		return ret>0;
	}

	public boolean deleteAll(Collection models) {
		this.getHibernateTemplate().deleteAll(models);
		return true;
	}


}
