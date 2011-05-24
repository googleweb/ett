package com.ett.drv.model.booked;

import com.smartken.kia.core.model.impl.BaseModel;

public class SchoolCarModel extends BaseModel{

	
	 public static enum F { 
		  Id,Clpp,Coachno,Depcode,Depname,Glbm,Hmhp,Idcard,Mobile,Name  
		 } 

		private Double Id;         //ID  NUMBER 19
		private String Clpp;         //CLPP  VARCHAR2 255
		private String Coachno;         //COACHNO  VARCHAR2 255
		private String Depcode;         //DEPCODE  VARCHAR2 255
		private String Depname;         //DEPNAME  VARCHAR2 255
		private String Glbm;         //GLBM  VARCHAR2 255
		private String Hmhp;         //HMHP  VARCHAR2 255
		private String Idcard;         //IDCARD  VARCHAR2 255
		private String Mobile;         //MOBILE  VARCHAR2 255
		private String Name;         //NAME  VARCHAR2 255	
		public Double getId() {
			return Id;
		}
		public void setId(Double id) {
			Id = id;
		}
		public String getClpp() {
			return Clpp;
		}
		public void setClpp(String clpp) {
			Clpp = clpp;
		}
		public String getCoachno() {
			return Coachno;
		}
		public void setCoachno(String coachno) {
			Coachno = coachno;
		}
		public String getDepcode() {
			return Depcode;
		}
		public void setDepcode(String depcode) {
			Depcode = depcode;
		}
		public String getDepname() {
			return Depname;
		}
		public void setDepname(String depname) {
			Depname = depname;
		}
		public String getGlbm() {
			return Glbm;
		}
		public void setGlbm(String glbm) {
			Glbm = glbm;
		}
		public String getHmhp() {
			return Hmhp;
		}
		public void setHmhp(String hmhp) {
			Hmhp = hmhp;
		}
		public String getIdcard() {
			return Idcard;
		}
		public void setIdcard(String idcard) {
			Idcard = idcard;
		}
		public String getMobile() {
			return Mobile;
		}
		public void setMobile(String mobile) {
			Mobile = mobile;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		
		
		
		

}
