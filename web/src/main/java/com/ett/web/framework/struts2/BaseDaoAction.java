/**
 * 
 */
package com.ett.web.framework.struts2;

import com.ett.dao.IBaseDao;

/**
 * @author austin
 *
 */
@SuppressWarnings("serial")
public class BaseDaoAction extends AbstractStruts2BaseAction {
	private IBaseDao baseDao;
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
