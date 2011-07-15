package com.ett.drvinterface.entity;

public class HealthBeanRequest extends BaseDrvRequest{

	private String sfzmhm;// 身份证明号码

	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
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

	private String sg;// 身高
	private String zsl;// 左视力
	private String ysl;// 右视力
	private String bsl;// 辨色力
	private String tl;// 听力
	private String sz;// 上肢
	private String zxz;// 左下肢
	private String yxz;// 右下肢
	private String qgjb;// 躯干颈部
	private String tjrq;// 体检日期
	private String tjyymc;// 体检医院名称
	@Override
	/**
	 * @return XML格式的字符串 
	 */
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<HealthBean>");
		this.appendTag(sb, "sfzmhm", this.sfzmhm);
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
		sb.append("</root>");
		sb.append("</HealthBean>");
		return sb.toString();
	}
	

}
