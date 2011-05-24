package com.ett.drv.model.admin;

import com.smartken.kia.core.model.impl.BaseModel;


public class UserModel extends BaseModel {


	
	 public static enum F { 
		  Id,CLoginName,CFullName,CPwd,IRoleid,IDepid,CIdcard,CWorkid,CBeginip,CEndip,CState  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CLoginName;         //C_LOGIN_NAME  VARCHAR2 30
		private String CFullName;         //C_FULL_NAME  VARCHAR2 30
		private String CPwd;         //C_PWD  VARCHAR2 200
		private Integer IRoleid;         //I_ROLEID  NUMBER 38
		private Integer IDepid;         //I_DEPID  NUMBER 38
		private String CIdcard;         //C_IDCARD  VARCHAR2 20
		private String CWorkid;         //C_WORKID  VARCHAR2 20
		private String CBeginip;         //C_BEGINIP  VARCHAR2 30
		private String CEndip;         //C_ENDIP  VARCHAR2 30
		private String CState;         //C_STATE  VARCHAR2 8
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCLoginName() {
			return CLoginName;
		}
		public void setCLoginName(String cLoginName) {
			CLoginName = cLoginName;
		}
		public String getCFullName() {
			return CFullName;
		}
		public void setCFullName(String cFullName) {
			CFullName = cFullName;
		}
		public String getCPwd() {
			return CPwd;
		}
		public void setCPwd(String cPwd) {
			CPwd = cPwd;
		}
		public Integer getIRoleid() {
			return IRoleid;
		}
		public void setIRoleid(Integer iRoleid) {
			IRoleid = iRoleid;
		}
		public Integer getIDepid() {
			return IDepid;
		}
		public void setIDepid(Integer iDepid) {
			IDepid = iDepid;
		}
		public String getCIdcard() {
			return CIdcard;
		}
		public void setCIdcard(String cIdcard) {
			CIdcard = cIdcard;
		}
		public String getCWorkid() {
			return CWorkid;
		}
		public void setCWorkid(String cWorkid) {
			CWorkid = cWorkid;
		}
		public String getCBeginip() {
			return CBeginip;
		}
		public void setCBeginip(String cBeginip) {
			CBeginip = cBeginip;
		}
		public String getCEndip() {
			return CEndip;
		}
		public void setCEndip(String cEndip) {
			CEndip = cEndip;
		}
		public String getCState() {
			return CState;
		}
		public void setCState(String cState) {
			CState = cState;
		}
		
		
	
	
	
}
