package com.ett.drvinterface.entity;

import java.util.Date;

public class DrvtempMidRequest extends BaseDrvRequest{
	
	private String hmcd;//号码长度
	private String xm;//姓名
	private String xb;//性别
	private String csrq;//出生日期
	private String gj;//国籍
	private String djzsxzqh;//登记住所行政区划
	private String djzsxxdz;//登记住所详细地址
	private String lxzsxzqh;//联系住所行政区划
	private String lxzsxxdz;//联系住所详细地址
	private String lxzsyzbm;//联系住所邮政编码
	private String ly;//来源
	private String xzqh;//行政区划
	private String lxdh;//联系电话
	private String zzzm;//暂住证明号码
	private String zkzmbh;//准考证明编号
	private String zkcx;//准考车型
	private String jxmc;//驾校名称
	private String sg;//身高
	private String zsl;//左视力
	private String ysl;//右视力
	private String bsl;//辨色力
	private String tl;//听力
	private String sz;//上肢
	private String zxz;//左下肢
	private String yxz;//右下肢
	private String qgjb;//躯干颈部
	private String tjrq;//体检日期
	private String tjyymc;//体检医院名称
	private String sjhm;//手机号码
	private String dzyx;//电子邮箱
	

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


	public String getCsrq() {
		return csrq;
	}


	public void setCsrq(String csrq) {
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


	public String getLy() {
		return ly;
	}


	public void setLy(String ly) {
		this.ly = ly;
	}


	public String getXzqh() {
		return xzqh;
	}


	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
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


	public String getZkzmbh() {
		return zkzmbh;
	}


	public void setZkzmbh(String zkzmbh) {
		this.zkzmbh = zkzmbh;
	}


	public String getZkcx() {
		return zkcx;
	}


	public void setZkcx(String zkcx) {
		this.zkcx = zkcx;
	}


	public String getJxmc() {
		return jxmc;
	}


	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}


	public String getSg() {
		return sg;
	}


	public void setSg(String sg) {
		this.sg = sg;
	}


	public String getZsl() {
		return zsl;
	}


	public void setZsl(String zsl) {
		this.zsl = zsl;
	}


	public String getYsl() {
		return ysl;
	}


	public void setYsl(String ysl) {
		this.ysl = ysl;
	}


	public String getBsl() {
		return bsl;
	}


	public void setBsl(String bsl) {
		this.bsl = bsl;
	}


	public String getTl() {
		return tl;
	}


	public void setTl(String tl) {
		this.tl = tl;
	}


	public String getSz() {
		return sz;
	}


	public void setSz(String sz) {
		this.sz = sz;
	}


	public String getZxz() {
		return zxz;
	}


	public void setZxz(String zxz) {
		this.zxz = zxz;
	}


	public String getYxz() {
		return yxz;
	}


	public void setYxz(String yxz) {
		this.yxz = yxz;
	}


	public String getQgjb() {
		return qgjb;
	}


	public void setQgjb(String qgjb) {
		this.qgjb = qgjb;
	}


	public String getTjrq() {
		return tjrq;
	}


	public void setTjrq(String tjrq) {
		this.tjrq = tjrq;
	}


	public String getTjyymc() {
		return tjyymc;
	}


	public void setTjyymc(String tjyymc) {
		this.tjyymc = tjyymc;
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


	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<DrvtempMid>");
		this.appendTag(sb, "lsh", this.lsh);
		this.appendTag(sb, "sfzmhm", this.sfzmhm);
		this.appendTag(sb, "sfzmmc", this.sfzmmc);
		this.appendTag(sb, "hmcd", this.hmcd);
		this.appendTag(sb, "xm", this.xm);
		this.appendTag(sb, "xb", this.xb);
		this.appendTag(sb, "csrq", this.csrq);
		this.appendTag(sb, "gj", this.gj);
		this.appendTag(sb, "djzsxzqh", this.djzsxzqh);
		this.appendTag(sb, "djzsxxdz", this.djzsxxdz);
		this.appendTag(sb, "lxzsxzqh", this.lxzsxzqh);
		this.appendTag(sb, "lxzsxxdz", this.lxzsxxdz);
		this.appendTag(sb, "lxzsyzbm", this.lxzsyzbm);
		this.appendTag(sb, "ly", this.ly);
		this.appendTag(sb, "xzqh", this.xzqh);
		this.appendTag(sb, "lxdh", this.lxdh);
		this.appendTag(sb, "zzzm", this.zzzm);
		this.appendTag(sb, "zkzmbh", this.zkzmbh);
		this.appendTag(sb, "dabh", this.dabh);
		this.appendTag(sb, "zkcx", this.zkcx);
		this.appendTag(sb, "jxmc", this.jxmc);
		this.appendTag(sb, "sg", this.sg);
		this.appendTag(sb, "zsl", this.zsl);
		this.appendTag(sb, "ysl", this.ysl);
		this.appendTag(sb, "bsl", this.bsl);
		this.appendTag(sb, "tl", this.tl);
		this.appendTag(sb, "sz", this.sz);
		this.appendTag(sb, "zxz", this.zxz);
		this.appendTag(sb, "yxz", this.yxz);
		this.appendTag(sb, "qgjb", this.qgjb);
		this.appendTag(sb, "tjrq", this.tjrq);
		this.appendTag(sb, "tjyymc", this.tjyymc);
		this.appendTag(sb, "sjhm", this.sjhm);
		this.appendTag(sb, "dzyx", this.dzyx);
		sb.append("</DrvtempMid>");
		sb.append("</root>");
		return sb.toString();

   }
}
