package com.ett.drv.model.self;

import com.smartken.kia.core.model.impl.BaseModel;

public class TransactResourceModel extends BaseModel {


	public static enum F{
		flowNo,driverIdFrontImg,driverIdBackImg,agentIdFrontImg,agentIdBackImg,captureImg
	}

	private String flowNo;         //FLOW_NO  VARCHAR2 100
	private byte[] driverIdFrontImg;         //DRIVER_ID_FRONT_IMG  BLOB 100
	private byte[] driverIdBackImg;         //DRIVER_ID_BACK_IMG  BLOB 100
	private byte[] agentIdFrontImg;         //AGENT_ID_FRONT_IMG  BLOB 100
	private byte[] agentIdBackImg;         //AGENT_ID_BACK_IMG  BLOB 100
	private byte[] captureImg;         //CAPTURE_IMG  BLOB 100
	
	
	public String getFlowNo() {
		return flowNo;
	}
	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}
	public byte[] getDriverIdFrontImg() {
		return driverIdFrontImg;
	}
	public void setDriverIdFrontImg(byte[] driverIdFrontImg) {
		this.driverIdFrontImg = driverIdFrontImg;
	}
	public byte[] getDriverIdBackImg() {
		return driverIdBackImg;
	}
	public void setDriverIdBackImg(byte[] driverIdBackImg) {
		this.driverIdBackImg = driverIdBackImg;
	}
	public byte[] getAgentIdFrontImg() {
		return agentIdFrontImg;
	}
	public void setAgentIdFrontImg(byte[] agentIdFrontImg) {
		this.agentIdFrontImg = agentIdFrontImg;
	}
	public byte[] getAgentIdBackImg() {
		return agentIdBackImg;
	}
	public void setAgentIdBackImg(byte[] agentIdBackImg) {
		this.agentIdBackImg = agentIdBackImg;
	}
	public byte[] getCaptureImg() {
		return captureImg;
	}
	public void setCaptureImg(byte[] captureImg) {
		this.captureImg = captureImg;
	}
	
	
	
}
