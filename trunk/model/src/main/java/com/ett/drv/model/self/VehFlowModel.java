package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class VehFlowModel extends BaseModel {

	public void from(VehicleModel vhModel){
		this.setXh(vhModel.getXh());
	}
	
	 public static enum F { 
		  Lsh,Xh,Ywlx,Ywyy,Syr,Clsbdh,Hpzl,Hphm,Clpp1,Clxh,Cllx,
		Xzqh,Sqrq,Bjrq,Xygw,Ywlc,Lszt,Glbm,Fpbj,Ffbj,Rkbj  
		 } 

		private String Lsh;         //LSH  VARCHAR2 32
		private String Xh;         //XH  CHAR 14
		private String Ywlx;         //YWLX  CHAR 1
		private String Ywyy;         //YWYY  VARCHAR2 8
		private String Syr;         //SYR  VARCHAR2 64
		private String Clsbdh;         //CLSBDH  VARCHAR2 25
		private String Hpzl;         //HPZL  CHAR 2
		private String Hphm;         //HPHM  VARCHAR2 15
		private String Clpp1;         //CLPP1  VARCHAR2 32
		private String Clxh;         //CLXH  VARCHAR2 32
		private String Cllx;         //CLLX  CHAR 3
		private String Xzqh;         //XZQH  VARCHAR2 10
		private Date Sqrq;         //SQRQ  DATE 0
		private Date Bjrq;         //BJRQ  DATE 0
		private String Xygw;         //XYGW  CHAR 1
		private String Ywlc;         //YWLC  VARCHAR2 10
		private String Lszt;         //LSZT  CHAR 1
		private String Glbm;         //GLBM  VARCHAR2 10
		private String Fpbj;         //FPBJ  CHAR 1
		private String Ffbj;         //FFBJ  CHAR 1
		private String Rkbj;         //RKBJ  CHAR 1
		public String getLsh() {
			return Lsh;
		}
		public void setLsh(String lsh) {
			Lsh = lsh;
		}
		public String getXh() {
			return Xh;
		}
		public void setXh(String xh) {
			Xh = xh;
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
		public String getSyr() {
			return Syr;
		}
		public void setSyr(String syr) {
			Syr = syr;
		}
		public String getClsbdh() {
			return Clsbdh;
		}
		public void setClsbdh(String clsbdh) {
			Clsbdh = clsbdh;
		}
		public String getHpzl() {
			return Hpzl;
		}
		public void setHpzl(String hpzl) {
			Hpzl = hpzl;
		}
		public String getHphm() {
			return Hphm;
		}
		public void setHphm(String hphm) {
			Hphm = hphm;
		}
		public String getClpp1() {
			return Clpp1;
		}
		public void setClpp1(String clpp1) {
			Clpp1 = clpp1;
		}
		public String getClxh() {
			return Clxh;
		}
		public void setClxh(String clxh) {
			Clxh = clxh;
		}
		public String getCllx() {
			return Cllx;
		}
		public void setCllx(String cllx) {
			Cllx = cllx;
		}
		public String getXzqh() {
			return Xzqh;
		}
		public void setXzqh(String xzqh) {
			Xzqh = xzqh;
		}
		public Date getSqrq() {
			return Sqrq;
		}
		public void setSqrq(Date sqrq) {
			Sqrq = sqrq;
		}
		public Date getBjrq() {
			return Bjrq;
		}
		public void setBjrq(Date bjrq) {
			Bjrq = bjrq;
		}
		public String getXygw() {
			return Xygw;
		}
		public void setXygw(String xygw) {
			Xygw = xygw;
		}
		public String getYwlc() {
			return Ywlc;
		}
		public void setYwlc(String ywlc) {
			Ywlc = ywlc;
		}
		public String getLszt() {
			return Lszt;
		}
		public void setLszt(String lszt) {
			Lszt = lszt;
		}
		public String getGlbm() {
			return Glbm;
		}
		public void setGlbm(String glbm) {
			Glbm = glbm;
		}
		public String getFpbj() {
			return Fpbj;
		}
		public void setFpbj(String fpbj) {
			Fpbj = fpbj;
		}
		public String getFfbj() {
			return Ffbj;
		}
		public void setFfbj(String ffbj) {
			Ffbj = ffbj;
		}
		public String getRkbj() {
			return Rkbj;
		}
		public void setRkbj(String rkbj) {
			Rkbj = rkbj;
		}
		
		
		
	
	
}
