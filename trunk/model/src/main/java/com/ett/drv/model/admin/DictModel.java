package com.ett.drv.model.admin;

import com.smartken.kia.core.model.impl.BaseModel;

public class DictModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static enum F{
		id,typename,dictText,dictValue,des1,des2,des3,state
	}
	
	private Integer id;         //ID  NUMBER 38
	private String typename;         //C_TYPENAME  VARCHAR2 60
	private String dictText;         //C_DICT_TEXT  VARCHAR2 30
	private String dictValue;         //C_DICT_VALUE  VARCHAR2 30
	private String des1;         //C_DES1  VARCHAR2 30
	private String des2;         //C_DES2  VARCHAR2 30
	private String des3;         //C_DES3  VARCHAR2 30
	private String state;         //C_STATE  VARCHAR2 10
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getDictText() {
		return dictText;
	}
	public void setDictText(String dictText) {
		this.dictText = dictText;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public String getDes1() {
		return des1;
	}
	public void setDes1(String des1) {
		this.des1 = des1;
	}
	public String getDes2() {
		return des2;
	}
	public void setDes2(String des2) {
		this.des2 = des2;
	}
	public String getDes3() {
		return des3;
	}
	public void setDes3(String des3) {
		this.des3 = des3;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	




	
	
}
