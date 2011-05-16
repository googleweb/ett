package com.austin.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GenericMybatisBaseDao<T> extends SqlMapClientDaoSupport implements IGenericDao<T> {

	public int count(String sql) {
		// TODO Auto-generated method stub
	 // this.getSqlMapClientTemplate().
		return 0;
	}

	public int count(String sql, Object... paramValues) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean saveOrUpdate(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveOrUpdateCollection(Collection models) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean bulkUpdate(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean bulkUpdate(String sql, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean bulkUpdate(String sql, Object[] values) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAll(Collection models) {
		// TODO Auto-generated method stub
		return false;
	}

	public T get(Class modelClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T get(String modelClassName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findByNamedParam(String sql, String[] paramNames, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findByExample(Object obj, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findByNamedParam(String sql, String paramName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAllByPage(String sql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
