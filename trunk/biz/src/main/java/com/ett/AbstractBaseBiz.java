/**
 * 
 */
package com.ett;

import org.apache.log4j.Logger;

import com.ett.dao.IBaseDao;
import com.ett.dao.jdbc.AbstractJdbcTemplateDao;

/**
 * @author austin
 * 基本的操作本数据库的对象
 */
public abstract class AbstractBaseBiz{
	/**
	 * Logger for this class
	 */
	protected static final Logger logger = Logger
			.getLogger(AbstractBaseBiz.class);

	private IBaseDao baseDao;
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
