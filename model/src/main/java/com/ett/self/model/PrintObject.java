/**
 * 
 */
package com.ett.self.model;

import java.util.Date;

/**
 * @author austin
 * 打印对象，供其他打印activex控件使用
 */
public class PrintObject {
	/*
	 	[id(2) , helpstring("属性 GLBM")] BSTR Glbm;
			[id(3) , helpstring("属性 LSH")] BSTR Lsh;
			[id(4) , helpstring("属性 YWLX")] BSTR Ywlx;
			[id(5) , helpstring("属性 Owner")] BSTR Owner;
			[id(6) , helpstring("属性 Hmhp")] BSTR Hmhp;
			[id(7) , helpstring("属性 Slrq")] BSTR Slrq;
			[id(8) , helpstring("属性 Fee")] BSTR Fee;
			[id(9) , helpstring("属性 Hint")] BSTR Hint;
			[id(10) , helpstring("属性 Jszh")] BSTR Jszh;
			[id(11) , helpstring("属性 Ksrq")] BSTR Ksrq;
			[id(12) , helpstring("属性 Yyrq")] BSTR Yyrq;
			[id(13) , helpstring("属性 PrinterName")] BSTR PrinterName; 
	 
	 * */
	
	private String lineUpId;
	
	public String getLineUpId() {
		return lineUpId;
	}
	public void setLineUpId(String lineUpId) {
		this.lineUpId = lineUpId;
	}
	private String glbmName;
	
	public String getGlbmName() {
		return glbmName;
	}
	public void setGlbmName(String glbmName) {
		this.glbmName = glbmName;
	}
	private String lsh;
	
	private String ywlx;
	
	private String xm;
	
	private String hphm;
	
	private Date slrq;
	
	private String fee;
	
	private Date ksrq;
	private Date yyrq;
	private String sfzmhm;
	
	private String zjcx;
	private String dabh;
	
	private String jdsbh;
	
	public String getZjcx() {
		return zjcx;
	}
	public void setZjcx(String zjcx) {
		this.zjcx = zjcx;
	}
	public String getJdsbh() {
		return jdsbh;
	}
	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public Date getSlrq() {
		return slrq;
	}
	public void setSlrq(Date slrq) {
		this.slrq = slrq;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public Date getKsrq() {
		return ksrq;
	}
	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}
	public Date getYyrq() {
		return yyrq;
	}
	public void setYyrq(Date yyrq) {
		this.yyrq = yyrq;
	}
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

}
