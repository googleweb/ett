package com.ett.drv.model.self;

import com.smartken.kia.core.model.impl.BaseModel;

public class TerminalModel extends BaseModel {

	
	
	@Override
	public Enum[] enumFields() {
		// TODO Auto-generated method stub
		return TerminalModel.F.values();
	}





	 public static enum F { 
		  Id,Glbm,Fzjg,Name,Catalog,Mac1,Mac2,Ip1,Ip2,Address,YlwgUrl,
		YlwgTimout,DriverUrl,DriverTimeout,CarUrl,CarTimeout,VioUrl,VioTimeout,Descp  
		 } 

		private Double Id;         //ID  NUMBER 5
		private String Glbm;         //GLBM  VARCHAR2 100
		private String Fzjg;         //FZJG  VARCHAR2 100
		private String Name;         //NAME  VARCHAR2 100
		private String Catalog;         //CATALOG  VARCHAR2 100
		private String Mac1;         //MAC1  VARCHAR2 100
		private String Mac2;         //MAC2  VARCHAR2 100
		private String Ip1;         //IP1  VARCHAR2 100
		private String Ip2;         //IP2  VARCHAR2 100
		private String Address;         //ADDRESS  VARCHAR2 150
		private String YlwgUrl;         //YLWG_URL  VARCHAR2 50
		private Double YlwgTimout;         //YLWG_TIMOUT  NUMBER 5
		private String DriverUrl;         //DRIVER_URL  VARCHAR2 150
		private Double DriverTimeout;         //DRIVER_TIMEOUT  NUMBER 5
		private String CarUrl;         //CAR_URL  VARCHAR2 150
		private Double CarTimeout;         //CAR_TIMEOUT  NUMBER 5
		private String VioUrl;         //VIO_URL  VARCHAR2 150
		private Double VioTimeout;         //VIO_TIMEOUT  NUMBER 5
		private String Descp;         //DESCP  VARCHAR2 150
		public Double getId() {
			return Id;
		}





		public void setId(Double id) {
			Id = id;
		}





		public String getGlbm() {
			return Glbm;
		}





		public void setGlbm(String glbm) {
			Glbm = glbm;
		}





		public String getFzjg() {
			return Fzjg;
		}





		public void setFzjg(String fzjg) {
			Fzjg = fzjg;
		}





		public String getName() {
			return Name;
		}





		public void setName(String name) {
			Name = name;
		}





		public String getCatalog() {
			return Catalog;
		}





		public void setCatalog(String catalog) {
			Catalog = catalog;
		}





		public String getMac1() {
			return Mac1;
		}





		public void setMac1(String mac1) {
			Mac1 = mac1;
		}





		public String getMac2() {
			return Mac2;
		}





		public void setMac2(String mac2) {
			Mac2 = mac2;
		}





		public String getIp1() {
			return Ip1;
		}





		public void setIp1(String ip1) {
			Ip1 = ip1;
		}





		public String getIp2() {
			return Ip2;
		}





		public void setIp2(String ip2) {
			Ip2 = ip2;
		}





		public String getAddress() {
			return Address;
		}





		public void setAddress(String address) {
			Address = address;
		}





		public String getYlwgUrl() {
			return YlwgUrl;
		}





		public void setYlwgUrl(String ylwgUrl) {
			YlwgUrl = ylwgUrl;
		}





		public Double getYlwgTimout() {
			return YlwgTimout;
		}





		public void setYlwgTimout(Double ylwgTimout) {
			YlwgTimout = ylwgTimout;
		}





		public String getDriverUrl() {
			return DriverUrl;
		}





		public void setDriverUrl(String driverUrl) {
			DriverUrl = driverUrl;
		}





		public Double getDriverTimeout() {
			return DriverTimeout;
		}





		public void setDriverTimeout(Double driverTimeout) {
			DriverTimeout = driverTimeout;
		}





		public String getCarUrl() {
			return CarUrl;
		}





		public void setCarUrl(String carUrl) {
			CarUrl = carUrl;
		}





		public Double getCarTimeout() {
			return CarTimeout;
		}





		public void setCarTimeout(Double carTimeout) {
			CarTimeout = carTimeout;
		}





		public String getVioUrl() {
			return VioUrl;
		}





		public void setVioUrl(String vioUrl) {
			VioUrl = vioUrl;
		}





		public Double getVioTimeout() {
			return VioTimeout;
		}





		public void setVioTimeout(Double vioTimeout) {
			VioTimeout = vioTimeout;
		}





		public String getDescp() {
			return Descp;
		}





		public void setDescp(String descp) {
			Descp = descp;
		}
	
	
	
}
