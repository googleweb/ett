package com.ett.drv.model.dict;

import com.smartken.kia.core.model.impl.BaseModel;

public class VehCodeModel extends BaseModel {

	 public static enum F { 
		  Dmlb,Dmz,Dmsm1,Dmsm2,Dmsm3,Dmsm4  
		 } 

		private Integer Dmlb;         //DMLB  NUMBER 3
		private String Dmz;         //DMZ  VARCHAR2 10
		private String Dmsm1;         //DMSM1  VARCHAR2 64
		private String Dmsm2;         //DMSM2  VARCHAR2 64
		private String Dmsm3;         //DMSM3  VARCHAR2 64
		private String Dmsm4;         //DMSM4  VARCHAR2 64
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
		public String getDmsm1() {
			return Dmsm1;
		}
		public void setDmsm1(String dmsm1) {
			Dmsm1 = dmsm1;
		}
		public String getDmsm2() {
			return Dmsm2;
		}
		public void setDmsm2(String dmsm2) {
			Dmsm2 = dmsm2;
		}
		public String getDmsm3() {
			return Dmsm3;
		}
		public void setDmsm3(String dmsm3) {
			Dmsm3 = dmsm3;
		}
		public String getDmsm4() {
			return Dmsm4;
		}
		public void setDmsm4(String dmsm4) {
			Dmsm4 = dmsm4;
		}
		
		
		
}
