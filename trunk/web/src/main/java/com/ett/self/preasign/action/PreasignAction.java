package com.ett.self.preasign.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.model.ComboxObject;
import com.ett.self.BaseSelfAction;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.preasign.biz.IPreasignBiz;
import com.ett.self.preasign.model.Km1CheckRecord;

public class PreasignAction extends BaseSelfAction {
	
	private IPreasignBiz iPreasignBiz;

	public IPreasignBiz getiPreasignBiz() {
		return iPreasignBiz;
	}

	public void setiPreasignBiz(IPreasignBiz iPreasignBiz) {
		this.iPreasignBiz = iPreasignBiz;
	}
	/**
	 * @return 签到功能完成
	 * @throws ParseException 
	 */
	public String check() throws ParseException
	{
		SelfDeviceObject device=this.getDevice();
		
		
		String ksdd=device.getKsddCode();
		if(this.iPreasignBiz.getChecked(this.getUser().getSfzmhm(), ksdd, new Date()))
		{
			return this.goSuccessPage("对不起，您已经签到过本考场的今天考试！");
		}
		this.printObject=iPreasignBiz.getPrintObject(this.getUser().getSfzmhm(),ksdd,new Date());
		if(printObject!=null)
		{
			this.printObject.setGlbmName(device.getGlbmName());
			this.initHotPrinter();
			
			return "checkprint";
		}
		else
		{
			throw new ObjectDontExistException("对不起，您没有预约过本考场今天的考试！");
			//return this.noPreasign();
		}
		
	}
	public String func()
	{
		
		return "funcselect";
	}
	
	public String confirmCheck() throws ParseException
	{
		//this.printObject=iPreasignBiz.getPrintObject(this.getUser().getSfzmhm(),this.getDevice().getKsddCode(),new Date());
		this.iPreasignBiz.createKm1CheckRecord(this.getUser(), this.getDevice());
		
		
		return this.goSuccessPage("签到完成，请取走您的凭条和相关证件！");
	}
	
	public String preasignPrint()
	{
		return "preasignprint";
	}
	
	private boolean isPreasignAll;
	
	public boolean isPreasignAll() {
		return isPreasignAll;
	}

	public void setPreasignAll(boolean isPreasignAll) {
		this.isPreasignAll = isPreasignAll;
	}
	

	public String preasign() throws ParseException
	{
		this.iPreasignBiz.createPreasignKm1(this.getUser(), this.getDevice(), this.getYkrq(), this.getKsddCode());
		return this.goSuccessPage("预约成功，请取走您的凭条和相关证件！");
	}
	
	private List ksddList;
	
	public List getKsddList() {
		return ksddList;
	}
	
	private List ksccList;

	public List getKsccList() {
		return ksccList;
	}

	public void setKsccList(List ksccList) {
		this.ksccList = ksccList;
	}

	public void setKsddList(List ksddList) {
		this.ksddList = ksddList;
	}

	public String preparePreasign()
	
	{
		SelfDeviceObject device=this.getDevice();
		
		this.getUser();
		
		
		
		this.isPreasignAll=device.isPreasignAll();
		logger.debug("该设备是否允许约考全部地点-》"+this.isPreasignAll);
		this.ksccList=this.iDrvQueryHelper.getDict("02", "45",device.getGlbm());
		if(this.isPreasignAll)
		{
		this.ksddList=this.iDrvQueryHelper.getDict("02", "401",device.getGlbm());
		}
		else
		{
			logger.debug("该设备不允许约考全部地点！");
			this.ksddList=new ArrayList();
			ComboxObject obj=new ComboxObject();
			obj.setText(device.getKsddName());
			obj.setValue(device.getKsddCode());
			this.ksddList.add(obj);
		}
		
		
		//this.iPreasignBiz.getUserExamCard(idcard)
		return "preparepreasign";
	}
	
	public String noPreasign()
	{
		return "nopreasign";
	}
	
	public Date getYkrq() {
		return ykrq;
	}

	public void setYkrq(Date ykrq) {
		this.ykrq = ykrq;
	}

	public String getKsddCode() {
		return ksddCode;
	}

	public void setKsddCode(String ksddCode) {
		this.ksddCode = ksddCode;
	}

	public String getKsccCode() {
		return ksccCode;
	}

	public void setKsccCode(String ksccCode) {
		this.ksccCode = ksccCode;
	}

	private Date ykrq;
	
	private String ksddCode;
	
	private String ksccCode;
	

}
