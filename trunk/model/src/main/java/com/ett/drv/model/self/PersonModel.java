package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class PersonModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static enum F{
		sfzmhm,sfzmmc,hmcd,xm,xb,csrq,gj,djzsxzqh,djzsxxdz,djzsyzbm,lxzsxzqh,
		lxzsxxdz,lxzsyzbm,lxdh,zzzm,zzsxzqh,zzsxxdz,zzsyzbm,gxsj,sfbd,zzfzjg,
		zzfzrq
	}
	

	private String sfzmhm;         //SFZMHM  CHAR 18
	private String sfzmmc;         //SFZMMC  CHAR 1
	private String hmcd;         //HMCD  CHAR 1
	private String xm;         //XM  VARCHAR2 30
	private String xb;         //XB  CHAR 1
	private Date csrq;         //CSRQ  DATE 0
	private String gj;         //GJ  CHAR 3
	private String djzsxzqh;         //DJZSXZQH  VARCHAR2 10
	private String djzsxxdz;         //DJZSXXDZ  VARCHAR2 128
	private String djzsyzbm;         //DJZSYZBM  VARCHAR2 6
	private String lxzsxzqh;         //LXZSXZQH  VARCHAR2 10
	private String lxzsxxdz;         //LXZSXXDZ  VARCHAR2 128
	private String lxzsyzbm;         //LXZSYZBM  VARCHAR2 6
	private String lxdh;         //LXDH  VARCHAR2 20
	private String zzzm;         //ZZZM  VARCHAR2 18
	private String zzsxzqh;         //ZZSXZQH  VARCHAR2 10
	private String zzsxxdz;         //ZZSXXDZ  VARCHAR2 128
	private String zzsyzbm;         //ZZSYZBM  VARCHAR2 6
	private Date gxsj;         //GXSJ  DATE 0
	private String sfbd;         //SFBD  CHAR 1
	private String zzfzjg;         //ZZFZJG  VARCHAR2 30
	private Date zzfzrq;         //ZZFZRQ  DATE 0
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	public String getSfzmmc() {
		return sfzmmc;
	}
	public void setSfzmmc(String sfzmmc) {
		this.sfzmmc = sfzmmc;
	}
	public String getHmcd() {
		return hmcd;
	}
	public void setHmcd(String hmcd) {
		this.hmcd = hmcd;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getDjzsxzqh() {
		return djzsxzqh;
	}
	public void setDjzsxzqh(String djzsxzqh) {
		this.djzsxzqh = djzsxzqh;
	}
	public String getDjzsxxdz() {
		return djzsxxdz;
	}
	public void setDjzsxxdz(String djzsxxdz) {
		this.djzsxxdz = djzsxxdz;
	}
	public String getDjzsyzbm() {
		return djzsyzbm;
	}
	public void setDjzsyzbm(String djzsyzbm) {
		this.djzsyzbm = djzsyzbm;
	}
	public String getLxzsxzqh() {
		return lxzsxzqh;
	}
	public void setLxzsxzqh(String lxzsxzqh) {
		this.lxzsxzqh = lxzsxzqh;
	}
	public String getLxzsxxdz() {
		return lxzsxxdz;
	}
	public void setLxzsxxdz(String lxzsxxdz) {
		this.lxzsxxdz = lxzsxxdz;
	}
	public String getLxzsyzbm() {
		return lxzsyzbm;
	}
	public void setLxzsyzbm(String lxzsyzbm) {
		this.lxzsyzbm = lxzsyzbm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZzzm() {
		return zzzm;
	}
	public void setZzzm(String zzzm) {
		this.zzzm = zzzm;
	}
	public String getZzsxzqh() {
		return zzsxzqh;
	}
	public void setZzsxzqh(String zzsxzqh) {
		this.zzsxzqh = zzsxzqh;
	}
	public String getZzsxxdz() {
		return zzsxxdz;
	}
	public void setZzsxxdz(String zzsxxdz) {
		this.zzsxxdz = zzsxxdz;
	}
	public String getZzsyzbm() {
		return zzsyzbm;
	}
	public void setZzsyzbm(String zzsyzbm) {
		this.zzsyzbm = zzsyzbm;
	}
	public Date getGxsj() {
		return gxsj;
	}
	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}
	public String getSfbd() {
		return sfbd;
	}
	public void setSfbd(String sfbd) {
		this.sfbd = sfbd;
	}
	public String getZzfzjg() {
		return zzfzjg;
	}
	public void setZzfzjg(String zzfzjg) {
		this.zzfzjg = zzfzjg;
	}
	public Date getZzfzrq() {
		return zzfzrq;
	}
	public void setZzfzrq(Date zzfzrq) {
		this.zzfzrq = zzfzrq;
	}
	
	
	
}
