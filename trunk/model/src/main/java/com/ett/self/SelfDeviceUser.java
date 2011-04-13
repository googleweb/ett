/**
 * 
 */
package com.ett.self;

import java.util.Date;

/**
 * @author austin
 * 自助设备的用户信息
 */
public class SelfDeviceUser {
	
	private String sfzmhm;
	
	private int xb;
	private String xm;
	
	private Date csrq;
	
	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	private String lxdh;
	
	private String sjhm;

	private String newSjhm;
	
	private String lxzsxxdz;
	
	private String hmhp;
	
	private String ywlx;
	
	private String lxh;
	
	private int money;
	
	private String carState;
	
	private String zkcx;
	
    public String getZkcx() {
		return zkcx;
	}

	public void setZkcx(String zkcx) {
		this.zkcx = zkcx;
	}

	private Date fprq;
	
	private String zkzmbh;
	
	private Date yxqz;
	
	private Date yxqs;
	
	/**
	 * @return 车辆状态
	 */
	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	/**
	 * @return 初次发证日期
	 */
	public Date getFprq() {
		return fprq;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	/**
	 * @return 准考证明号码
	 */
	public String getZkzmbh() {
		return zkzmbh;
	}

	public void setZkzmbh(String zkzmbh) {
		this.zkzmbh = zkzmbh;
	}

	

	
	
	

	public Date getYxqz() {
		return yxqz;
	}

	public void setYxqz(Date yxqz) {
		this.yxqz = yxqz;
	}

	public Date getYxqs() {
		return yxqs;
	}

	public void setYxqs(Date yxqs) {
		this.yxqs = yxqs;
	}

	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	public int getXb() {
		return xb;
	}

	public void setXb(int xb) {
		this.xb = xb;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
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

	public String getNewSjhm() {
		return newSjhm;
	}

	public void setNewSjhm(String newSjhm) {
		this.newSjhm = newSjhm;
	}

	public String getLxzsxxdz() {
		return lxzsxxdz;
	}

	public void setLxzsxxdz(String lxzsxxdz) {
		this.lxzsxxdz = lxzsxxdz;
	}

	public String getHmhp() {
		return hmhp;
	}

	public void setHmhp(String hmhp) {
		this.hmhp = hmhp;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getLxh() {
		return lxh;
	}

	public void setLxh(String lxh) {
		this.lxh = lxh;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private int state;

}
