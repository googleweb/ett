package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class VehicleModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static enum F{
		xh,hpzl,hphm,clpp1,clxh,clpp2,gcjk,zzg,zzcmc,clsbdh,fdjh,
		cllx,csys,syxz,sfzmhm,sfzmmc,syr,zsxzqh,zsxxdz,yzbm1,lxdh,
		zzz,zzxzqh,zzxxdz,yzbm2,syq,ccdjrq,djrq,yxqz,qzbfqz,fzjg,
		glbm,fprq,fzrq,fdjrq,fhgzrq,bxzzrq,bpcs,bzcs,bdjcs,djzsbh,
		zdjzshs,dabh,xzqh,zt,zdyzt,dybj,jbr,clly,lsh,fdjxh,
		rlzl,pl,gl,zxxs,cwkc,cwkk,cwkg,hxnbcd,hxnbkd,hxnbgd,
		gbthps,zs,zj,qlj,hlj,ltgg,lts,zzl,zbzl,hdzzl,
		hdzk,zqyzl,qpzk,hpzk,hbdbqk,ccrq,hdfs,llpz1,pzbh1,llpz2,
		pzbh2,xsdw,xsjg,xsrq,jkpz,jkpzhm,hgzbh,nszm,nszmbh,gxrq,
		xgzl,qmbh,hmbh,bz,jyw,yxh
	}


	private String xh;         //XH  CHAR 14
	private String hpzl;         //HPZL  CHAR 2
	private String hphm;         //HPHM  VARCHAR2 15
	private String clpp1;         //CLPP1  VARCHAR2 32
	private String clxh;         //CLXH  VARCHAR2 32
	private String clpp2;         //CLPP2  VARCHAR2 32
	private String gcjk;         //GCJK  CHAR 1
	private String zzg;         //ZZG  CHAR 3
	private String zzcmc;         //ZZCMC  VARCHAR2 84
	private String clsbdh;         //CLSBDH  VARCHAR2 25
	private String fdjh;         //FDJH  VARCHAR2 30
	private String cllx;         //CLLX  CHAR 3
	private String csys;         //CSYS  VARCHAR2 5
	private String syxz;         //SYXZ  CHAR 1
	private String sfzmhm;         //SFZMHM  VARCHAR2 18
	private String sfzmmc;         //SFZMMC  CHAR 1
	private String syr;         //SYR  VARCHAR2 128
	private String zsxzqh;         //ZSXZQH  VARCHAR2 10
	private String zsxxdz;         //ZSXXDZ  VARCHAR2 128
	private String yzbm1;         //YZBM1  CHAR 6
	private String lxdh;         //LXDH  VARCHAR2 20
	private String zzz;         //ZZZ  VARCHAR2 18
	private String zzxzqh;         //ZZXZQH  VARCHAR2 10
	private String zzxxdz;         //ZZXXDZ  VARCHAR2 128
	private String yzbm2;         //YZBM2  CHAR 6
	private String syq;         //SYQ  CHAR 1
	private Date ccdjrq;         //CCDJRQ  DATE 0
	private Date djrq;         //DJRQ  DATE 0
	private Date yxqz;         //YXQZ  DATE 0
	private Date qzbfqz;         //QZBFQZ  DATE 0
	private String fzjg;         //FZJG  VARCHAR2 10
	private String glbm;         //GLBM  VARCHAR2 10
	private Date fprq;         //FPRQ  DATE 0
	private Date fzrq;         //FZRQ  DATE 0
	private Date fdjrq;         //FDJRQ  DATE 0
	private Date fhgzrq;         //FHGZRQ  DATE 0
	private Date bxzzrq;         //BXZZRQ  DATE 0
	private Integer bpcs;         //BPCS  NUMBER 2
	private Integer bzcs;         //BZCS  NUMBER 2
	private Integer bdjcs;         //BDJCS  NUMBER 2
	private String djzsbh;         //DJZSBH  VARCHAR2 15
	private Integer zdjzshs;         //ZDJZSHS  NUMBER 2
	private String dabh;         //DABH  VARCHAR2 12
	private String xzqh;         //XZQH  VARCHAR2 10
	private String zt;         //ZT  VARCHAR2 6
	private String zdyzt;         //ZDYZT  VARCHAR2 10
	private String dybj;         //DYBJ  CHAR 1
	private String jbr;         //JBR  VARCHAR2 30
	private String clly;         //CLLY  CHAR 1
	private String lsh;         //LSH  CHAR 11
	private String fdjxh;         //FDJXH  VARCHAR2 20
	private String rlzl;         //RLZL  VARCHAR2 3
	private Integer pl;         //PL  NUMBER 4
	private Integer gl;         //GL  NUMBER 5
	private String zxxs;         //ZXXS  CHAR 1
	private Integer cwkc;         //CWKC  NUMBER 5
	private Integer cwkk;         //CWKK  NUMBER 4
	private Integer cwkg;         //CWKG  NUMBER 4
	private Integer hxnbcd;         //HXNBCD  NUMBER 5
	private Integer hxnbkd;         //HXNBKD  NUMBER 4
	private Integer hxnbgd;         //HXNBGD  NUMBER 4
	private Integer gbthps;         //GBTHPS  NUMBER 3
	private Integer zs;         //ZS  NUMBER 1
	private Integer zj;         //ZJ  NUMBER 5
	private Integer qlj;         //QLJ  NUMBER 4
	private Integer hlj;         //HLJ  NUMBER 4
	private String ltgg;         //LTGG  VARCHAR2 20
	private Integer lts;         //LTS  NUMBER 2
	private Integer zzl;         //ZZL  NUMBER 8
	private Integer zbzl;         //ZBZL  NUMBER 8
	private Integer hdzzl;         //HDZZL  NUMBER 8
	private Integer hdzk;         //HDZK  NUMBER 3
	private Integer zqyzl;         //ZQYZL  NUMBER 8
	private Integer qpzk;         //QPZK  NUMBER 1
	private Integer hpzk;         //HPZK  NUMBER 1
	private String hbdbqk;         //HBDBQK  VARCHAR2 60
	private Date ccrq;         //CCRQ  DATE 0
	private String hdfs;         //HDFS  CHAR 1
	private String llpz1;         //LLPZ1  CHAR 1
	private String pzbh1;         //PZBH1  VARCHAR2 20
	private String llpz2;         //LLPZ2  CHAR 1
	private String pzbh2;         //PZBH2  VARCHAR2 20
	private String xsdw;         //XSDW  VARCHAR2 64
	private Integer xsjg;         //XSJG  NUMBER 8
	private Date xsrq;         //XSRQ  DATE 0
	private String jkpz;         //JKPZ  CHAR 1
	private String jkpzhm;         //JKPZHM  VARCHAR2 20
	private String hgzbh;         //HGZBH  VARCHAR2 20
	private String nszm;         //NSZM  CHAR 1
	private String nszmbh;         //NSZMBH  VARCHAR2 20
	private Date gxrq;         //GXRQ  DATE 0
	private String xgzl;         //XGZL  VARCHAR2 20
	private String qmbh;         //QMBH  VARCHAR2 15
	private String hmbh;         //HMBH  VARCHAR2 15
	private String bz;         //BZ  VARCHAR2 128
	private String jyw;         //JYW  VARCHAR2 32
	private String yxh;         //YXH  VARCHAR2 14
	
	private String ztName;
	private String hpzlName;
	
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
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
	public String getClpp2() {
		return clpp2;
	}
	public void setClpp2(String clpp2) {
		this.clpp2 = clpp2;
	}
	public String getGcjk() {
		return gcjk;
	}
	public void setGcjk(String gcjk) {
		this.gcjk = gcjk;
	}
	public String getZzg() {
		return zzg;
	}
	public void setZzg(String zzg) {
		this.zzg = zzg;
	}
	public String getZzcmc() {
		return zzcmc;
	}
	public void setZzcmc(String zzcmc) {
		this.zzcmc = zzcmc;
	}
	public String getClsbdh() {
		return clsbdh;
	}
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	public String getFdjh() {
		return fdjh;
	}
	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getSyxz() {
		return syxz;
	}
	public void setSyxz(String syxz) {
		this.syxz = syxz;
	}
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
	public String getSyr() {
		return syr;
	}
	public void setSyr(String syr) {
		this.syr = syr;
	}
	public String getZsxzqh() {
		return zsxzqh;
	}
	public void setZsxzqh(String zsxzqh) {
		this.zsxzqh = zsxzqh;
	}
	public String getZsxxdz() {
		return zsxxdz;
	}
	public void setZsxxdz(String zsxxdz) {
		this.zsxxdz = zsxxdz;
	}
	public String getYzbm1() {
		return yzbm1;
	}
	public void setYzbm1(String yzbm1) {
		this.yzbm1 = yzbm1;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZzz() {
		return zzz;
	}
	public void setZzz(String zzz) {
		this.zzz = zzz;
	}
	public String getZzxzqh() {
		return zzxzqh;
	}
	public void setZzxzqh(String zzxzqh) {
		this.zzxzqh = zzxzqh;
	}
	public String getZzxxdz() {
		return zzxxdz;
	}
	public void setZzxxdz(String zzxxdz) {
		this.zzxxdz = zzxxdz;
	}
	public String getYzbm2() {
		return yzbm2;
	}
	public void setYzbm2(String yzbm2) {
		this.yzbm2 = yzbm2;
	}
	public String getSyq() {
		return syq;
	}
	public void setSyq(String syq) {
		this.syq = syq;
	}
	public Date getCcdjrq() {
		return ccdjrq;
	}
	public void setCcdjrq(Date ccdjrq) {
		this.ccdjrq = ccdjrq;
	}
	public Date getDjrq() {
		return djrq;
	}
	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}
	public Date getYxqz() {
		return yxqz;
	}
	public void setYxqz(Date yxqz) {
		this.yxqz = yxqz;
	}
	public Date getQzbfqz() {
		return qzbfqz;
	}
	public void setQzbfqz(Date qzbfqz) {
		this.qzbfqz = qzbfqz;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public Date getFprq() {
		return fprq;
	}
	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}
	public Date getFzrq() {
		return fzrq;
	}
	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
	}
	public Date getFdjrq() {
		return fdjrq;
	}
	public void setFdjrq(Date fdjrq) {
		this.fdjrq = fdjrq;
	}
	public Date getFhgzrq() {
		return fhgzrq;
	}
	public void setFhgzrq(Date fhgzrq) {
		this.fhgzrq = fhgzrq;
	}
	public Date getBxzzrq() {
		return bxzzrq;
	}
	public void setBxzzrq(Date bxzzrq) {
		this.bxzzrq = bxzzrq;
	}
	public Integer getBpcs() {
		return bpcs;
	}
	public void setBpcs(Integer bpcs) {
		this.bpcs = bpcs;
	}
	public Integer getBzcs() {
		return bzcs;
	}
	public void setBzcs(Integer bzcs) {
		this.bzcs = bzcs;
	}
	public Integer getBdjcs() {
		return bdjcs;
	}
	public void setBdjcs(Integer bdjcs) {
		this.bdjcs = bdjcs;
	}
	public String getDjzsbh() {
		return djzsbh;
	}
	public void setDjzsbh(String djzsbh) {
		this.djzsbh = djzsbh;
	}
	public Integer getZdjzshs() {
		return zdjzshs;
	}
	public void setZdjzshs(Integer zdjzshs) {
		this.zdjzshs = zdjzshs;
	}
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getZdyzt() {
		return zdyzt;
	}
	public void setZdyzt(String zdyzt) {
		this.zdyzt = zdyzt;
	}
	public String getDybj() {
		return dybj;
	}
	public void setDybj(String dybj) {
		this.dybj = dybj;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getClly() {
		return clly;
	}
	public void setClly(String clly) {
		this.clly = clly;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getFdjxh() {
		return fdjxh;
	}
	public void setFdjxh(String fdjxh) {
		this.fdjxh = fdjxh;
	}
	public String getRlzl() {
		return rlzl;
	}
	public void setRlzl(String rlzl) {
		this.rlzl = rlzl;
	}
	public Integer getPl() {
		return pl;
	}
	public void setPl(Integer pl) {
		this.pl = pl;
	}
	public Integer getGl() {
		return gl;
	}
	public void setGl(Integer gl) {
		this.gl = gl;
	}
	public String getZxxs() {
		return zxxs;
	}
	public void setZxxs(String zxxs) {
		this.zxxs = zxxs;
	}
	public Integer getCwkc() {
		return cwkc;
	}
	public void setCwkc(Integer cwkc) {
		this.cwkc = cwkc;
	}
	public Integer getCwkk() {
		return cwkk;
	}
	public void setCwkk(Integer cwkk) {
		this.cwkk = cwkk;
	}
	public Integer getCwkg() {
		return cwkg;
	}
	public void setCwkg(Integer cwkg) {
		this.cwkg = cwkg;
	}
	public Integer getHxnbcd() {
		return hxnbcd;
	}
	public void setHxnbcd(Integer hxnbcd) {
		this.hxnbcd = hxnbcd;
	}
	public Integer getHxnbkd() {
		return hxnbkd;
	}
	public void setHxnbkd(Integer hxnbkd) {
		this.hxnbkd = hxnbkd;
	}
	public Integer getHxnbgd() {
		return hxnbgd;
	}
	public void setHxnbgd(Integer hxnbgd) {
		this.hxnbgd = hxnbgd;
	}
	public Integer getGbthps() {
		return gbthps;
	}
	public void setGbthps(Integer gbthps) {
		this.gbthps = gbthps;
	}
	public Integer getZs() {
		return zs;
	}
	public void setZs(Integer zs) {
		this.zs = zs;
	}
	public Integer getZj() {
		return zj;
	}
	public void setZj(Integer zj) {
		this.zj = zj;
	}
	public Integer getQlj() {
		return qlj;
	}
	public void setQlj(Integer qlj) {
		this.qlj = qlj;
	}
	public Integer getHlj() {
		return hlj;
	}
	public void setHlj(Integer hlj) {
		this.hlj = hlj;
	}
	public String getLtgg() {
		return ltgg;
	}
	public void setLtgg(String ltgg) {
		this.ltgg = ltgg;
	}
	public Integer getLts() {
		return lts;
	}
	public void setLts(Integer lts) {
		this.lts = lts;
	}
	public Integer getZzl() {
		return zzl;
	}
	public void setZzl(Integer zzl) {
		this.zzl = zzl;
	}
	public Integer getZbzl() {
		return zbzl;
	}
	public void setZbzl(Integer zbzl) {
		this.zbzl = zbzl;
	}
	public Integer getHdzzl() {
		return hdzzl;
	}
	public void setHdzzl(Integer hdzzl) {
		this.hdzzl = hdzzl;
	}
	public Integer getHdzk() {
		return hdzk;
	}
	public void setHdzk(Integer hdzk) {
		this.hdzk = hdzk;
	}
	public Integer getZqyzl() {
		return zqyzl;
	}
	public void setZqyzl(Integer zqyzl) {
		this.zqyzl = zqyzl;
	}
	public Integer getQpzk() {
		return qpzk;
	}
	public void setQpzk(Integer qpzk) {
		this.qpzk = qpzk;
	}
	public Integer getHpzk() {
		return hpzk;
	}
	public void setHpzk(Integer hpzk) {
		this.hpzk = hpzk;
	}
	public String getHbdbqk() {
		return hbdbqk;
	}
	public void setHbdbqk(String hbdbqk) {
		this.hbdbqk = hbdbqk;
	}
	public Date getCcrq() {
		return ccrq;
	}
	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}
	public String getHdfs() {
		return hdfs;
	}
	public void setHdfs(String hdfs) {
		this.hdfs = hdfs;
	}
	public String getLlpz1() {
		return llpz1;
	}
	public void setLlpz1(String llpz1) {
		this.llpz1 = llpz1;
	}
	public String getPzbh1() {
		return pzbh1;
	}
	public void setPzbh1(String pzbh1) {
		this.pzbh1 = pzbh1;
	}
	public String getLlpz2() {
		return llpz2;
	}
	public void setLlpz2(String llpz2) {
		this.llpz2 = llpz2;
	}
	public String getPzbh2() {
		return pzbh2;
	}
	public void setPzbh2(String pzbh2) {
		this.pzbh2 = pzbh2;
	}
	public String getXsdw() {
		return xsdw;
	}
	public void setXsdw(String xsdw) {
		this.xsdw = xsdw;
	}
	public Integer getXsjg() {
		return xsjg;
	}
	public void setXsjg(Integer xsjg) {
		this.xsjg = xsjg;
	}
	public Date getXsrq() {
		return xsrq;
	}
	public void setXsrq(Date xsrq) {
		this.xsrq = xsrq;
	}
	public String getJkpz() {
		return jkpz;
	}
	public void setJkpz(String jkpz) {
		this.jkpz = jkpz;
	}
	public String getJkpzhm() {
		return jkpzhm;
	}
	public void setJkpzhm(String jkpzhm) {
		this.jkpzhm = jkpzhm;
	}
	public String getHgzbh() {
		return hgzbh;
	}
	public void setHgzbh(String hgzbh) {
		this.hgzbh = hgzbh;
	}
	public String getNszm() {
		return nszm;
	}
	public void setNszm(String nszm) {
		this.nszm = nszm;
	}
	public String getNszmbh() {
		return nszmbh;
	}
	public void setNszmbh(String nszmbh) {
		this.nszmbh = nszmbh;
	}
	public Date getGxrq() {
		return gxrq;
	}
	public void setGxrq(Date gxrq) {
		this.gxrq = gxrq;
	}
	public String getXgzl() {
		return xgzl;
	}
	public void setXgzl(String xgzl) {
		this.xgzl = xgzl;
	}
	public String getQmbh() {
		return qmbh;
	}
	public void setQmbh(String qmbh) {
		this.qmbh = qmbh;
	}
	public String getHmbh() {
		return hmbh;
	}
	public void setHmbh(String hmbh) {
		this.hmbh = hmbh;
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
	public String getYxh() {
		return yxh;
	}
	public void setYxh(String yxh) {
		this.yxh = yxh;
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
