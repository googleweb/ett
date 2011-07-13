/**
 * 
 */
package com.ett.drvinterface.entity;

import org.dom4j.DocumentException;

/**
 * @author austin
 * 基本的预约请求类实体
 */
public class DrvPreasignRequest extends BaseDrvRequest {
	
	private String kskm;//
	
	private String xxsj="0";

	private String ksdd;

	private String jbr;

	private String dlr;

	private String ykrq;

	public String getKskm() {
		return kskm;
	}

	public void setKskm(String kskm) {
		this.kskm = kskm;
	}

	public String getXxsj() {
		return xxsj;
	}

	public void setXxsj(String xxsj) {
		this.xxsj = xxsj;
	}

	public String getKsdd() {
		return ksdd;
	}

	public void setKsdd(String ksdd) {
		this.ksdd = ksdd;
	}

	public String getJbr() {
		return jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public String getDlr() {
		return dlr;
	}

	public void setDlr(String dlr) {
		this.dlr = dlr;
	}

	public String getYkrq() {
		return ykrq;
	}

	public void setYkrq(String ykrq) {
		this.ykrq = ykrq;
	}

	public String getKscc() {
		return kscc;
	}

	public void setKscc(String kscc) {
		this.kscc = kscc;
	}

	public String getKchp() {
		return kchp;
	}

	public void setKchp(String kchp) {
		this.kchp = kchp;
	}

	public String getPxshrq() {
		return pxshrq;
	}

	public void setPxshrq(String pxshrq) {
		this.pxshrq = pxshrq;
	}

	public String getJly() {
		return jly;
	}

	public void setJly(String jly) {
		this.jly = jly;
	}

	private String kscc;

	private String kchp;

	private String pxshrq;

	private String jly;

	/* (non-Javadoc)
	 * @see com.ett.drvinterface.entity.BaseDrvRequest#toXml()
	 */
	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<DrvPreasign>");
		this.appendTag(sb, "lsh", this.lsh);
		this.appendTag(sb, "kskm", this.kskm);
		this.appendTag(sb, "xxsj", this.xxsj);
		this.appendTag(sb, "ksdd", this.ksdd);
		this.appendTag(sb, "jbr", this.jbr);
		this.appendTag(sb, "dlr", this.dlr);
		this.appendTag(sb, "ykrq", this.ykrq);
		this.appendTag(sb, "kscc", this.kscc);
		this.appendTag(sb, "kchp", this.kchp);
		this.appendTag(sb, "pxshrq", this.pxshrq);
		this.appendTag(sb, "jly", this.jly);
		this.appendTag(sb, "sn", this.sn);
		sb.append("</DrvPreasign>");
		sb.append("</root>");
		return sb.toString();
	}

	

}
