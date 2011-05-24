package com.ett.drv.model.self;

import java.text.MessageFormat;
import java.util.Date;

import com.ett.drv.model.self.TransactVehicleModel.ETransact;
import com.smartken.kia.core.model.impl.BaseModel;
import com.smartken.kia.core.util.DateTimeUtil;

public abstract class BaseTransactModel extends BaseModel {



	 public static enum EApplicat{
		 driver,agent
	 }
	 
	 public static enum EPayment{
		 cash,pos
	 }
	
	 public static enum EReceive{
		 post,pull,pullOrPost
	 }
	 

	  public static class Applicats{
		  public static String DRIVER="驾驶人";
		  public static String AGENT="申请人";
	  }
	  
	  public static class Payments{
		  public static String CASH="现金";
		  public static String POS="银联pos";
	  }
	  
	  public static class Receives{
		  public static String POST="快递";
		  public static String PULL="自取";
		  public static String PULL_OR_POST="自取或邮寄";
	  }
	
	

	
	
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
	




	public void setApplicat(String applicat) {
		if(BaseTransactModel.EApplicat.agent.name().equalsIgnoreCase(applicat))
		{
		   this.Applicat=BaseTransactModel.Applicats.AGENT;
		}else  if(BaseTransactModel.EApplicat.driver.name().equalsIgnoreCase(applicat))
		{
			   this.Applicat=BaseTransactModel.Applicats.DRIVER;
			} 
		else {
		this.Applicat = applicat;
		}
	}

	

	public void setPayment(String payment) {
		if(BaseTransactModel.EPayment.pos.name().equalsIgnoreCase(payment)){
			this.Payment=BaseTransactModel.Payments.POS;
		} else 	if(BaseTransactModel.EPayment.cash.name().equalsIgnoreCase(payment)){
			this.Payment=BaseTransactModel.Payments.CASH;
		}else {
		this.Payment = payment;
		}
	}



	public void setReceive(String receive) {
		if(BaseTransactModel.EReceive.post.name().equalsIgnoreCase(receive)){
			this.Receive=BaseTransactModel.Receives.POST;
		}else if(BaseTransactModel.EReceive.pull.name().equalsIgnoreCase(receive)){
			this.Receive=BaseTransactModel.Receives.PULL;
		}else if(BaseTransactModel.EReceive.pullOrPost.name().equalsIgnoreCase(receive)){
			this.Receive=BaseTransactModel.Receives.PULL_OR_POST;
		}else {
		this.Receive = receive;
		}
	}

	
	
	 public static enum F { 
		  Transact,Applicat,DriverIdNo,AgentIdNo,DriverIdName,AgentIdName,CreateDate,VerifyDate,VerifyInd,Tel,VerifyerFk,
		Remark,Payment,Receive,FlowNo,Phone,Reason,PayInd,PrintInd,Item,
		CostPost,CostTransact,PassInd,Seqno  
		 } 

		protected String Transact;         //TRANSACT  VARCHAR2 50
		protected String Applicat;         //APPLICAT  VARCHAR2 100
		protected String DriverIdNo;         //DRIVER_ID_NO  VARCHAR2 20
		protected String AgentIdNo;         //AGENT_ID_NO  VARCHAR2 20
		protected String DriverIdName;         //DRIVER_ID_NAME  VARCHAR2 20
		protected String AgentIdName;         //AGENT_ID_NAME  VARCHAR2 20
		protected Date CreateDate;         //CREATE_DATE  DATE 0
		protected Date VerifyDate;         //VERIFY_DATE  DATE 0
		protected String VerifyInd;         //VERIFY_IND  CHAR 1
		protected String Tel;         //TEL  VARCHAR2 30
		protected String VerifyerFk;         //VERIFYER_FK  VARCHAR2 30
		protected String Remark;         //REMARK  VARCHAR2 300
		protected String Payment;         //PAYMENT  VARCHAR2 10
		protected String Receive;         //RECEIVE  VARCHAR2 20
		protected String FlowNo;         //FLOW_NO  VARCHAR2 100
		protected String Phone;         //PHONE  VARCHAR2 30
		protected String Reason;         //REASON  VARCHAR2 50
		protected String PayInd;         //PAY_IND  CHAR 1
		protected String PrintInd;         //PRINT_IND  CHAR 1
		//protected String LicenseNo;         //LICENSE_NO  VARCHAR2 100
		protected String Item;         //ITEM  VARCHAR2 50
		protected Double CostPost;         //COST_POST  NUMBER 126
		protected Double CostTransact;         //COST_TRANSACT  NUMBER 126
		protected String PassInd;         //PASS_IND  CHAR 1
		protected Integer Seqno;         //SEQNO  NUMBER 38
		public String getTransact() {
			return Transact;
		}





