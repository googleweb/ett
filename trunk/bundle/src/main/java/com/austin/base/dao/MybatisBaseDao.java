/**
 * 
 */
package com.austin.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author austin
 *
 */
public class MybatisBaseDao implements IBaseDao {

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#count(java.lang.String)
	 */
	public int count(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#count(java.lang.String, java.lang.Object[])
	 */
	public int count(String sql, Object... paramValues) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#get(java.lang.Class, java.io.Serializable)
	 */
	public Object get(Class modelClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#get(java.lang.String, java.io.Serializable)
	 */
	public Object get(String modelClassName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Object findByNamedParam(String sql, String[] paramNames,
			Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#findByExample(java.lang.Object)
	 */
	public Object findByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#findByExample(java.lang.Object, com.austin.base.dao.Page)
	 */
	public Object findByExample(Object obj, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#findByNamedParam(java.lang.String, java.lang.String, java.lang.Object)
	 */
	public Object findByNamedParam(String sql, String paramName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#getAll(java.lang.String)
	 */
	public List getAll(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#getAllByPage(java.lang.String, com.austin.base.dao.Page)
	 */
	public List getAllByPage(String sql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	public boolean saveOrUpdate(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#saveOrUpdateCollection(java.util.Collection)
	 */
	public boolean saveOrUpdateCollection(Collection models) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#delete(java.lang.Object)
	 */
	public boolean delete(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#update(java.lang.Object)
	 */
	public boolean update(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#bulkUpdate(java.lang.String)
	 */
	public boolean bulkUpdate(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#bulkUpdate(java.lang.String, java.lang.Object)
	 */
	public boolean bulkUpdate(String sql, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#bulkUpdate(java.lang.String, java.lang.Object[])
	 */
	public boolean bulkUpdate(String sql, Object[] values) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.austin.base.dao.IBaseDao#deleteAll(java.util.Collection)
	 */
	public boolean deleteAll(Collection models) {
		// TODO Auto-generated method stub
		return false;
	}

}
