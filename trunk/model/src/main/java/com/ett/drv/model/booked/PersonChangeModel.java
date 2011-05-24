package com.ett.drv.model.booked;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class PersonChangeModel extends BaseModel {

	 public static enum F { 
		  Id,CName,CIdcardType,CIdcard,CDabh,COldPhone,CNewPhone,CNewAddress,CNewPostcode,ISyn,DateCreatetime,
		CCheckOperator,CCheckDate,IChecked,CCheckResult,CEmail  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CName;         //C_NAME  VARCHAR2 30
		private String CIdcardType;         //C_IDCARD_TYPE  VARCHAR2 4
		private String CIdcard;         //C_IDCARD  VARCHAR2 30
		private String CDabh;         //C_DABH  VARCHAR2 30
		private String COldPhone;         //C_OLD_PHONE  VARCHAR2 11
		private String CNewPhone;         //C_NEW_PHONE  VARCHAR2 11
		private String CNewAddress;         //C_NEW_ADDRESS  VARCHAR2 300
		private String CNewPostcode;         //C_NEW_POSTCODE  VARCHAR2 12
		private Integer ISyn;         //I_SYN  NUMBER 38
		private Date DateCreatetime;         //DATE_CREATETIME  DATE 0
		private String CCheckOperator;         //C_CHECK_OPERATOR  VARCHAR2 30
		private String CCheckDate;         //C_CHECK_DATE  VARCHAR2 30
		private Integer IChecked;         //I_CHECKED  NUMBER 38
		private String CCheckResult;         //C_CHECK_RESULT  VARCHAR2 1,000
		private String CEmail;         //C_EMAIL  VARCHAR2 100
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCName() {
			return CName;
		}
		public void setCName(String cName) {
			CName = cName;
		}
		public String getCIdcardType() {
			return CIdcardType;
		}
		public void setCIdcardType(String cIdcardType) {
			CIdcardType = cIdcardType;
		}
		public String getCIdcard() {
			return CIdcard;
		}
		public void setCIdcard(String cIdcard) {
			CIdcard = cIdcard;
		}
		public String getCDabh() {
			return CDabh;
		}
		public void setCDabh(String cDabh) {
			CDabh = cDabh;
		}
		public String getCOldPhone() {
			return COldPhone;
		}
		public void setCOldPhone(String cOldPhone) {
			COldPhone = cOldPhone;
		}
		public String getCNewPhone() {
			return CNewPhone;
		}
		public void setCNewPhone(String cNewPhone) {
			CNewPhone = cNewPhone;
		}
		public String getCNewAddress() {
			return CNewAddress;
		}
		public void setCNewAddress(String cNewAddress) {
			CNewAddress = cNewAddress;
		}
		public String getCNewPostcode() {
			return CNewPostcode;
		}
		public void setCNewPostcode(String cNewPostcode) {
			CNewPostcode = cNewPostcode;
		}
		public Integer getISyn() {
			return ISyn;
		}
		public void setISyn(Integer iSyn) {
			ISyn = iSyn;
		}
		public Date getDateCreatetime() {
			return DateCreatetime;
		}
		public void setDateCreatetime(Date dateCreatetime) {
			DateCreatetime = dateCreatetime;
		}
		public String getCCheckOperator() {
			return CCheckOperator;
		}
		public void setCCheckOperator(String cCheckOperator) {
			CCheckOperator = cCheckOperator;
		}
		public String getCCheckDate() {
			return CCheckDate;
		}
		public void setCCheckDate(String cCheckDate) {
			CCheckDate = cCheckDate;
		}
		public Integer getIChecked() {
			return IChecked;
		}
		public void setIChecked(Integer iChecked) {
			IChecked = iChecked;
		}
		public String getCCheckResult() {
			return CCheckResult;
		}
		public void setCCheckResult(String cCheckResult) {
			CCheckResult = cCheckResult;
		}
		public String getCEmail() {
			return CEmail;
		}
		public void setCEmail(String cEmail) {
			CEmail = cEmail;
		}
		
		

}
