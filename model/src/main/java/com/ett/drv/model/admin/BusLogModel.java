package com.ett.drv.model.admin;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class BusLogModel extends BaseModel{

	
	 public static enum F { 
		  Id,COperator,CBustype,Regdate,CContent,CDes1,CDes2,CDes3,IDepid  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String COperator;         //C_OPERATOR  VARCHAR2 30
		private String CBustype;         //C_BUSTYPE  VARCHAR2 60
		private Date Regdate;         //REGDATE  DATE 0
		private String CContent;         //C_CONTENT  VARCHAR2 500
		private String CDes1;         //C_DES1  VARCHAR2 60
		private String CDes2;         //C_DES2  VARCHAR2 60
		private String CDes3;         //C_DES3  VARCHAR2 60
		private Integer IDepid;         //I_DEPID  NUMBER 38
		
		private Date qStartRegDate;
		private Date qEndRegDate;
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCOperator() {
			return COperator;
		}
		public void setCOperator(String cOperator) {
			COperator = cOperator;
		}
		public String getCBustype() {
			return CBustype;
		}
		public void setCBustype(String cBustype) {
			CBustype = cBustype;
		}
		public Date getRegdate() {
			return Regdate;
		}
		public void setRegdate(Date regdate) {
			Regdate = regdate;
		}
		public String getCContent() {
			return CContent;
		}
		public void setCContent(String cContent) {
			CContent = cContent;
		}
		public String getCDes1() {
			return CDes1;
		}
		public void setCDes1(String cDes1) {
			CDes1 = cDes1;
		}
		public String getCDes2() {
			return CDes2;
		}
		public void setCDes2(String cDes2) {
			CDes2 = cDes2;
		}
		public String getCDes3() {
			return CDes3;
		}
		public void setCDes3(String cDes3) {
			CDes3 = cDes3;
		}
		public Integer getIDepid() {
			return IDepid;
		}
		public void setIDepid(Integer iDepid) {
			IDepid = iDepid;
		}
		public Date getqStartRegDate() {
			return qStartRegDate;
		}
		public void setqStartRegDate(Date qStartRegDate) {
			this.qStartRegDate = qStartRegDate;
		}
		public Date getqEndRegDate() {
			return qEndRegDate;
		}
		public void setqEndRegDate(Date qEndRegDate) {
			this.qEndRegDate = qEndRegDate;
		}
		
		
		
		
		
}
