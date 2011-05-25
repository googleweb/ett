package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class DrivingLicenseModel extends BaseModel {

	 public static enum F { 
		  Xh,Dabh,Sfzmmc,Sfzmhm,Hmcd,Xm,Xb,Csrq,Gj,Djzsxzqh,Djzsxxdz,
		Lxzsxzqh,Lxzsxxdz,Lxzsyzbm,Lxdh,Sjhm,Dzyx,Zzzm,Zzfzjg,Zzfzrq,Sfbd,
		Zjcx,Yzjcx,Qfrq,Syrq,Cclzrq,Ccfzjg,Jzqx,Yxqs,Yxqz,Ljjf,
		Cfrq,Xxtzrq,Bzcs,Zt,Ly,Jxmc,Jly,Xzqh,Xzqj,Fzrq,
		Jbr,Glbm,Fzjg,Gxsj,Lsh,Xgzl,Bz,Jyw,Ydabh,Sqdm,
		Zxbh  
		 } 

		private String Xh;         //XH  CHAR 15
		private String Dabh;         //DABH  CHAR 12
		private String Sfzmmc;         //SFZMMC  CHAR 1
		private String Sfzmhm;         //SFZMHM  VARCHAR2 18
		private String Hmcd;         //HMCD  CHAR 1
		private String Xm;         //XM  VARCHAR2 30
		private String Xb;         //XB  CHAR 5
		private Date Csrq;         //CSRQ  DATE 0
		private String Gj;         //GJ  CHAR 10
		private String Djzsxzqh;         //DJZSXZQH  VARCHAR2 10
		private String Djzsxxdz;         //DJZSXXDZ  VARCHAR2 128
		private String Lxzsxzqh;         //LXZSXZQH  VARCHAR2 10
		private String Lxzsxxdz;         //LXZSXXDZ  VARCHAR2 128
		private String Lxzsyzbm;         //LXZSYZBM  VARCHAR2 6
		private String Lxdh;         //LXDH  VARCHAR2 20
		private String Sjhm;         //SJHM  VARCHAR2 20
		private String Dzyx;         //DZYX  VARCHAR2 30
		private String Zzzm;         //ZZZM  VARCHAR2 18
		private String Zzfzjg;         //ZZFZJG  VARCHAR2 30
		private Date Zzfzrq;         //ZZFZRQ  DATE 0
		private String Sfbd;         //SFBD  CHAR 1
		private String Zjcx;         //ZJCX  VARCHAR2 15
		private String Yzjcx;         //YZJCX  VARCHAR2 30
		private Date Qfrq;         //QFRQ  DATE 0
		private Date Syrq;         //SYRQ  DATE 0
		private Date Cclzrq;         //CCLZRQ  DATE 0
		private String Ccfzjg;         //CCFZJG  VARCHAR2 10
		private String Jzqx;         //JZQX  CHAR 1
		private Date Yxqs;         //YXQS  DATE 0
		private Date Yxqz;         //YXQZ  DATE 0
		private Integer Ljjf;         //LJJF  NUMBER 3
		private Date Cfrq;         //CFRQ  DATE 0
		private Date Xxtzrq;         //XXTZRQ  DATE 0
		private Integer Bzcs;         //BZCS  NUMBER 2
		private String Zt;         //ZT  VARCHAR2 6
		private String Ly;         //LY  CHAR 2
		private String Jxmc;         //JXMC  VARCHAR2 64
		private String Jly;         //JLY  VARCHAR2 30
		private String Xzqh;         //XZQH  VARCHAR2 10
		private String Xzqj;         //XZQJ  VARCHAR2 10
		private Date Fzrq;         //FZRQ  DATE 0
		private String Jbr;         //JBR  VARCHAR2 30
		private String Glbm;         //GLBM  VARCHAR2 12
		private String Fzjg;         //FZJG  VARCHAR2 10
		private Date Gxsj;         //GXSJ  DATE 0
		private String Lsh;         //LSH  CHAR 11
		private String Xgzl;         //XGZL  VARCHAR2 15
		private String Bz;         //BZ  VARCHAR2 256
		private String Jyw;         //JYW  VARCHAR2 256
		private String Ydabh;         //YDABH  CHAR 12
		private String Sqdm;         //SQDM  VARCHAR2 12
		private String Zxbh;         //ZXBH  CHAR 13
		public String getXh() {
			return Xh;
		}
		public void setXh(String xh) {
			Xh = xh;
		}
		public String getDabh() {
			return Dabh;
		}
		public void setDabh(String dabh) {
			Dabh = dabh;
		}
		public String getSfzmmc() {
			return Sfzmmc;
		}
		public void setSfzmmc(String sfzmmc) {
			Sfzmmc = sfzmmc;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getHmcd() {
			return Hmcd;
		}
		public void setHmcd(String hmcd) {
			Hmcd = hmcd;
		}
		public String getXm() {
			return Xm;
		}
		public void setXm(String xm) {
			Xm = xm;
		}
		public String getXb() {
			return Xb;
		}
		public void setXb(String xb) {
			Xb = xb;
		}
		public Date getCsrq() {
			return Csrq;
		}
		public void setCsrq(Date csrq) {
			Csrq = csrq;
		}
		public String getGj() {
			return Gj;
		}
		public void setGj(String gj) {
			Gj = gj;
		}
		public String getDjzsxzqh() {
			return Djzsxzqh;
		}
		public void setDjzsxzqh(String djzsxzqh) {
			Djzsxzqh = djzsxzqh;
		}
		public String getDjzsxxdz() {
			return Djzsxxdz;
		}
		public void setDjzsxxdz(String djzsxxdz) {
			Djzsxxdz = djzsxxdz;
		}
		public String getLxzsxzqh() {
			return Lxzsxzqh;
		}
		public void setLxzsxzqh(String lxzsxzqh) {
			Lxzsxzqh = lxzsxzqh;
		}
		public String getLxzsxxdz() {
			return Lxzsxxdz;
		}
		public void setLxzsxxdz(String lxzsxxdz) {
			Lxzsxxdz = lxzsxxdz;
		}
		public String getLxzsyzbm() {
			return Lxzsyzbm;
		}
		public void setLxzsyzbm(String lxzsyzbm) {
			Lxzsyzbm = lxzsyzbm;
		}
		public String getLxdh() {
			return Lxdh;
		}
		public void setLxdh(String lxdh) {
			Lxdh = lxdh;
		}
		public String getSjhm() {
			return Sjhm;
		}
		public void setSjhm(String sjhm) {
			Sjhm = sjhm;
		}
		public String getDzyx() {
			return Dzyx;
		}
		public void setDzyx(String dzyx) {
			Dzyx = dzyx;
		}
		public String getZzzm() {
			return Zzzm;
		}
		public void setZzzm(String zzzm) {
			Zzzm = zzzm;
		}
		public String getZzfzjg() {
			return Zzfzjg;
		}
		public void setZzfzjg(String zzfzjg) {
			Zzfzjg = zzfzjg;
		}
		public Date getZzfzrq() {
			return Zzfzrq;
		}
		public void setZzfzrq(Date zzfzrq) {
			Zzfzrq = zzfzrq;
		}
		public String getSfbd() {
			return Sfbd;
		}
		public void setSfbd(String sfbd) {
			Sfbd = sfbd;
		}
		public String getZjcx() {
			return Zjcx;
		}
		public void setZjcx(String zjcx) {
			Zjcx = zjcx;
		}
		public String getYzjcx() {
			return Yzjcx;
		}
		public void setYzjcx(String yzjcx) {
			Yzjcx = yzjcx;
		}
		public Date getQfrq() {
			return Qfrq;
		}
		public void setQfrq(Date qfrq) {
			Qfrq = qfrq;
		}
		public Date getSyrq() {
			return Syrq;
		}
		public void setSyrq(Date syrq) {
			Syrq = syrq;
		}
		public Date getCclzrq() {
			return Cclzrq;
		}
		public void setCclzrq(Date cclzrq) {
			Cclzrq = cclzrq;
		}
		public String getCcfzjg() {
			return Ccfzjg;
		}
		public void setCcfzjg(String ccfzjg) {
			Ccfzjg = ccfzjg;
		}
		public String getJzqx() {
			return Jzqx;
		}
		public void setJzqx(String jzqx) {
			Jzqx = jzqx;
		}
		public Date getYxqs() {
			return Yxqs;
		}
		public void setYxqs(Date yxqs) {
			Yxqs = yxqs;
		}
		public Date getYxqz() {
			return Yxqz;
		}
		public void setYxqz(Date yxqz) {
			Yxqz = yxqz;
		}
		public Integer getLjjf() {
			return Ljjf;
		}
		public void setLjjf(Integer ljjf) {
			Ljjf = ljjf;
		}
		public Date getCfrq() {
			return Cfrq;
		}
		public void setCfrq(Date cfrq) {
			Cfrq = cfrq;
		}
		public Date getXxtzrq() {
			return Xxtzrq;
		}
		public void setXxtzrq(Date xxtzrq) {
			Xxtzrq = xxtzrq;
		}
		public Integer getBzcs() {
			return Bzcs;
		}
		public void setBzcs(Integer bzcs) {
			Bzcs = bzcs;
		}
		public String getZt() {
			return Zt;
		}
		public void setZt(String zt) {
			Zt = zt;
		}
		public String getLy() {
			return Ly;
		}
		public void setLy(String ly) {
			Ly = ly;
		}
		public String getJxmc() {
			return Jxmc;
		}
		public void setJxmc(String jxmc) {
			Jxmc = jxmc;
		}
		public String getJly() {
			return Jly;
		}
		public void setJly(String jly) {
			Jly = jly;
		}
		public String getXzqh() {
			return Xzqh;
		}
		public void setXzqh(String xzqh) {
			Xzqh = xzqh;
		}
		public String getXzqj() {
			return Xzqj;
		}
		public void setXzqj(String xzqj) {
			Xzqj = xzqj;
		}
		public Date getFzrq() {
			return Fzrq;
		}
		public void setFzrq(Date fzrq) {
			Fzrq = fzrq;
		}
		public String getJbr() {
			return Jbr;
		}
		public void setJbr(String jbr) {
			Jbr = jbr;
		}
		public String getGlbm() {
			return Glbm;
		}
		public void setGlbm(String glbm) {
			Glbm = glbm;
		}
		public String getFzjg() {
			return Fzjg;
		}
		public void setFzjg(String fzjg) {
			Fzjg = fzjg;
		}
		public Date getGxsj() {
			return Gxsj;
		}
		public void setGxsj(Date gxsj) {
			Gxsj = gxsj;
		}
		public String getLsh() {
			return Lsh;
		}
		public void setLsh(String lsh) {
			Lsh = lsh;
		}
		public String getXgzl() {
			return Xgzl;
		}
		public void setXgzl(String xgzl) {
			Xgzl = xgzl;
		}
		public String getBz() {
			return Bz;
		}
		public void setBz(String bz) {
			Bz = bz;
		}
		public String getJyw() {
			return Jyw;
		}
		public void setJyw(String jyw) {
			Jyw = jyw;
		}
		public String getYdabh() {
			return Ydabh;
		}
		public void setYdabh(String ydabh) {
			Ydabh = ydabh;
		}
		public String getSqdm() {
			return Sqdm;
		}
		public void setSqdm(String sqdm) {
			Sqdm = sqdm;
		}
		public String getZxbh() {
			return Zxbh;
		}
		public void setZxbh(String zxbh) {
			Zxbh = zxbh;
		}
		
		
		
	
}
