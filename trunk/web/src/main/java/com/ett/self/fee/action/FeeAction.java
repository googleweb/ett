/**
 * 
 */
package com.ett.self.fee.action;

import java.util.Date;
import java.util.List;

import com.ett.model.DrvUser;
import com.ett.self.BaseSelfAction;
import com.ett.self.fee.biz.IFeeBiz;
import com.ett.self.fee.model.FeeBusType;
import com.ett.self.fee.model.FeeObject;
import com.ett.self.fee.model.FeeWayType;

/**
 * @author austin
 * 缴费处理ACTION
 */
public class FeeAction extends BaseSelfAction {
	
	//private String postFee;
	
	private boolean allowGuiTai;
	
	public boolean isAllowGuiTai() {
		return allowGuiTai;
	}

	public void setAllowGuiTai(boolean allowGuiTai) {
		this.allowGuiTai = allowGuiTai;
	}
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
	
	public String feePrint()
	{
		return "feeprinthint";
	}
	
	public String fee()
	{
		//FeeObject fee=this.getFeeObject();
		//if()
		FeeObject fee=this.getFeeObject();
		fee.setCreateTime(new Date());
		logger.debug("开始通过"+fee.getFeeWayType()+"缴费,"+fee.getBusType()+"，需要缴纳的费用为："+fee.getMoney());
		iFeeBiz.saveFee(this.getUser(),this.getDevice(),fee);
		return "returnurl";
		//return this.goSuccessPage("缴费成功！请取缴费回执并取走您的相关证件！");
	}

	public String feeTypeSelect()
	{
		String returnurl=this.getHtmlAttributeOrParamter("returnurl");
		logger.debug("缴费成功后要跳转的页面为："+returnurl);
		String allowguitai=this.getHtmlAttributeOrParamter("allowguitai");
		if(allowguitai!=null&&allowguitai.length()>0)
		{
			this.setAllowGuiTai(Boolean.parseBoolean(allowguitai));
		}
		
		this.setReturnUrl(returnurl);
		//String moneytmp=this.getHtmlAttributeOrParamter("money");
		//logger.debug("从请求页获取的缴纳金额费用为 ："+moneytmp);
		this.getFeeObject().setMoney(this.getMoney());
		logger.debug("从请求页获取的缴纳金额费用为 ："+this.getMoney());
		this.getFeeObject().setFeeLsh(this.getLsh());
		logger.debug("从请求页获取的缴纳金额对应流水号为 ："+this.getLsh());
		return "feetypeselect";
	}
	
	public String visaFeeHint()
	{
		this.getFeeObject().setFeeWayType(FeeWayType.VisaFee);
		return "visafeehint";
	}
	public String cashFeeHint()
	{
		this.getFeeObject().setFeeWayType(FeeWayType.CashFee);
		return "cashfeehint";
	}
	
	public String guitaiFeeHint()
	{
		this.getFeeObject().setFeeWayType(FeeWayType.GuiTaiFee);
		return "returnurl";
	}
	/**
	 * @return 银联卡缴费
	 */
	public String visa()
	{
		
		this.getFeeObject().setFeeWayType(FeeWayType.VisaFee);
		return "visa";
	}
	/**
	 * @return 柜台缴费
	 */
	public String guitai()
	{
		this.getFeeObject().setFeeWayType(FeeWayType.GuiTaiFee);
		return "returnurl";
	}
	/**
	 * @return 现金缴费
	 */
	public String cash()
	{
		this.getFeeObject().setFeeWayType(FeeWayType.CashFee);
		return "cash";
	}
	/**
	 *  待缴费的对象列表
	 */
	private List lists;
	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}

	/**
	 * @return 驾驶人缴费
	 */
	public String personList()
	{
		this.getFeeObject().setBusType(FeeBusType.PersonBusFee);
	    this.lists=this.iFeeBiz.getPersonFlowList(this.getUser());
	    if(this.lists==null||this.lists.size()==0)
	    {
	    	return this.goSuccessPage("您当前没有需要缴费的驾驶人业务!");
	    }
		return "personlist";
	}
	
	/**
	 * @return 驾驶人缴费
	 */
	public String personFee()
	{
		this.setHintMsg("缴费成功！请取缴费回执并取走您的相关证件！");
		
		return this.feePrint();
	}
	
	
	/**
	 * @return 机动车缴费
	 */
	public String vehicleFee()
	{
		this.setHintMsg("缴费成功！请取缴费回执并取走您的相关证件！");
		
		return this.feePrint();
	}
	
	
	/**
	 * @return 机动车缴费
	 */
	public String vehicleList()
	{
		this.getFeeObject().setBusType(FeeBusType.VehicleBusFee);
		this.lists=this.iFeeBiz.getVehicleFlowList(this.getUser());
		 if(this.lists==null||this.lists.size()==0)
		    {
		    	return this.goSuccessPage("您当前没有需要缴费的机动车业务!");
		    }
		return "vehiclelist";
	}
	
	/**
	 * @return 查询违法记录列表
	 */
	public String vioList()
	{
		this.getFeeObject().setBusType(FeeBusType.VioBusFee);
		this.lists=this.iFeeBiz.getVioFlowList(this.getUser());
		return "violist";
	}
	
	/**
	 * @return 选择功能的时候同时查询用户
	 */
	public String func()
	{
		DrvUser user=this.getUser();
		this.getiDrvQueryHelper().getUserWithLicense(user);
		this.setUser(user);
		logger.debug("选择功能时已经取到的人员流水号为 "+this.getUser().getLsh());
		return "funcselect";
	}




}
