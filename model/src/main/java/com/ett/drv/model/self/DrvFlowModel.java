package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class DrvFlowModel extends BaseFlowModel {

	public void from(DrivingLicenseModel drvlModel){
		this.setXm(drvlModel.getXm());
		this.setDabh(drvlModel.getDabh());
		this.setSfzmhm(drvlModel.getSfzmhm());
	}
	
	
	 public static enum F { 
		  Lsh,Sfzmhm,Dabh,Xm,Ywlx,Ywyy,Kssj,Jssj,Ywgw,Kskm,Xygw,
		Glbm,Ffbz,Rkbz,Hdbz,Xgzl,Zjcx  
		 } 

		private String Lsh;         //LSH  VARCHAR2 32
		private String Sfzmhm;         //SFZMHM  VARCHAR2 18
		private String Dabh;         //DABH  VARCHAR2 32
		private String Xm;         //XM  VARCHAR2 32
		private String Ywlx;         //YWLX  VARCHAR2 32
		private String Ywyy;         //YWYY  VARCHAR2 32
		private Date Kssj;         //KSSJ  DATE 0
		private Date Jssj;         //JSSJ  DATE 0
		private String Ywgw;         //YWGW  VARCHAR2 32
		private String Kskm;         //KSKM  VARCHAR2 32
		private String Xygw;         //XYGW  VARCHAR2 32
		private String Glbm;         //GLBM  VARCHAR2 32
		private String Ffbz;         //FFBZ  VARCHAR2 32
		private String Rkbz;         //RKBZ  VARCHAR2 32
		private String Hdbz;         //HDBZ  VARCHAR2 32
		private String Xgzl;         //XGZL  VARCHAR2 32
		private String Zjcx;         //ZJCX  VARCHAR2 32
		public String getLsh() {
			return Lsh;
		}
		public void setLsh(String lsh) {
			Lsh = lsh;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getDabh() {
			return Dabh;
		}
		public void setDabh(String dabh) {
			Dabh = dabh;
		}
		public String getXm() {
			return Xm;
		}
		public void setXm(String xm) {
			Xm = xm;
		}
		public String getYwlx() {
			return Ywlx;
		}
		public void setYwlx(String ywlx) {
			Ywlx = ywlx;
		}
		public String getYwyy() {
			return Ywyy;
		}
		public void setYwyy(String ywyy) {
			Ywyy = ywyy;
		}
		public Date getKssj() {
			return Kssj;
		}
		public void setKssj(Date kssj) {
			Kssj = kssj;
		}
		public Date getJssj() {
			return Jssj;
		}
		public void setJssj(Date jssj) {
			Jssj = jssj;
		}
		public String getYwgw() {
			return Ywgw;
		}
		public void setYwgw(String ywgw) {
			Ywgw = ywgw;
		}
		public String getKskm() {
			return Kskm;
		}
		public void setKskm(String kskm) {
			Kskm = kskm;
		}
		public String getXygw() {
			return Xygw;
		}
		public void setXygw(String xygw) {
			Xygw = xygw;
		}
		public String getGlbm() {
			return Glbm;
		}
		public void setGlbm(String glbm) {
			Glbm = glbm;
		}
		public String getFfbz() {
			return Ffbz;
		}
		public void setFfbz(String ffbz) {
			Ffbz = ffbz;
		}
		public String getRkbz() {
			return Rkbz;
		}
		public void setRkbz(String rkbz) {
			Rkbz = rkbz;
		}
		public String getHdbz() {
			return Hdbz;
		}
		public void setHdbz(String hdbz) {
			Hdbz = hdbz;
		}
		public String getXgzl() {
			return Xgzl;
		}
		public void setXgzl(String xgzl) {
			Xgzl = xgzl;
		}
		public String getZjcx() {
			return Zjcx;
		}
		public void setZjcx(String zjcx) {
			Zjcx = zjcx;
		}
		
		
	
}
