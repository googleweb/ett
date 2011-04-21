/**
 * 
 */
package com.ett.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author chen
 * 基本的Hibernate操作实例用
 */

@SuppressWarnings("unchecked")
public class BaseDaoHibernateImpl extends HibernateDaoSupport implements IBaseDao  {
	
	
	protected Logger log = Logger.getLogger(BaseDaoHibernateImpl.class);

	public HibernateTemplate getSelfHibernateTemplate() {
		return this.getHibernateTemplate();
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#get(java.lang.Class, java.io.Serializable)
	 */
	public Object get(Class entityClass, Serializable id) {
		if(log.isDebugEnabled())
		{
			log.debug("BaseDaoHibernateImpl....this.getHibernateTemplate()=="+this.getHibernateTemplate());
			boolean conn=true;
			try {
				conn = this.getHibernateSessionFactory().getCurrentSession().connection().isClosed();
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
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#getAll(java.lang.Class)
	 */
	public List getAll(Class entityClass) {
		return this.getHibernateTemplate().loadAll(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#getAll(java.lang.String, com.ft.common.dao.Page)
	 */
	public List getAll(String sql, Page page) {
		Session session = getHibernateTemplate().getSessionFactory()
		.getCurrentSession();
		//.openSession();
		Query query = session.createQuery(sql);
		query.setMaxResults(page.getPageSize());
		query.setFirstResult(page.getStartIndex());
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#getAll(java.lang.String, com.ft.common.dao.Page, java.lang.Object[])
	 */
	public List getAll(String sql, Page page, Object... paramValues) {
		Session session = getHibernateTemplate().getSessionFactory()
		.getCurrentSession();
		//.openSession();
		Query query = session.createQuery(sql);
		if(paramValues!=null)
		{
			for(int i=0;i<paramValues.length;i++)
			{
				query.setParameter(i, paramValues[i]);
			}
		}
		query.setMaxResults(page.getPageSize());
		query.setFirstResult(page.getStartIndex());
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#remove(java.lang.Object)
	 */
	public void remove(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#removeById(java.lang.Class, java.io.Serializable)
	 */
	public void removeById(Class entityClass, Serializable id) {
		this.getHibernateTemplate().delete(this.get(entityClass,id));
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IBaseDao#save(java.lang.Object)
	 */
	public void save(Object entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeCount(java.lang.String)
	 */
	public int executeCount(String sql) {
		int result = ((Long)getHibernateTemplate().find("select count(*) "+sql).listIterator().next()).intValue();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeCount(java.lang.String, java.lang.Object[])
	 */
	public int executeCount(String sql, Object... paramValues) {
		int result = ((Long)getHibernateTemplate().find("select count(*) "+sql,paramValues).listIterator().next()).intValue();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ft.common.dao.IDao#executeObject(java.lang.String)
	 */
	public Object executeObject(String sql) {
		List countlist = getHibernateTemplate().find(sql);
		Object result = countlist.get(0);
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

	public List getAll(String sql) {
		/*
		Session session = getHibernateTemplate().getSessionFactory()
		.openSession();
		//.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
		*/
		return this.getHibernateTemplate().find(sql);
	}

	public SessionFactory getHibernateSessionFactory(){
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().getSessionFactory();
	}

	public void batchUpdate(final String sql) {

		if(log.isDebugEnabled())
		{
			log.debug("批量更新的sql语句为："+sql);
		}
		try
		{

		this.getHibernateTemplate().execute(new HibernateCallback(){     
            public Object doInHibernate(Session session) throws HibernateException, SQLException {   
                Query query=session.createSQLQuery(sql);   
               // query.setParameterList("yaoyueid", updateIds);   
                query.executeUpdate();   
                return null;   
            }  
		}); 
		}
		catch(Exception ex)
		{
			log.info(ex);
		}

		
	}

	

}
