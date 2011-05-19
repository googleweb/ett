package com.ett.drv.model.admin;

import javax.swing.DebugGraphics;

import com.smartken.kia.core.model.impl.BaseModel;



public class DepartmentModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

   public static enum F{
	   id,connector,mobile,phone,companycode,depfullname,depnickname,depcode,parentcode,deptype
   }
 	
   
   private Integer id;         //ID  NUMBER 38
   private String connector;         //C_CONNECTOR  VARCHAR2 20
   private String mobile;         //C_MOBILE  VARCHAR2 11
   private String phone;         //C_PHONE  VARCHAR2 11
   private String companycode;         //C_COMPANYCODE  VARCHAR2 20
   private String depfullname;         //C_DEPFULLNAME  VARCHAR2 100
   private String depnickname;         //C_DEPNICKNAME  VARCHAR2 20
   private String depcode;         //C_DEPCODE  VARCHAR2 30
   private String parentcode;         //C_PARENTCODE  VARCHAR2 30
   private String deptype;         //C_DEPTYPE  VARCHAR2 30
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getConnector() {
	return connector;
}
public void setConnector(String connector) {
	this.connector = connector;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCompanycode() {
	return companycode;
}
public void setCompanycode(String companycode) {
	this.companycode = companycode;
}
public String getDepfullname() {
	return depfullname;
}
public void setDepfullname(String depfullname) {
	this.depfullname = depfullname;
}
public String getDepnickname() {
	return depnickname;
}
public void setDepnickname(String depnickname) {
	this.depnickname = depnickname;
}
public String getDepcode() {
	return depcode;
}
public void setDepcode(String depcode) {
	this.depcode = depcode;
}
public String getParentcode() {
	return parentcode;
}
public void setParentcode(String parentcode) {
	this.parentcode = parentcode;
}
public String getDeptype() {
	return deptype;
}
public void setDeptype(String deptype) {
	this.deptype = deptype;
}
   
   
   
}
