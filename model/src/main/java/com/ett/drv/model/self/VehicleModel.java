package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class VehicleModel extends BaseModel {


	 public static enum F { 
		  Xh,Hpzl,Hphm,Clpp1,Clxh,Clpp2,Gcjk,Zzg,Zzcmc,Clsbdh,Fdjh,
		Cllx,Csys,Syxz,Sfzmhm,Sfzmmc,Syr,Zsxzqh,Zsxxdz,Yzbm1,Lxdh,
		Zzz,Zzxzqh,Zzxxdz,Yzbm2,Syq,Ccdjrq,Djrq,Yxqz,Qzbfqz,Fzjg,
		Glbm,Fprq,Fzrq,Fdjrq,Fhgzrq,Bxzzrq,Bpcs,Bzcs,Bdjcs,Djzsbh,
		Zdjzshs,Dabh,Xzqh,Zt,Zdyzt,Dybj,Jbr,Clly,Lsh,Fdjxh,
		Rlzl,Pl,Gl,Zxxs,Cwkc,Cwkk,Cwkg,Hxnbcd,Hxnbkd,Hxnbgd,
		Gbthps,Zs,Zj,Qlj,Hlj,Ltgg,Lts,Zzl,Zbzl,Hdzzl,
		Hdzk,Zqyzl,Qpzk,Hpzk,Hbdbqk,Ccrq,Hdfs,Llpz1,Pzbh1,Llpz2,
		Pzbh2,Xsdw,Xsjg,Xsrq,Jkpz,Jkpzhm,Hgzbh,Nszm,Nszmbh,Gxrq,
		Xgzl,Qmbh,Hmbh,Bz,Jyw,Yxh  
		 } 

		private String Xh;         //XH  CHAR 14
		private String Hpzl;         //HPZL  VARCHAR2 10
		private String Hphm;         //HPHM  VARCHAR2 15
		private String Clpp1;         //CLPP1  VARCHAR2 32
		private String Clxh;         //CLXH  VARCHAR2 32
		private String Clpp2;         //CLPP2  VARCHAR2 32
		private String Gcjk;         //GCJK  CHAR 1
		private String Zzg;         //ZZG  CHAR 3
		private String Zzcmc;         //ZZCMC  VARCHAR2 84
		private String Clsbdh;         //CLSBDH  VARCHAR2 25
		private String Fdjh;         //FDJH  VARCHAR2 30
		private String Cllx;         //CLLX  CHAR 3
		private String Csys;         //CSYS  VARCHAR2 5
		private String Syxz;         //SYXZ  CHAR 1
		private String Sfzmhm;         //SFZMHM  VARCHAR2 18
		private String Sfzmmc;         //SFZMMC  CHAR 1
		private String Syr;         //SYR  VARCHAR2 128
		private String Zsxzqh;         //ZSXZQH  VARCHAR2 10
		private String Zsxxdz;         //ZSXXDZ  VARCHAR2 128
		private String Yzbm1;         //YZBM1  CHAR 6
		private String Lxdh;         //LXDH  VARCHAR2 20
		private String Zzz;         //ZZZ  VARCHAR2 18
		private String Zzxzqh;         //ZZXZQH  VARCHAR2 10
		private String Zzxxdz;         //ZZXXDZ  VARCHAR2 128
		private String Yzbm2;         //YZBM2  CHAR 6
		private String Syq;         //SYQ  CHAR 1
		private Date Ccdjrq;         //CCDJRQ  DATE 0
		private Date Djrq;         //DJRQ  DATE 0
		private Date Yxqz;         //YXQZ  DATE 0
		private Date Qzbfqz;         //QZBFQZ  DATE 0
		private String Fzjg;         //FZJG  VARCHAR2 10
		private String Glbm;         //GLBM  VARCHAR2 10
		private Date Fprq;         //FPRQ  DATE 0
		private Date Fzrq;         //FZRQ  DATE 0
		private Date Fdjrq;         //FDJRQ  DATE 0
		private Date Fhgzrq;         //FHGZRQ  DATE 0
		private Date Bxzzrq;         //BXZZRQ  DATE 0
		private Integer Bpcs;         //BPCS  NUMBER 2
		private Integer Bzcs;         //BZCS  NUMBER 2
		private Integer Bdjcs;         //BDJCS  NUMBER 2
		private String Djzsbh;         //DJZSBH  VARCHAR2 15
		private Integer Zdjzshs;         //ZDJZSHS  NUMBER 2
		private String Dabh;         //DABH  VARCHAR2 12
		private String Xzqh;         //XZQH  VARCHAR2 10
		private String Zt;         //ZT  VARCHAR2 6
		private String Zdyzt;         //ZDYZT  VARCHAR2 10
		private String Dybj;         //DYBJ  CHAR 1
		private String Jbr;         //JBR  VARCHAR2 30
		private String Clly;         //CLLY  CHAR 1
		private String Lsh;         //LSH  CHAR 11
		private String Fdjxh;         //FDJXH  VARCHAR2 20
		private String Rlzl;         //RLZL  VARCHAR2 3
		private Integer Pl;         //PL  NUMBER 4
		private Integer Gl;         //GL  NUMBER 5
		private String Zxxs;         //ZXXS  CHAR 1
		private Integer Cwkc;         //CWKC  NUMBER 5
		private Integer Cwkk;         //CWKK  NUMBER 4
		private Integer Cwkg;         //CWKG  NUMBER 4
		private Integer Hxnbcd;         //HXNBCD  NUMBER 5
		private Integer Hxnbkd;         //HXNBKD  NUMBER 4
		private Integer Hxnbgd;         //HXNBGD  NUMBER 4
		private Integer Gbthps;         //GBTHPS  NUMBER 3
		private Integer Zs;         //ZS  NUMBER 1
		private Integer Zj;         //ZJ  NUMBER 5
		private Integer Qlj;         //QLJ  NUMBER 4
		private Integer Hlj;         //HLJ  NUMBER 4
		private String Ltgg;         //LTGG  VARCHAR2 20
		private Integer Lts;         //LTS  NUMBER 2
		private Integer Zzl;         //ZZL  NUMBER 8
		private Integer Zbzl;         //ZBZL  NUMBER 8
		private Integer Hdzzl;         //HDZZL  NUMBER 8
		private Integer Hdzk;         //HDZK  NUMBER 3
		private Integer Zqyzl;         //ZQYZL  NUMBER 8
		private Integer Qpzk;         //QPZK  NUMBER 1
		private Integer Hpzk;         //HPZK  NUMBER 1
		private String Hbdbqk;         //HBDBQK  VARCHAR2 60
		private Date Ccrq;         //CCRQ  DATE 0
		private String Hdfs;         //HDFS  CHAR 1
		private String Llpz1;         //LLPZ1  CHAR 1
		private String Pzbh1;         //PZBH1  VARCHAR2 20
		private String Llpz2;         //LLPZ2  CHAR 1
		private String Pzbh2;         //PZBH2  VARCHAR2 20
		private String Xsdw;         //XSDW  VARCHAR2 64
		private Integer Xsjg;         //XSJG  NUMBER 8
		private Date Xsrq;         //XSRQ  DATE 0
		private String Jkpz;         //JKPZ  CHAR 1
		private String Jkpzhm;         //JKPZHM  VARCHAR2 20
		private String Hgzbh;         //HGZBH  VARCHAR2 20
		private String Nszm;         //NSZM  CHAR 1
		private String Nszmbh;         //NSZMBH  VARCHAR2 20
		private Date Gxrq;         //GXRQ  DATE 0
		private String Xgzl;         //XGZL  VARCHAR2 20
		private String Qmbh;         //QMBH  VARCHAR2 15
		private String Hmbh;         //HMBH  VARCHAR2 15
		private String Bz;         //BZ  VARCHAR2 128
		private String Jyw;         //JYW  VARCHAR2 32
		private String Yxh;         //YXH  VARCHAR2 14
		
		private String ztName;
		private String hpzlName;

		
		
		public String getXh() {
			return Xh;
		}
		public void setXh(String xh) {
			Xh = xh;
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
		public String getClpp2() {
			return Clpp2;
		}
		public void setClpp2(String clpp2) {
			Clpp2 = clpp2;
		}
		public String getGcjk() {
			return Gcjk;
		}
		public void setGcjk(String gcjk) {
			Gcjk = gcjk;
		}
		public String getZzg() {
			return Zzg;
		}
		public void setZzg(String zzg) {
			Zzg = zzg;
		}
		public String getZzcmc() {
			return Zzcmc;
		}
		public void setZzcmc(String zzcmc) {
			Zzcmc = zzcmc;
		}
		public String getClsbdh() {
			return Clsbdh;
		}
		public void setClsbdh(String clsbdh) {
			Clsbdh = clsbdh;
		}
		public String getFdjh() {
			return Fdjh;
		}
		public void setFdjh(String fdjh) {
			Fdjh = fdjh;
		}
		public String getCllx() {
			return Cllx;
		}
		public void setCllx(String cllx) {
			Cllx = cllx;
		}
		public String getCsys() {
			return Csys;
		}
		public void setCsys(String csys) {
			Csys = csys;
		}
		public String getSyxz() {
			return Syxz;
		}
		public void setSyxz(String syxz) {
			Syxz = syxz;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getSfzmmc() {
			return Sfzmmc;
		}
		public void setSfzmmc(String sfzmmc) {
			Sfzmmc = sfzmmc;
		}
		public String getSyr() {
			return Syr;
		}
		public void setSyr(String syr) {
			Syr = syr;
		}
		public String getZsxzqh() {
			return Zsxzqh;
		}
		public void setZsxzqh(String zsxzqh) {
			Zsxzqh = zsxzqh;
		}
		public String getZsxxdz() {
			return Zsxxdz;
		}
		public void setZsxxdz(String zsxxdz) {
			Zsxxdz = zsxxdz;
		}
		public String getYzbm1() {
			return Yzbm1;
		}
		public void setYzbm1(String yzbm1) {
			Yzbm1 = yzbm1;
		}
		public String getLxdh() {
			return Lxdh;
		}
		public void setLxdh(String lxdh) {
			Lxdh = lxdh;
		}
		public String getZzz() {
			return Zzz;
		}
		public void setZzz(String zzz) {
			Zzz = zzz;
		}
		public String getZzxzqh() {
			return Zzxzqh;
		}
		public void setZzxzqh(String zzxzqh) {
			Zzxzqh = zzxzqh;
		}
		public String getZzxxdz() {
			return Zzxxdz;
		}
		public void setZzxxdz(String zzxxdz) {
			Zzxxdz = zzxxdz;
		}
		public String getYzbm2() {
			return Yzbm2;
		}
		public void setYzbm2(String yzbm2) {
			Yzbm2 = yzbm2;
		}
		public String getSyq() {
			return Syq;
		}
		public void setSyq(String syq) {
			Syq = syq;
		}
		public Date getCcdjrq() {
			return Ccdjrq;
		}
		public void setCcdjrq(Date ccdjrq) {
			Ccdjrq = ccdjrq;
		}
		public Date getDjrq() {
			return Djrq;
		}
		public void setDjrq(Date djrq) {
			Djrq = djrq;
		}
		public Date getYxqz() {
			return Yxqz;
		}
		public void setYxqz(Date yxqz) {
			Yxqz = yxqz;
		}
		public Date getQzbfqz() {
			return Qzbfqz;
		}
		public void setQzbfqz(Date qzbfqz) {
			Qzbfqz = qzbfqz;
		}
		public String getFzjg() {
			return Fzjg;
		}
		public void setFzjg(String fzjg) {
			Fzjg = fzjg;
		}
		public String getGlbm() {
			return Glbm;
		}
		public void setGlbm(String glbm) {
			Glbm = glbm;
		}
		public Date getFprq() {
			return Fprq;
		}
		public void setFprq(Date fprq) {
			Fprq = fprq;
		}
		public Date getFzrq() {
			return Fzrq;
		}
		public void setFzrq(Date fzrq) {
			Fzrq = fzrq;
		}
		public Date getFdjrq() {
			return Fdjrq;
		}
		public void setFdjrq(Date fdjrq) {
			Fdjrq = fdjrq;
		}
		public Date getFhgzrq() {
			return Fhgzrq;
		}
		public void setFhgzrq(Date fhgzrq) {
			Fhgzrq = fhgzrq;
		}
		public Date getBxzzrq() {
			return Bxzzrq;
		}
		public void setBxzzrq(Date bxzzrq) {
			Bxzzrq = bxzzrq;
		}
		public Integer getBpcs() {
			return Bpcs;
		}
		public void setBpcs(Integer bpcs) {
			Bpcs = bpcs;
		}
		public Integer getBzcs() {
			return Bzcs;
		}
		public void setBzcs(Integer bzcs) {
			Bzcs = bzcs;
		}
		public Integer getBdjcs() {
			return Bdjcs;
		}
		public void setBdjcs(Integer bdjcs) {
			Bdjcs = bdjcs;
		}
		public String getDjzsbh() {
			return Djzsbh;
		}
		public void setDjzsbh(String djzsbh) {
			Djzsbh = djzsbh;
		}
		public Integer getZdjzshs() {
			return Zdjzshs;
		}
		public void setZdjzshs(Integer zdjzshs) {
			Zdjzshs = zdjzshs;
		}
		public String getDabh() {
			return Dabh;
		}
		public void setDabh(String dabh) {
			Dabh = dabh;
		}
		public String getXzqh() {
			return Xzqh;
		}
		public void setXzqh(String xzqh) {
			Xzqh = xzqh;
		}
		public String getZt() {
			return Zt;
		}
		public void setZt(String zt) {
			Zt = zt;
		}
		public String getZdyzt() {
			return Zdyzt;
		}
		public void setZdyzt(String zdyzt) {
			Zdyzt = zdyzt;
		}
		public String getDybj() {
			return Dybj;
		}
		public void setDybj(String dybj) {
			Dybj = dybj;
		}
		public String getJbr() {
			return Jbr;
		}
		public void setJbr(String jbr) {
			Jbr = jbr;
		}
		public String getClly() {
			return Clly;
		}
		public void setClly(String clly) {
			Clly = clly;
		}
		public String getLsh() {
			return Lsh;
		}
		public void setLsh(String lsh) {
			Lsh = lsh;
		}
		public String getFdjxh() {
			return Fdjxh;
		}
		public void setFdjxh(String fdjxh) {
			Fdjxh = fdjxh;
		}
		public String getRlzl() {
			return Rlzl;
		}
		public void setRlzl(String rlzl) {
			Rlzl = rlzl;
		}
		public Integer getPl() {
			return Pl;
		}
		public void setPl(Integer pl) {
			Pl = pl;
		}
		public Integer getGl() {
			return Gl;
		}
		public void setGl(Integer gl) {
			Gl = gl;
		}
		public String getZxxs() {
			return Zxxs;
		}
		public void setZxxs(String zxxs) {
			Zxxs = zxxs;
		}
		public Integer getCwkc() {
			return Cwkc;
		}
		public void setCwkc(Integer cwkc) {
			Cwkc = cwkc;
		}
		public Integer getCwkk() {
			return Cwkk;
		}
		public void setCwkk(Integer cwkk) {
			Cwkk = cwkk;
		}
		public Integer getCwkg() {
			return Cwkg;
		}
		public void setCwkg(Integer cwkg) {
			Cwkg = cwkg;
		}
		public Integer getHxnbcd() {
			return Hxnbcd;
		}
		public void setHxnbcd(Integer hxnbcd) {
			Hxnbcd = hxnbcd;
		}
		public Integer getHxnbkd() {
			return Hxnbkd;
		}
		public void setHxnbkd(Integer hxnbkd) {
			Hxnbkd = hxnbkd;
		}
		public Integer getHxnbgd() {
			return Hxnbgd;
		}
		public void setHxnbgd(Integer hxnbgd) {
			Hxnbgd = hxnbgd;
		}
		public Integer getGbthps() {
			return Gbthps;
		}
		public void setGbthps(Integer gbthps) {
			Gbthps = gbthps;
		}
		public Integer getZs() {
			return Zs;
		}
		public void setZs(Integer zs) {
			Zs = zs;
		}
		public Integer getZj() {
			return Zj;
		}
		public void setZj(Integer zj) {
			Zj = zj;
		}
		public Integer getQlj() {
			return Qlj;
		}
		public void setQlj(Integer qlj) {
			Qlj = qlj;
		}
		public Integer getHlj() {
			return Hlj;
		}
		public void setHlj(Integer hlj) {
			Hlj = hlj;
		}
		public String getLtgg() {
			return Ltgg;
		}
		public void setLtgg(String ltgg) {
			Ltgg = ltgg;
		}
		public Integer getLts() {
			return Lts;
		}
		public void setLts(Integer lts) {
			Lts = lts;
		}
		public Integer getZzl() {
			return Zzl;
		}
		public void setZzl(Integer zzl) {
			Zzl = zzl;
		}
		public Integer getZbzl() {
			return Zbzl;
		}
		public void setZbzl(Integer zbzl) {
			Zbzl = zbzl;
		}
		public Integer getHdzzl() {
			return Hdzzl;
		}
		public void setHdzzl(Integer hdzzl) {
			Hdzzl = hdzzl;
		}
		public Integer getHdzk() {
			return Hdzk;
		}
		public void setHdzk(Integer hdzk) {
			Hdzk = hdzk;
		}
		public Integer getZqyzl() {
			return Zqyzl;
		}
		public void setZqyzl(Integer zqyzl) {
			Zqyzl = zqyzl;
		}
		public Integer getQpzk() {
			return Qpzk;
		}
		public void setQpzk(Integer qpzk) {
			Qpzk = qpzk;
		}
		public Integer getHpzk() {
			return Hpzk;
		}
		public void setHpzk(Integer hpzk) {
			Hpzk = hpzk;
		}
		public String getHbdbqk() {
			return Hbdbqk;
		}
		public void setHbdbqk(String hbdbqk) {
			Hbdbqk = hbdbqk;
		}
		public Date getCcrq() {
			return Ccrq;
		}
		public void setCcrq(Date ccrq) {
			Ccrq = ccrq;
		}
		public String getHdfs() {
			return Hdfs;
		}
		public void setHdfs(String hdfs) {
			Hdfs = hdfs;
		}
		public String getLlpz1() {
			return Llpz1;
		}
		public void setLlpz1(String llpz1) {
			Llpz1 = llpz1;
		}
		public String getPzbh1() {
			return Pzbh1;
		}
		public void setPzbh1(String pzbh1) {
			Pzbh1 = pzbh1;
		}
		public String getLlpz2() {
			return Llpz2;
		}
		public void setLlpz2(String llpz2) {
			Llpz2 = llpz2;
		}
		public String getPzbh2() {
			return Pzbh2;
		}
		public void setPzbh2(String pzbh2) {
			Pzbh2 = pzbh2;
		}
		public String getXsdw() {
			return Xsdw;
		}
		public void setXsdw(String xsdw) {
			Xsdw = xsdw;
		}
		public Integer getXsjg() {
			return Xsjg;
		}
		public void setXsjg(Integer xsjg) {
			Xsjg = xsjg;
		}
		public Date getXsrq() {
			return Xsrq;
		}
		public void setXsrq(Date xsrq) {
			Xsrq = xsrq;
		}
		public String getJkpz() {
			return Jkpz;
		}
		public void setJkpz(String jkpz) {
			Jkpz = jkpz;
		}
		public String getJkpzhm() {
			return Jkpzhm;
		}
		public void setJkpzhm(String jkpzhm) {
			Jkpzhm = jkpzhm;
		}
		public String getHgzbh() {
			return Hgzbh;
		}
		public void setHgzbh(String hgzbh) {
			Hgzbh = hgzbh;
		}
		public String getNszm() {
			return Nszm;
		}
		public void setNszm(String nszm) {
			Nszm = nszm;
		}
		public String getNszmbh() {
			return Nszmbh;
		}
		public void setNszmbh(String nszmbh) {
			Nszmbh = nszmbh;
		}
		public Date getGxrq() {
			return Gxrq;
		}
		public void setGxrq(Date gxrq) {
			Gxrq = gxrq;
		}
		public String getXgzl() {
			return Xgzl;
		}
		public void setXgzl(String xgzl) {
			Xgzl = xgzl;
		}
		public String getQmbh() {
			return Qmbh;
		}
		public void setQmbh(String qmbh) {
			Qmbh = qmbh;
		}
		public String getHmbh() {
			return Hmbh;
		}
		public void setHmbh(String hmbh) {
			Hmbh = hmbh;
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
		public String getYxh() {
			return Yxh;
		}
		public void setYxh(String yxh) {
			Yxh = yxh;
		}
		public String getZtName() {
			return ztName;
		}
		public void setZtName(String ztName) {
			this.ztName = ztName;
		}
		public String getHpzlName() {
			return hpzlName;
		}
		public void setHpzlName(String hpzlName) {
			this.hpzlName = hpzlName;
		}
		
		
	
}
