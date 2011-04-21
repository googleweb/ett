/**
 * 
 */
package com.ett.self.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

/**
 * @author austin
 * 自助设备的硬件对象
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_hard")
public class SelfHardObject extends  BaseEntity {
	
	private long deviceId;
	
	/**
	 * @return 所属终端ID
	 */
	@Column(name="i_device_id")
	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}
	
	private String brand;
	private String catalog;
	
	private int baud;

	private int com;
	
	private int  stopBits;
	
	

	/**
	 * @return 设备类型 比如热敏，二代证
	 */
	@Column(name="c_brand",columnDefinition=" varchar2(64)")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return 设备型号
	 */
	@Column(name="c_catalog",nullable=true,columnDefinition=" varchar2(64)")
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return 波特率
	 */
	@Column(name="i_baud")
	public int getBaud() {
		return baud;
	}

	public void setBaud(int baud) {
		this.baud = baud;
	}

	/**
	 * @return 设备端口号
	 */
	@Column(name="i_com")
	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	/**
	 * @return 设备停止位
	 */
	@Column(name="i_stopbits")
	public int getStopBits() {
		return stopBits;
	}

	public void setStopBits(int stopBits) {
		this.stopBits = stopBits;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
