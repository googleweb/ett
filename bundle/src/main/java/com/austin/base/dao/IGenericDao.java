package com.austin.base.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T> extends IBaseDao {
	
	public T get(Class modelClass,Serializable id);
	public T get(String modelClassName,Serializable id);
	public T findByNamedParam(String sql,String[] paramNames,Object[] values);
	public T findByExample(Object obj);
	public T findByExample(Object obj,Page page);
	public T findByNamedParam(String sql,String paramName,Object value);
	
	public List<T> getAll(String sql);
	public List<T> getAllByPage(final String sql,final Page page);

}
