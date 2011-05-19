package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class DrvFlowModel extends BaseFlowModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void from(DrivingLicenseModel drvlModel){
		this.setXm(drvlModel.getXm());
		this.setDabh(drvlModel.getDabh());
		this.setSfzmhm(drvlModel.getSfzmhm());
	}

	public static enum F{
		lsh,sfzmhm,dabh,xm,ywlx,ywyy,kssj,jssj,ywgw,kskm,xygw,
		glbm,ffbz,rkbz,hdbz,xgzl,zjcx
	}
	

	private String lsh;         //LSH  VARCHAR2 32
	private String sfzmhm;         //SFZMHM  VARCHAR2 18
	private String dabh;         //DABH  VARCHAR2 32
	private String xm;         //XM  VARCHAR2 32
	private String ywlx;         //YWLX  VARCHAR2 32
	private String ywyy;         //YWYY  VARCHAR2 32
	private Date kssj;         //KSSJ  DATE 0
	private String jssj;         //JSSJ  VARCHAR2 32
	private String ywgw;         //YWGW  VARCHAR2 32
	private String kskm;         //KSKM  VARCHAR2 32
	private String xygw;         //XYGW  VARCHAR2 32
	private String glbm;         //GLBM  VARCHAR2 32
	private String ffbz;         //FFBZ  VARCHAR2 32
	private String rkbz;         //RKBZ  VARCHAR2 32
	private String hdbz;         //HDBZ  VARCHAR2 32
	private String xgzl;         //XGZL  VARCHAR2 32
	private String zjcx;
	
	
	public String getLsh() {
		return lsh;
	}


	public void setLsh(String lsh) {
		this.lsh = lsh;
	}


	public String getSfzmhm() {
		return sfzmhm;
	}


	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}


	public String getDabh() {
		return dabh;
	}


	public void setDabh(String dabh) {
		this.dabh = dabh;
	}


	public String getXm() {
		return xm;
	}


	public void setXm(String xm) {
		this.xm = xm;
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


	public Date getKssj() {
		return kssj;
	}


	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}


	public String getJssj() {
		return jssj;
	}


	public void setJssj(String jssj) {
		this.jssj = jssj;
	}


	public String getYwgw() {
		return ywgw;
	}


	public void setYwgw(String ywgw) {
		this.ywgw = ywgw;
	}


	public String getKskm() {
		return kskm;
	}


	public void setKskm(String kskm) {
		this.kskm = kskm;
	}


	public String getXygw() {
		return xygw;
	}


	public void setXygw(String xygw) {
		this.xygw = xygw;
	}


	public String getGlbm() {
		return glbm;
	}


	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}


	public String getFfbz() {
		return ffbz;
	}


	public void setFfbz(String ffbz) {
		this.ffbz = ffbz;
	}


	public String getRkbz() {
		return rkbz;
	}


	public void setRkbz(String rkbz) {
		this.rkbz = rkbz;
	}


	public String getHdbz() {
		return hdbz;
	}


	public void setHdbz(String hdbz) {
		this.hdbz = hdbz;
	}


	public String getXgzl() {
		return xgzl;
	}


	public void setXgzl(String xgzl) {
		this.xgzl = xgzl;
	}


	public String getZjcx() {
		return zjcx;
	}


	public void setZjcx(String zjcx) {
		this.zjcx = zjcx;
	}         //ZJCX  VARCHAR2 32
	
	
	
}
