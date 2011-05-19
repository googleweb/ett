package com.ett.drv.model.admin;


import com.smartken.kia.core.model.impl.BaseModel;


public class MenuModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	public static enum F{
		id,name,descp,url,parma,parentId,ordernum,icon,token,folder
	}

	private String id;         //ID  VARCHAR2 100
	private String name;         //NAME  VARCHAR2 100
	private String descp;         //DESCP  VARCHAR2 400
	private String url;         //URL  VARCHAR2 400
	private String parma;         //PARMA  VARCHAR2 400
	private String parentId;         //PARENT_ID  VARCHAR2 20
	private Integer ordernum;         //ORDERNUM  NUMBER 38
	private String icon;         //ICON  VARCHAR2 50
	private String token;         //TOKEN  CHAR 3
	private String folder;         //FOLDER  CHAR 1
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParma() {
		return parma;
	}
	public void setParma(String parma) {
		this.parma = parma;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	
	
	
}
