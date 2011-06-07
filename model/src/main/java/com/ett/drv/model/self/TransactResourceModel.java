package com.ett.drv.model.self;

import com.smartken.kia.core.model.impl.BaseModel;

public class TransactResourceModel extends BaseModel {


	 public static enum F { 
		  FlowNo,DriverIdFrontImg,DriverIdBackImg,AgentIdFrontImg,AgentIdBackImg,CaptureImg  
		 } 

		private String FlowNo;         //FLOW_NO  VARCHAR2 100
		private byte[] DriverIdFrontImg;         //DRIVER_ID_FRONT_IMG  BLOB 100
		private byte[] DriverIdBackImg;         //DRIVER_ID_BACK_IMG  BLOB 100
		private byte[] AgentIdFrontImg;         //AGENT_ID_FRONT_IMG  BLOB 100
		private byte[] AgentIdBackImg;         //AGENT_ID_BACK_IMG  BLOB 100
		private byte[] CaptureImg;         //CAPTURE_IMG  BLOB 100
		public String getFlowNo() {
			return FlowNo;
		}
		public void setFlowNo(String flowNo) {
			FlowNo = flowNo;
		}
		public byte[] getDriverIdFrontImg() {
			return DriverIdFrontImg;
		}
		public void setDriverIdFrontImg(byte[] driverIdFrontImg) {
			DriverIdFrontImg = driverIdFrontImg;
		}
		public byte[] getDriverIdBackImg() {
			return DriverIdBackImg;
		}
		public void setDriverIdBackImg(byte[] driverIdBackImg) {
			DriverIdBackImg = driverIdBackImg;
		}
		public byte[] getAgentIdFrontImg() {
			return AgentIdFrontImg;
		}
		public void setAgentIdFrontImg(byte[] agentIdFrontImg) {
			AgentIdFrontImg = agentIdFrontImg;
		}
		public byte[] getAgentIdBackImg() {
			return AgentIdBackImg;
		}
		public void setAgentIdBackImg(byte[] agentIdBackImg) {
			AgentIdBackImg = agentIdBackImg;
		}
		public byte[] getCaptureImg() {
			return CaptureImg;
		}
		public void setCaptureImg(byte[] captureImg) {
			CaptureImg = captureImg;
		}
		
		
		
	
	
	
	
}
