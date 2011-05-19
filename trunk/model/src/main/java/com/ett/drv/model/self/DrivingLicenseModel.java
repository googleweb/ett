package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class DrivingLicenseModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static enum F{
		xh,dabh,sfzmmc,sfzmhm,hmcd,xm,xb,csrq,gj,djzsxzqh,djzsxxdz,
		lxzsxzqh,lxzsxxdz,lxzsyzbm,lxdh,sjhm,dzyx,zzzm,zzfzjg,zzfzrq,sfbd,
		zjcx,yzjcx,qfrq,syrq,cclzrq,ccfzjg,jzqx,yxqs,yxqz,ljjf,
		cfrq,xxtzrq,bzcs,zt,ly,jxmc,jly,xzqh,xzqj,fzrq,
		jbr,glbm,fzjg,gxsj,lsh,xgzl,bz,jyw,ydabh,sqdm,
		zxbh
	}
	

	 private String xh;         //XH  CHAR 15
	 private String dabh;         //DABH  CHAR 12
	 private String sfzmmc;         //SFZMMC  CHAR 1
	 private String sfzmhm;         //SFZMHM  VARCHAR2 18
	 private String hmcd;         //HMCD  CHAR 1
	 private String xm;         //XM  VARCHAR2 30
	 private String xb;         //XB  CHAR 5
	 private Date csrq;         //CSRQ  DATE 0
	 private String gj;         //GJ  CHAR 3
	 private String djzsxzqh;         //DJZSXZQH  VARCHAR2 10
	 private String djzsxxdz;         //DJZSXXDZ  VARCHAR2 128
	 private String lxzsxzqh;         //LXZSXZQH  VARCHAR2 10
	 private String lxzsxxdz;         //LXZSXXDZ  VARCHAR2 128
	 private String lxzsyzbm;         //LXZSYZBM  VARCHAR2 6
	 private String lxdh;         //LXDH  VARCHAR2 20
	 private String sjhm;         //SJHM  VARCHAR2 20
	 private String dzyx;         //DZYX  VARCHAR2 30
	 private String zzzm;         //ZZZM  VARCHAR2 18
	 private String zzfzjg;         //ZZFZJG  VARCHAR2 30
	 private Date zzfzrq;         //ZZFZRQ  DATE 0
	 private String sfbd;         //SFBD  CHAR 1
	 private String zjcx;         //ZJCX  VARCHAR2 15
	 private String yzjcx;         //YZJCX  VARCHAR2 30
	 private Date qfrq;         //QFRQ  DATE 0
	 private Date syrq;         //SYRQ  DATE 0
	 private Date cclzrq;         //CCLZRQ  DATE 0
	 private String ccfzjg;         //CCFZJG  VARCHAR2 10
	 private String jzqx;         //JZQX  CHAR 1
	 private Date yxqs;         //YXQS  DATE 0
	 private Date yxqz;         //YXQZ  DATE 0
	 private Integer ljjf;         //LJJF  NUMBER 3
	 private Date cfrq;         //CFRQ  DATE 0
	 private Date xxtzrq;         //XXTZRQ  DATE 0
	 private Integer bzcs;         //BZCS  NUMBER 2
	 private String zt;         //ZT  VARCHAR2 6
	 private String ly;         //LY  CHAR 2
	 private String jxmc;         //JXMC  VARCHAR2 64
	 private String jly;         //JLY  VARCHAR2 30
	 private String xzqh;         //XZQH  VARCHAR2 10
	 private String xzqj;         //XZQJ  VARCHAR2 10
	 private Date fzrq;         //FZRQ  DATE 0
	 private String jbr;         //JBR  VARCHAR2 30
	 private String glbm;         //GLBM  VARCHAR2 12
	 private String fzjg;         //FZJG  VARCHAR2 10
	 private Date gxsj;         //GXSJ  DATE 0
	 private String lsh;         //LSH  CHAR 11
	 private String xgzl;         //XGZL  VARCHAR2 15
	 private String bz;         //BZ  VARCHAR2 256
	 private String jyw;         //JYW  VARCHAR2 256
	 private String ydabh;         //YDABH  CHAR 12
	 private String sqdm;         //SQDM  VARCHAR2 12
	 private String zxbh;         //ZXBH  CHAR 13
	 
	 
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	public String getZjcx() {
		return zjcx;
	}
	public void setZjcx(String zjcx) {
		this.zjcx = zjcx;
	}
	public String getYzjcx() {
		return yzjcx;
	}
	public void setYzjcx(String yzjcx) {
		this.yzjcx = yzjcx;
	}
	public Date getQfrq() {
		return qfrq;
	}
	public void setQfrq(Date qfrq) {
		this.qfrq = qfrq;
	}
	public Date getSyrq() {
		return syrq;
	}
	public void setSyrq(Date syrq) {
		this.syrq = syrq;
	}
	public Date getCclzrq() {
		return cclzrq;
	}
	public void setCclzrq(Date cclzrq) {
		this.cclzrq = cclzrq;
	}
	public String getCcfzjg() {
		return ccfzjg;
	}
	public void setCcfzjg(String ccfzjg) {
		this.ccfzjg = ccfzjg;
	}
	public String getJzqx() {
		return jzqx;
	}
	public void setJzqx(String jzqx) {
		this.jzqx = jzqx;
	}
	public Date getYxqs() {
		return yxqs;
	}
	public void setYxqs(Date yxqs) {
		this.yxqs = yxqs;
	}
	public Date getYxqz() {
		return yxqz;
	}
	public void setYxqz(Date yxqz) {
		this.yxqz = yxqz;
	}
	public Integer getLjjf() {
		return ljjf;
	}
	public void setLjjf(Integer ljjf) {
		this.ljjf = ljjf;
	}
	public Date getCfrq() {
		return cfrq;
	}
	public void setCfrq(Date cfrq) {
		this.cfrq = cfrq;
	}
	public Date getXxtzrq() {
		return xxtzrq;
	}
	public void setXxtzrq(Date xxtzrq) {
		this.xxtzrq = xxtzrq;
	}
	public Integer getBzcs() {
		return bzcs;
	}
	public void setBzcs(Integer bzcs) {
		this.bzcs = bzcs;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getLy() {
		return ly;
	}
	public void setLy(String ly) {
		this.ly = ly;
	}
	public String getJxmc() {
		return jxmc;
	}
	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}
	public String getJly() {
		return jly;
	}
	public void setJly(String jly) {
		this.jly = jly;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getXzqj() {
		return xzqj;
	}
	public void setXzqj(String xzqj) {
		this.xzqj = xzqj;
	}
	public Date getFzrq() {
		return fzrq;
	}
	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public Date getGxsj() {
		return gxsj;
	}
	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getXgzl() {
		return xgzl;
	}
	public void setXgzl(String xgzl) {
		this.xgzl = xgzl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJyw() {
		return jyw;
	}
	public void setJyw(String jyw) {
		this.jyw = jyw;
	}
	public String getYdabh() {
		return ydabh;
	}
	public void setYdabh(String ydabh) {
		this.ydabh = ydabh;
	}
	public String getSqdm() {
		return sqdm;
	}
	public void setSqdm(String sqdm) {
		this.sqdm = sqdm;
	}
	public String getZxbh() {
		return zxbh;
	}
	public void setZxbh(String zxbh) {
		this.zxbh = zxbh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
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
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getDzyx() {
		return dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public String getZzzm() {
		return zzzm;
	}
	public void setZzzm(String zzzm) {
		this.zzzm = zzzm;
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
	public String getSfbd() {
		return sfbd;
	}
	public void setSfbd(String sfbd) {
		this.sfbd = sfbd;
	}

	
	
}
