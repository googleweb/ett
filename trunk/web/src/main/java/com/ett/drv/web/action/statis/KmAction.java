package com.ett.drv.web.action.statis;

import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;

public class KmAction extends BaseDrvAction {

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	
	public String to_km3kscc(){
		return ResultEnum.jsp.name();
	}
}
