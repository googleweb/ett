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
	private IBaseDao baseDaoWithTrans;
	
	public IBaseDao getBaseDaoWithTrans() {
		return baseDaoWithTrans;
	}

	public void setBaseDaoWithTrans(IBaseDao baseDaoWithTrans) {
		this.baseDaoWithTrans = baseDaoWithTrans;
	}

	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
