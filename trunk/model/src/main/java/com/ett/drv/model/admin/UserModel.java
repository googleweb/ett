package com.ett.drv.model.admin;

import com.smartken.kia.core.model.impl.BaseModel;


public class UserModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static enum F{
		id,loginName,fullName,pwd,roleid,depid,idcard,workid,beginip,endip,state
	}
	
	private Integer id;         //ID  NUMBER 38
	private String loginName;         //C_LOGIN_NAME  VARCHAR2 30
	private String fullName;         //C_FULL_NAME  VARCHAR2 30
	private String pwd;         //C_PWD  VARCHAR2 200
	private Integer roleid;         //I_ROLEID  NUMBER 38
	private Integer depid;         //I_DEPID  NUMBER 38
	private String idcard;         //C_IDCARD  VARCHAR2 20
	private String workid;         //C_WORKID  VARCHAR2 20
	private String beginip;         //C_BEGINIP  VARCHAR2 30
	private String endip;         //C_ENDIP  VARCHAR2 30
	private String state;         //C_STATE  VARCHAR2 8
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getDepid() {
		return depid;
	}
	public void setDepid(Integer depid) {
		this.depid = depid;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getBeginip() {
		return beginip;
	}
	public void setBeginip(String beginip) {
		this.beginip = beginip;
	}
	public String getEndip() {
		return endip;
	}
	public void setEndip(String endip) {
		this.endip = endip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
	
}
