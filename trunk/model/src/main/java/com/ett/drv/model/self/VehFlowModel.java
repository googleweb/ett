package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class VehFlowModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static enum F{
		lsh,xh,ywlx,ywyy,syr,clsbdh,hpzl,hphm,clpp1,clxh,cllx,
		xzqh,sqrq,bjrq,xygw,ywlc,lszt,glbm,fpbj,ffbj,rkbj
	}
	

	private String lsh;         //LSH  CHAR 11
	private String xh;         //XH  CHAR 14
	private String ywlx;         //YWLX  CHAR 1
	private String ywyy;         //YWYY  VARCHAR2 8
	private String syr;         //SYR  VARCHAR2 64
	private String clsbdh;         //CLSBDH  VARCHAR2 25
	private String hpzl;         //HPZL  CHAR 2
	private String hphm;         //HPHM  VARCHAR2 15
	private String clpp1;         //CLPP1  VARCHAR2 32
	private String clxh;         //CLXH  VARCHAR2 32
	private String cllx;         //CLLX  CHAR 3
	private String xzqh;         //XZQH  VARCHAR2 10
	private Date sqrq;         //SQRQ  DATE 0
	private Date bjrq;         //BJRQ  DATE 0
	private String xygw;         //XYGW  CHAR 1
	private String ywlc;         //YWLC  VARCHAR2 10
	private String lszt;         //LSZT  CHAR 1
	private String glbm;         //GLBM  VARCHAR2 10
	private String fpbj;         //FPBJ  CHAR 1
	private String ffbj;         //FFBJ  CHAR 1
	private String rkbj;         //RKBJ  CHAR 1
	
	
	public void from(VehicleModel vhModel){
		this.setXh(vhModel.getXh());
	}
	
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public String getYwyy() {
		return ywyy;
	}
	public void setYwyy(String ywyy) {
		this.ywyy = ywyy;
	}
	public String getSyr() {
		return syr;
	}
	public void setSyr(String syr) {
		this.syr = syr;
	}
	public String getClsbdh() {
		return clsbdh;
	}
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getClpp1() {
		return clpp1;
	}
	public void setClpp1(String clpp1) {
		this.clpp1 = clpp1;
	}
	public String getClxh() {
		return clxh;
	}
	public void setClxh(String clxh) {
		this.clxh = clxh;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public Date getSqrq() {
		return sqrq;
	}
	public void setSqrq(Date sqrq) {
		this.sqrq = sqrq;
	}
	public Date getBjrq() {
		return bjrq;
	}
	public void setBjrq(Date bjrq) {
		this.bjrq = bjrq;
	}
	public String getXygw() {
		return xygw;
	}
	public void setXygw(String xygw) {
		this.xygw = xygw;
	}
	public String getYwlc() {
		return ywlc;
	}
	public void setYwlc(String ywlc) {
		this.ywlc = ywlc;
	}
	public String getLszt() {
		return lszt;
	}
	public void setLszt(String lszt) {
		this.lszt = lszt;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getFpbj() {
		return fpbj;
	}
	public void setFpbj(String fpbj) {
		this.fpbj = fpbj;
	}
	public String getFfbj() {
		return ffbj;
	}
	public void setFfbj(String ffbj) {
		this.ffbj = ffbj;
	}
	public String getRkbj() {
		return rkbj;
	}
	public void setRkbj(String rkbj) {
		this.rkbj = rkbj;
	}

	
	
}
