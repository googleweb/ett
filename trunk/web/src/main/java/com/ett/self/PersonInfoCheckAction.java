package com.ett.self;

public class PersonInfoCheckAction extends BaseSelfAction {
	
	public String infoCheck()
	{
		
		return "input";	
	}
	
	public String execute()
	{
		boolean agent=this.getAgent();
		logger.debug("申请人资料确认完毕后是否进行读取代理人身份信息:"+agent);
		if(agent)
		{
			this.setReturnUrl("/self/idCardReader.action?agent=true&readagent=true&returnurl="+this.getReturnUrl());
			//return "success";
		}
		else if(this.getCapture())
		{
			this.setReturnUrl("/self/captureImg!cap.action?returnurl="+this.getReturnUrl());
		}
		logger.debug("申请人资料确认完毕后跳转的页面:"+this.getReturnUrl());
		return "success";
	}

}
