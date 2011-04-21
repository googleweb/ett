package com.ett.self.model;

import java.util.Date;

/**
 * @author austin
 * 机动车业务流水
 */
public class VehicleFlowObject {
	
	private String lsh;
	private String xh;
	private String ywlx;
	private String ywyy;
	private String syr;
	private String hphm;
	private Date sqrq;
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
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
	public String getSyr() {
		return syr;
	}
	public void setSyr(String syr) {
		this.syr = syr;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public Date getSqrq() {
		return sqrq;
	}
	public void setSqrq(Date sqrq) {
		this.sqrq = sqrq;
	}
	public Date getBjrq() {
		return bjrq;
	}
	public void setBjrq(Date bjrq) {
		this.bjrq = bjrq;
	}
	private Date bjrq;

}
