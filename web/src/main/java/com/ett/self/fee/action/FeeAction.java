/**
 * 
 */
package com.ett.self.fee.action;

import java.util.List;

import com.ett.model.DrvUser;
import com.ett.self.BaseSelfAction;
import com.ett.self.fee.biz.IFeeBiz;
import com.ett.self.fee.model.FeeObject;

/**
 * @author austin
 * 缴费处理ACTION
 */
public class FeeAction extends BaseSelfAction {
	
	public IFeeBiz iFeeBiz;

	public IFeeBiz getiFeeBiz() {
		return iFeeBiz;
	}

	public void setiFeeBiz(IFeeBiz iFeeBiz) {
		this.iFeeBiz = iFeeBiz;
	} 
	private String lsh;

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	private String visaCard;
	
	private String visaPwd;
	
	public String getVisaCard() {
		return visaCard;
	}

	public void setVisaCard(String visaCard) {
		this.visaCard = visaCard;
	}

	public String getVisaPwd() {
		return visaPwd;
	}

	public void setVisaPwd(String visaPwd) {
		this.visaPwd = visaPwd;
	}
	


	public String feePerson()
	{
		iFeeBiz.saveFeePerson(this.getUser(),this.getDevice(),this.getFeeObject());
		return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
	}
	
	public String feeVehicle()
	{
		iFeeBiz.saveFeeVehicle(this.getUser(),this.getDevice(),this.getFeeObject());
		return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
	}
	
	public String feeVio()
	{
		iFeeBiz.saveFeeVio(this.getUser(),this.getDevice(),this.getFeeObject());
		return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
		//return "success";
	}
	
	public String feeTypeSelect()
	{
		//String moneytmp=this.getHtmlAttributeOrParamter("money");
		//logger.debug("从请求页获取的缴纳金额费用为 ："+moneytmp);
		this.getFeeObject().setMoney(this.getMoney());
		logger.debug("从请求页获取的缴纳金额费用为 ："+this.getMoney());
		this.getFeeObject().setFeeLsh(this.lsh);
		logger.debug("从请求页获取的缴纳金额对应流水号为 ："+this.lsh);
		return "feetypeselect";
	}
	
	public String visaFee()
	{
		FeeObject fee=this.getFeeObject();
		logger.debug("开始银联缴费"+fee.getBusType()+"，需要缴纳的费用为："+fee.getMoney());

		//TODO 银联缴费！
		if(fee.getBusType()==FeeObject.PersonBusFee)
		{
			iFeeBiz.saveFeePerson(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		else if(fee.getBusType()==FeeObject.VehicleBusFee)
		{
			iFeeBiz.saveFeeVehicle(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		else if(fee.getBusType()==FeeObject.VioBusFee)
		{
			iFeeBiz.saveFeeVio(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		
		return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
	}
	public String cashFee()
	{
		FeeObject fee=this.getFeeObject();
		logger.debug("开始现金缴费"+fee.getBusType()+"，需要缴纳的费用为："+fee.getMoney());
		logger.debug("注入的iFeeBiz对象为："+iFeeBiz);
		if(fee.getBusType()==FeeObject.PersonBusFee)
		{
			iFeeBiz.saveFeePerson(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		else if(fee.getBusType()==FeeObject.VehicleBusFee)
		{
			iFeeBiz.saveFeeVehicle(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		else if(fee.getBusType()==FeeObject.VioBusFee)
		{
			iFeeBiz.saveFeeVio(this.getUser(),this.getDevice(),fee);
			this.setFeeObject(null);
			
		}
		
		return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
	
	}
	public String visa()
	{
		
		this.getFeeObject().setFeeType(FeeObject.VisaFee);
		return "visa";
	}
	public String cash()
	{
		this.getFeeObject().setFeeType(FeeObject.CashFee);
		return "cash";
	}
	private List lists;
	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}

	public String personList()
	{
		this.getFeeObject().setBusType(FeeObject.PersonBusFee);
	    this.lists=this.iFeeBiz.getPersonFlowList(this.getUser());
		return "personlist";
	}
	
	public String vehicleList()
	{
		this.getFeeObject().setBusType(FeeObject.VehicleBusFee);
		this.lists=this.iFeeBiz.getVehicleFlowList(this.getUser());
		return "vehiclelist";
	}
	
	public String vioList()
	{
		this.getFeeObject().setBusType(FeeObject.VioBusFee);
		this.lists=this.iFeeBiz.getVioFlowList(this.getUser());
		return "violist";
	}
	
	public String func()
	{
		DrvUser user=this.getUser();
		this.getiDrvQueryHelper().getUserWithLicense(user);
		this.setUser(user);
		logger.debug("选择功能时已经取到的人员流水号为 "+this.getUser().getLsh());
		return "funcselect";
	}




}
