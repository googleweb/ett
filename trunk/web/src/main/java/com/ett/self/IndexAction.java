package com.ett.self;

import org.apache.log4j.Logger;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends BaseSelfAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(IndexAction.class);
	
	private String money;
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	private int money2;
	public int getMoney2() {
		return money2;
	}
	public void setMoney2(int money2) {
		this.money2 = money2;
	}
	public String logout()
	{
		logger.debug("现金金额为："+this.money);
		logger.debug("现金金额2为："+this.money2);
		//this.createNewId();
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	public String execute()
	{
		return "success";
	}

}
