package com.ett.drv.model.booked;

import com.smartken.kia.core.model.impl.BaseModel;

public class BookedDayLimitModel extends BaseModel {

	 public static enum F { 
		  Id,CCartype,IDays,IKm  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CCartype;         //C_CARTYPE  VARCHAR2 30
		private Integer IDays;         //I_DAYS  NUMBER 38
		private Integer IKm;         //I_KM  NUMBER 38
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCCartype() {
			return CCartype;
		}
		public void setCCartype(String cCartype) {
			CCartype = cCartype;
		}
		public Integer getIDays() {
			return IDays;
		}
		public void setIDays(Integer iDays) {
			IDays = iDays;
		}
		public Integer getIKm() {
			return IKm;
		}
		public void setIKm(Integer iKm) {
			IKm = iKm;
		}
		
	
		

}