		public void setTransact(String transact) {
			Transact = transact;
		}





		public String getDriverIdNo() {
			return DriverIdNo;
		}





		public void setDriverIdNo(String driverIdNo) {
			DriverIdNo = driverIdNo;
		}





		public String getAgentIdNo() {
			return AgentIdNo;
		}





		public void setAgentIdNo(String agentIdNo) {
			AgentIdNo = agentIdNo;
		}





		public String getDriverIdName() {
			return DriverIdName;
		}





		public void setDriverIdName(String driverIdName) {
			DriverIdName = driverIdName;
		}





		public String getAgentIdName() {
			return AgentIdName;
		}





		public void setAgentIdName(String agentIdName) {
			AgentIdName = agentIdName;
		}





		public Date getCreateDate() {
			return CreateDate;
		}





		public void setCreateDate(Date createDate) {
			CreateDate = createDate;
		}





		public Date getVerifyDate() {
			return VerifyDate;
		}





		public void setVerifyDate(Date verifyDate) {
			VerifyDate = verifyDate;
		}





		public String getVerifyInd() {
			return VerifyInd;
		}





		public void setVerifyInd(String verifyInd) {
			VerifyInd = verifyInd;
		}





		public String getTel() {
			return Tel;
		}





		public void setTel(String tel) {
			Tel = tel;
		}





		public String getVerifyerFk() {
			return VerifyerFk;
		}





		public void setVerifyerFk(String verifyerFk) {
			VerifyerFk = verifyerFk;
		}





		public String getRemark() {
			return Remark;
		}





		public void setRemark(String remark) {
			Remark = remark;
		}





		public String getFlowNo() {
			return FlowNo;
		}





		public void setFlowNo(String flowNo) {
			FlowNo = flowNo;
		}





		public String getPhone() {
			return Phone;
		}





		public void setPhone(String phone) {
			Phone = phone;
		}





		public String getReason() {
			return Reason;
		}





		public void setReason(String reason) {
			Reason = reason;
		}





		public String getPayInd() {
			return PayInd;
		}





		public void setPayInd(String payInd) {
			PayInd = payInd;
		}





		public String getPrintInd() {
			return PrintInd;
		}





		public void setPrintInd(String printInd) {
			PrintInd = printInd;
		}





		public String getItem() {
			return Item;
		}





		public void setItem(String item) {
			Item = item;
		}





		public Double getCostPost() {
			return CostPost;
		}





		public void setCostPost(Double costPost) {
			CostPost = costPost;
		}





		public Double getCostTransact() {
			return CostTransact;
		}





		public void setCostTransact(Double costTransact) {
			CostTransact = costTransact;
		}





		public String getPassInd() {
			return PassInd;
		}





		public void setPassInd(String passInd) {
			PassInd = passInd;
		}





		public Integer getSeqno() {
			return Seqno;
		}





		public void setSeqno(Integer seqno) {
			Seqno = seqno;
		}





		public String getApplicat() {
			return Applicat;
		}





		public String getPayment() {
			return Payment;
		}





		public String getReceive() {
			return Receive;
		}
	

	
}
