package com.ett.self.print.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_add_print_apply")
public class AddPrintApplyObject extends BaseEntity {
	
	public static final String Hospital_Print="医院体检回执补打";
	public static final String Hgbj_Add_Print="检验合格标记补打";
	public static final String Vio_Add_Print="简易处罚决定书补打";
	
	private String lsh;
	private String address;
	
	private String device;
	
	private boolean isPrinted;
	
	private int lineUpid;
	
	private String sfzmhm;
	
	private String busType;

	@Column
	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	@Column
	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	@Column
	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Column
	public boolean isPrinted() {
		return isPrinted;
	}

	public void setPrinted(boolean isPrinted) {
		this.isPrinted = isPrinted;
	}

	@Column
	public int getLineUpid() {
		return lineUpid;
	}

	public void setLineUpid(int lineUpid) {
		this.lineUpid = lineUpid;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
