package com.ett.self.print.action;

import com.ett.self.print.model.PrintLog;
import com.ett.web.framework.struts2.EntityAction;

public class PrintLogAction extends EntityAction<PrintLog> {

	@Override
	public String getCondition() {
		String result="";
		if(this.keywordFilterValue!=null&&this.keywordFilterValue.length()>0)
		{
			result=" where idCard="+this.keywordFilterValue;
		}
		return result;
	}
	
	

}
