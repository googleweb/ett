package com.ett.visual.model.admin;

import javax.swing.DebugGraphics;

import com.smartken.toyz4j.model.impl.BaseModel;



public class DepartmentModel extends BaseModel {


	 public static enum F { 
		  Id,CConnector,CMobile,CPhone,CCompanycode,CDepfullname,CDepnickname,CDepcode,CParentcode,CDeptype  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CConnector;         //C_CONNECTOR  VARCHAR2 20
		private String CMobile;         //C_MOBILE  VARCHAR2 11
		private String CPhone;         //C_PHONE  VARCHAR2 11
		private String CCompanycode;         //C_COMPANYCODE  VARCHAR2 20
		private String CDepfullname;         //C_DEPFULLNAME  VARCHAR2 100
		private String CDepnickname;         //C_DEPNICKNAME  VARCHAR2 20
		private String CDepcode;         //C_DEPCODE  VARCHAR2 30
		private String CParentcode;         //C_PARENTCODE  VARCHAR2 30
		private String CDeptype;         //C_DEPTYPE  VARCHAR2 30
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCConnector() {
			return CConnector;
		}
		public void setCConnector(String cConnector) {
			CConnector = cConnector;
		}
		public String getCMobile() {
			return CMobile;
		}
		public void setCMobile(String cMobile) {
			CMobile = cMobile;
		}
		public String getCPhone() {
			return CPhone;
		}
		public void setCPhone(String cPhone) {
			CPhone = cPhone;
		}
		public String getCCompanycode() {
			return CCompanycode;
		}
		public void setCCompanycode(String cCompanycode) {
			CCompanycode = cCompanycode;
		}
		public String getCDepfullname() {
			return CDepfullname;
		}
		public void setCDepfullname(String cDepfullname) {
			CDepfullname = cDepfullname;
		}
		public String getCDepnickname() {
			return CDepnickname;
		}
		public void setCDepnickname(String cDepnickname) {
			CDepnickname = cDepnickname;
		}
		public String getCDepcode() {
			return CDepcode;
		}
		public void setCDepcode(String cDepcode) {
			CDepcode = cDepcode;
		}
		public String getCParentcode() {
			return CParentcode;
		}
		public void setCParentcode(String cParentcode) {
			CParentcode = cParentcode;
		}
		public String getCDeptype() {
			return CDeptype;
		}
		public void setCDeptype(String cDeptype) {
			CDeptype = cDeptype;
		}
		@Override
		public Object getPk() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			
		}
		
		
		
   
}
