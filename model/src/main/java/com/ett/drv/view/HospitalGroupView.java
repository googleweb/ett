package com.ett.drv.view;

import com.smartken.kia.core.model.impl.BaseModel;

public class HospitalGroupView extends BaseModel {

	public static enum F { 
		Hospital,Sum1,Sum2,Sum3,Sum4
		 } 
	private String Hospital;
	public String getHospital() {
		return Hospital;
	}
	public void setHospital(String hospital) {
		Hospital = hospital;
	}
	public Integer getSum1() {
		return Sum1;
	}
	public void setSum1(Integer sum1) {
		Sum1 = sum1;
	}
	public Integer getSum2() {
		return Sum2;
	}
	public void setSum2(Integer sum2) {
		Sum2 = sum2;
	}
	public Integer getSum3() {
		return Sum3;
	}
	public void setSum3(Integer sum3) {
		Sum3 = sum3;
	}
	public Integer getSum4() {
		return Sum4;
	}
	public void setSum4(Integer sum4) {
		Sum4 = sum4;
	}
	private Integer Sum1;  //已受理未体检
	private Integer Sum2;  //已年度体检
	private Integer Sum3;  //车管所已核对
	private Integer Sum4;  //受理退办
	
	
	
}
