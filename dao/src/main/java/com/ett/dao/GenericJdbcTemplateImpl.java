package com.ett.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ett.dao.jdbc.AbstractJdbcTemplateDao;

public abstract class GenericJdbcTemplateImpl<T> extends AbstractJdbcTemplateDao implements IBaseDao {
	
	

	public int executeCount(String sql) {
		return this.getJdbcTemplate().queryForInt(sql);
	}

	public int executeCount(String sql, Object... paramValues) {
		return this.getJdbcTemplate().queryForInt(sql,paramValues);
	}

	public T executeObject(String sql) {
		Object obj=null;
		try
		{
		obj=this.getJdbcTemplate().queryForObject(sql,this.defaultRowMapper());
		}
		catch(Exception ex)
		{
			
		}
		return (T)obj ;
	}

	public T executeObject(String sql, Object... paramValues) {
		Object obj=null;
		try
		{
		obj=this.getJdbcTemplate().queryForObject(sql,paramValues,this.defaultRowMapper());
		}
		catch(Exception ex)
		{
			
		}
		return (T)obj ;
	}

	public HibernateTemplate getSelfHibernateTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getHibernateSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAll(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ett.dao.IBaseDao#getAll(java.lang.String)
	 */
	public List getAll(String sql) {
		//System.out.println("开始查询："+sql);
		return this.getJdbcTemplate().query(sql,this.defaultRowMapper());
	}

	public List getAll(String sql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAll(String sql, Page page, Object... paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void removeById(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public void batchUpdate(String sql) {
		// TODO Auto-generated method stub
		
	}


	

}
