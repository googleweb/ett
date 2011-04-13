package com.ett.self;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	public String logout()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	public String execute()
	{
		return "success";
	}

}
