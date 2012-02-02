package com.ett.visual.action;

import com.ett.visual.biz.IAdminBiz;
import com.smartken.toyz4j.model.impl.BaseAction;

public abstract class BaseVisualAction extends BaseAction {
      
	
	private IAdminBiz adminBiz;

	public void setAdminBiz(IAdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	
	
}
