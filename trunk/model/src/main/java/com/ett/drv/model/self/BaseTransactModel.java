package com.ett.drv.model.self;

import java.text.MessageFormat;
import java.util.Date;

import com.ett.drv.model.self.TransactVehicleModel.ETransact;
import com.smartken.kia.core.model.impl.BaseModel;
import com.smartken.kia.core.util.DateTimeUtil;

public abstract class BaseTransactModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	 public static enum EApplicat{
		 driver,agent
	 }
	 
	 public static enum EPayment{
		 cash,pos
	 }
	
	 public static enum EReceive{
		 post,pull,pullOrPost
	 }
	 

	  public static class Applicat{
		  public static String DRIVER="驾驶人";
		  public static String AGENT="申请人";
	  }
	  
	  public static class Payment{
		  public static String CASH="现金";
		  public static String POS="银联pos";
	  }
	  
	  public static class Receive{
		  public static String POST="快递";
		  public static String PULL="自取";
		  public static String PULL_OR_POST="自取或邮寄";
	  }
	
	
	public static enum F{
		transact,applicat,driverIdNo,agentIdNo,driverIdName,agentIdName,createDate,verifyDate,verifyInd,tel,verifyerFk,
		remark,payment,receive,flowNo,phone,reason,payInd,printInd,plateNo,driverIdFrontImg,
		driverIdBackImg,agentIdFrontImg,agentIdBackImg,captureImg,seqno,item,costPost,costTransact,passInd
	}

	protected String transact;         //TRANSACT  VARCHAR2 50
	protected String applicat;         //APPLICAT  VARCHAR2 100
	protected String driverIdNo;         //DRIVER_ID_NO  VARCHAR2 20
	protected String agentIdNo;         //AGENT_ID_NO  VARCHAR2 20
	protected String driverIdName;         //DRIVER_ID_NAME  VARCHAR2 20
	protected String agentIdName;         //AGENT_ID_NAME  VARCHAR2 20
	protected Date createDate;         //CREATE_DATE  DATE 0
	protected Date verifyDate;         //VERIFY_DATE  DATE 0
	protected String verifyInd;         //VERIFY_IND  CHAR 1
	protected String tel;         //TEL  VARCHAR2 30
	protected String verifyerFk;         //VERIFYER_FK  VARCHAR2 30
	protected String remark;         //REMARK  VARCHAR2 300
	protected String payment;         //PAYMENT  VARCHAR2 10
	protected String receive;         //RECEIVE  VARCHAR2 20
	protected String flowNo;         //FLOW_NO  VARCHAR2 100
	protected String phone;         //PHONE  VARCHAR2 30
	protected String reason;         //REASON  VARCHAR2 50
	protected String payInd;         //PAY_IND  CHAR 1
	protected String printInd;         //PRINT_IND  CHAR 1
	protected Integer seqno;         //SEQNO  NUMBER 38
	protected String item;         //ITEM  VARCHAR2 50
	protected Double costPost;         //COST_POST  NUMBER 126
	protected Double costTransact;         //COST_TRANSACT  NUMBER 126
	protected String passInd;         //PASS_IND  CHAR 1
	
	
	public static String generalFlowNo(int code,Date createDate,String seqNo){
		while(seqNo.length()<6){
			seqNo="0"+seqNo;
		}
		String flowNo=MessageFormat.format("{0}{1}{2}", 
		     code,
		     DateTimeUtil.format(createDate==null?new Date():createDate, "yyyyMMdd")
		     ,seqNo
		);
		return flowNo;
	}
	


	public String getTransact() {
		return transact;
	}

	public void setTransact(String transact) {
		this.transact = transact;
	}

	public String getApplicat() {
		return applicat;
	}

	public void setApplicat(String applicat) {
		if(BaseTransactModel.EApplicat.agent.name().equalsIgnoreCase(applicat))
		{
		   this.applicat=BaseTransactModel.Applicat.AGENT;
		}else  if(BaseTransactModel.EApplicat.driver.name().equalsIgnoreCase(applicat))
		{
			   this.applicat=BaseTransactModel.Applicat.DRIVER;
			} 
		else {
		this.applicat = applicat;
		}
	}

	public String getDriverIdNo() {
		return driverIdNo;
	}

	public void setDriverIdNo(String driverIdNo) {
		this.driverIdNo = driverIdNo;
	}

	public String getAgentIdNo() {
		return agentIdNo;
	}

	public void setAgentIdNo(String agentIdNo) {
		this.agentIdNo = agentIdNo;
	}

	public String getDriverIdName() {
		return driverIdName;
	}

	public void setDriverIdName(String driverIdName) {
		this.driverIdName = driverIdName;
	}

	public String getAgentIdName() {
		return agentIdName;
	}

	public void setAgentIdName(String agentIdName) {
		this.agentIdName = agentIdName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifyInd() {
		return verifyInd;
	}

	public void setVerifyInd(String verifyInd) {
		this.verifyInd = verifyInd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVerifyerFk() {
		return verifyerFk;
	}

	public void setVerifyerFk(String verifyerFk) {
		this.verifyerFk = verifyerFk;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		if(BaseTransactModel.EPayment.pos.name().equalsIgnoreCase(payment)){
			this.payment=BaseTransactModel.Payment.POS;
		} else 	if(BaseTransactModel.EPayment.cash.name().equalsIgnoreCase(payment)){
			this.payment=BaseTransactModel.Payment.CASH;
		}else {
		this.payment = payment;
		}
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		if(BaseTransactModel.EReceive.post.name().equalsIgnoreCase(receive)){
			this.receive=BaseTransactModel.Receive.POST;
		}else if(BaseTransactModel.EReceive.pull.name().equalsIgnoreCase(receive)){
			this.receive=BaseTransactModel.Receive.PULL;
		}else if(BaseTransactModel.EReceive.pullOrPost.name().equalsIgnoreCase(receive)){
			this.receive=BaseTransactModel.Receive.PULL_OR_POST;
		}else {
		this.receive = receive;
		}
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPayInd() {
		return payInd;
	}

	public void setPayInd(String payInd) {
		this.payInd = payInd;
	}

	public String getPrintInd() {
		return printInd;
	}

	public void setPrintInd(String printInd) {
		this.printInd = printInd;
	}


	

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getCostPost() {
		return costPost;
	}

	public void setCostPost(Double costPost) {
		this.costPost = costPost;
	}

	public Double getCostTransact() {
		return costTransact;
	}

	public void setCostTransact(Double costTransact) {
		this.costTransact = costTransact;
	}

	public String getPassInd() {
		return passInd;
	}

	public void setPassInd(String passInd) {
		this.passInd = passInd;
	}
	
	
	

	
}
