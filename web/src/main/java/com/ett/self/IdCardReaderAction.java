/**
 * 
 */
package com.ett.self;

import java.io.File;
import java.util.Date;

import com.ett.model.DrvUser;

/**
 * @author austin
 *
 */
public class IdCardReaderAction extends BaseSelfAction {
	
	private String name;
	private String sex;
	private int sexCode;
	
	private String national;
	private String address;
	private String sfzmhm;
	private String fzjg;
	private Date beginDate;
	private Date endDate;
	private File frontIdCard;
	private Date csrq;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}


	
	public int getSexCode() {
		return sexCode;
	}

	public void setSexCode(int sexCode) {
		this.sexCode = sexCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public File getFrontIdCard() {
		return frontIdCard;
	}

	public void setFrontIdCard(File frontIdCard) {
		this.frontIdCard = frontIdCard;
	}

	public File getEndIdCard() {
		return endIdCard;
	}

	public void setEndIdCard(File endIdCard) {
		this.endIdCard = endIdCard;
	}

	private File endIdCard;
	
	public String func()
	{
		String returnurl=this.getHtmlAttributeOrParamter("returnurl");
		logger.debug("从参数获取的returnurl值为："+returnurl);
		this.setReturnUrl(returnurl);
		String capture=this.getHtmlAttributeOrParamter("capture");
		logger.debug("从参数获取的capture值为："+capture);
		//capture="true";
		if(capture!=null&&capture.length()>0)
		{
			this.setCapture(Boolean.parseBoolean(capture));
		}
		else
		{
			this.setCapture(false);
		}
		return "func";
	}

	public String execute()
	{
		String agent=this.getHtmlAttributeOrParamter("agent");
		String readagent=this.getHtmlAttributeOrParamter("readagent");
		//this.setAgent(agent);
		String idcard=this.getHtmlAttributeOrParamter("idcard");
		if(idcard==null||"".endsWith(idcard))
		{
			
			String returnurl=this.getHtmlAttributeOrParamter("returnurl");
			this.setReturnUrl(returnurl);
			
			return "input";
		}
		logger.debug("获取是否代理方式："+agent);
		if("true".equals(agent)){
			
			this.setAgent(true);
		}
		else
		{
			this.setAgent(false);
			//String idcard=this.getHtmlAttributeOrParamter("idcard");
			
			
		}
		
		logger.debug("是否读取代理人信息:"+readagent);
		if("true".equals(readagent))
		{
			String returnurl=this.getHtmlAttributeOrParamter("returnurl");
			logger.debug("读取代理人身份证后跳转的页面："+returnurl);
			if(this.getCapture())
			{
				this.setReturnUrl("/self/captureImg!cap.action?returnurl="+this.getReturnUrl());
			}
			else
			{
				this.setReturnUrl(returnurl);
			}
			DrvUser user=new DrvUser();
			user.setCsrq(this.getCsrq());
			user.setSfzmhm(this.getSfzmhm());
			user.setYxqs(this.getBeginDate());
			user.setYxqz(this.getEndDate());
			user.setXm(this.getName());
			user.setXb(this.getSexCode());
			this.setAgentUser(user);
			
			return "success";
		}
		else
		{
			this.setTransBeginDate(new Date());
			logger.debug("读取身份证后跳转的returnurl值为："+this.getReturnUrl());
			this.setUser(this.iDrvQueryHelper.getUserWithLicense(this.getUser()));
			return "infocheck";
		}
		
		
		//return "success";
		
		
		
	}

}
