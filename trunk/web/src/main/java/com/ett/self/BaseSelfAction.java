/**
 * 
 */
package com.ett.self;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.drv.biz.IDrvQueryHelper;
import com.ett.model.DrvUser;
import com.ett.self.biz.IDeviceHelper;
import com.ett.self.biz.IIdGeneratorBiz;
import com.ett.self.fee.model.FeeObject;
import com.ett.self.model.PrintObject;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.model.SelfHardObject;
import com.ett.web.framework.struts2.AbstractStruts2BaseAction;

/**
 * @author austin
 *
 */
public class BaseSelfAction extends AbstractStruts2BaseAction {
	/**
	 * Logger for this class
	 */
	protected static final Logger logger = Logger.getLogger(BaseSelfAction.class);
	
	private IIdGeneratorBiz iIdGeneratorBiz;
	

	public String to_index() throws Exception
	{
		    
		return "jsp";
		    
	}
	
	protected static final String Self_Fee_Object="self_fee_info"; 

	
	public FeeObject getFeeObject() {
		Object obj=this.getHttpSession().getAttribute(Self_Fee_Object);
		if(obj==null)
		{
			logger.debug("BaseSelfAction获取缴费对象为"+obj);
			obj=new FeeObject();
			this.setFeeObject((FeeObject)obj);
			//this.getHttpSession().setAttribute(Self_Fee_Object, obj);
		}
		return (FeeObject)obj;
	}


	public void setFeeObject(FeeObject feeObject) {
		this.getHttpSession().setAttribute(Self_Fee_Object, feeObject);
	}


	/**
	 * @return 获取当天的一个新排队号
	 */
	public int createNewId()
	{
		return this.iIdGeneratorBiz.createNewId();
	}
	
	
	/**
	 * @return 获取ID自动产生器
	 */
	public IIdGeneratorBiz getiIdGeneratorBiz() {
		return iIdGeneratorBiz;
	}
	public void setiIdGeneratorBiz(IIdGeneratorBiz iIdGeneratorBiz) {
		this.iIdGeneratorBiz = iIdGeneratorBiz;
	}
	/**
	 * @return 获取设备的基本信息,单个硬件用的时候再取，不从session取
	 */
	public SelfDeviceObject getDevice()
	{
		Object obj=this.getHttpSession().getAttribute("self_device_info");
		if(obj==null)
		{
			logger.debug("BaseSelfAction获取IP为"+this.getRemoteAddr()+"的设备配置信息！");
			obj=this.iDeviceHelper.getDevice(this.getRemoteAddr());
			if(obj==null)
			{
				String exception="没有找到IP为"+this.getRemoteAddr()+"的设备配置信息！";
				//this.setHttpSession("exceptionhintmessage", exception);
				throw new ObjectDontExistException(exception);
			}
			
			this.getHttpSession().setAttribute("self_device_info", obj);
		}
		return  (SelfDeviceObject)obj;
	}
	
	protected IDeviceHelper iDeviceHelper;
	
	public void initHotPrinter()
	{
		this.hotPrinter=iDeviceHelper.getHotPrinter(this.getDevice().getId());
	}
	public void initNeedlePrinter()
	{
		this.needlePrinter=iDeviceHelper.getNeedlePrinter(this.getDevice().getId());
	}
	
	protected SelfHardObject hotPrinter;
	
	protected SelfHardObject needlePrinter;
	
	protected SelfHardObject cashCode;
	
	protected SelfHardObject idCardReader;
	
	protected SelfHardObject frontCapture;
	
	protected SelfHardObject endCapture;
	protected SelfHardObject keyboard;
	
	protected SelfHardObject visaCardReader;
	
	public SelfHardObject getHotPrinter() {
		return hotPrinter;
	}

	public void setHotPrinter(SelfHardObject hotPrinter) {
		this.hotPrinter = hotPrinter;
	}

	public SelfHardObject getNeedlePrinter() {
		return needlePrinter;
	}

	public void setNeedlePrinter(SelfHardObject needlePrinter) {
		this.needlePrinter = needlePrinter;
	}

	public SelfHardObject getCashCode() {
		return cashCode;
	}

	public void setCashCode(SelfHardObject cashCode) {
		this.cashCode = cashCode;
	}

	public SelfHardObject getIdCardReader() {
		return idCardReader;
	}

	public void setIdCardReader(SelfHardObject idCardReader) {
		this.idCardReader = idCardReader;
	}

	public SelfHardObject getFrontCapture() {
		return frontCapture;
	}

	public void setFrontCapture(SelfHardObject frontCapture) {
		this.frontCapture = frontCapture;
	}

	public SelfHardObject getEndCapture() {
		return endCapture;
	}

	public void setEndCapture(SelfHardObject endCapture) {
		this.endCapture = endCapture;
	}

	public SelfHardObject getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(SelfHardObject keyboard) {
		this.keyboard = keyboard;
	}

	public SelfHardObject getVisaCardReader() {
		return visaCardReader;
	}

	public void setVisaCardReader(SelfHardObject visaCardReader) {
		this.visaCardReader = visaCardReader;
	}

	
	public IDeviceHelper getiDeviceHelper() {
		return iDeviceHelper;
	}
	public void setiDeviceHelper(IDeviceHelper iDeviceHelper) {
		this.iDeviceHelper = iDeviceHelper;
	}

	protected PrintObject printObject;

	public PrintObject getPrintObject() {
		return printObject;
	}
	public void setPrintObject(PrintObject printObject) {
		this.printObject = printObject;
	}
	
	protected DrvUser user;
	public DrvUser getUser() {
		Object obj=ServletActionContext.getRequest().getSession().getAttribute(Self_User_Constant);
		logger.debug("从Session中获取DrvUser的结果为:"+obj);
		if(obj==null)
		{
			String idcard=this.getHtmlAttributeOrParamter("idcard");
			logger.debug("BaseSelfAction获取到用户的身份证明号码为："+idcard);
			obj=iDrvQueryHelper.getDrvUser(idcard,this.getDevice().getGlbm());
			
			//user=null;
			if(obj==null)
			{
				String exception="对不起，您不属于本车管所管辖范围内！";
				//this.setHintMsg(exception);
				//this.setHttpSession("exceptionhintmessage", exception);
				throw new ObjectDontExistException(exception);
			}
			else
			{
				this.setUser((DrvUser)obj);
			}
			//return user;
		}
		user=(DrvUser)obj;
		return user;
	}
	public void setUser(DrvUser user) {
		//this.user = user;
		ServletActionContext.getRequest().getSession().setAttribute(Self_User_Constant, user);
	}

	/**
	 * 自助终端的用户Session中的key
	 */
	public static final String Self_User_Constant="self_user_constant";


	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected IDrvQueryHelper iDrvQueryHelper;

	public IDrvQueryHelper getiDrvQueryHelper() {
		return iDrvQueryHelper;
	}
	public void setiDrvQueryHelper(IDrvQueryHelper iDrvQueryHelper) {
		this.iDrvQueryHelper = iDrvQueryHelper;
	}



}
