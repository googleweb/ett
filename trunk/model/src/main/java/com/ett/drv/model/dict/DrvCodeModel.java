package com.ett.drv.model.dict;

import com.smartken.kia.core.model.impl.BaseModel;

public class DrvCodeModel extends BaseModel {

	 public static enum F { 
		  Dmlb,Dmz,Dmmc1,Dmmc2,Dmmc3,Dmmc4,Zt  
		 } 

		private Integer Dmlb;         //DMLB  NUMBER 3
		private String Dmz;         //DMZ  VARCHAR2 30
		private String Dmmc1;         //DMMC1  VARCHAR2 500
		private String Dmmc2;         //DMMC2  VARCHAR2 128
		private String Dmmc3;         //DMMC3  VARCHAR2 128
		private String Dmmc4;         //DMMC4  VARCHAR2 128
		private String Zt;         //ZT  CHAR 1
		public Integer getDmlb() {
			return Dmlb;
		}
		public void setDmlb(Integer dmlb) {
			Dmlb = dmlb;
		}
		public String getDmz() {
			return Dmz;
		}
		public void setDmz(String dmz) {
			Dmz = dmz;
		}
		public String getDmmc1() {
			return Dmmc1;
		}
		public void setDmmc1(String dmmc1) {
			Dmmc1 = dmmc1;
		}
		public String getDmmc2() {
			return Dmmc2;
		}
		public void setDmmc2(String dmmc2) {
			Dmmc2 = dmmc2;
		}
		public String getDmmc3() {
			return Dmmc3;
		}
		public void setDmmc3(String dmmc3) {
			Dmmc3 = dmmc3;
		}
		public String getDmmc4() {
			return Dmmc4;
		}
		public void setDmmc4(String dmmc4) {
			Dmmc4 = dmmc4;
		}
		public String getZt() {
			return Zt;
		}
		public void setZt(String zt) {
			Zt = zt;
		}
		
		
	
}
