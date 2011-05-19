package com.ett.drv.model.admin;

import com.smartken.kia.core.model.impl.BaseModel;

public class DictTypeModel extends BaseModel{



	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static enum F{
		id,typename,description
	}
	
	private Integer id;         //ID  NUMBER 38
	private String typename;         //C_TYPENAME  VARCHAR2 60
	private String description;         //C_DESCRIPTION  VARCHAR2 100

}
