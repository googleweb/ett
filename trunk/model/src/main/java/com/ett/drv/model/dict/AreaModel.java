package com.ett.drv.model.dict;

import com.smartken.kia.core.model.impl.BaseModel;

public class AreaModel extends BaseModel{
	
	public static enum F{
		Province,District,Area,Dmz
	}
	
	private String Dmz;
	private String Province;
	private String District;
	private String Area;
	public String getDmz() {
		return Dmz;
	}
	public void setDmz(String dmz) {
		Dmz = dmz;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	

}
