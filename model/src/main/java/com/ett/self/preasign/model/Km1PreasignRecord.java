/**
 * 
 */
package com.ett.self.preasign.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

/**
 * @author austin
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_km1_preasign_record")
public class Km1PreasignRecord extends BaseEntity {
	
	public String getJxmc() {
		return jxmc;
	}

	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}

	public String getJxdm() {
		return jxdm;
	}

	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	public String getKsddCode() {
		return ksddCode;
	}

	public void setKsddCode(String ksddCode) {
		this.ksddCode = ksddCode;
	}

	public String getKsddName() {
		return ksddName;
	}

	public void setKsddName(String ksddName) {
		this.ksddName = ksddName;
	}

	public String getKsccCode() {
		return ksccCode;
	}

	public void setKsccCode(String ksccCode) {
		this.ksccCode = ksccCode;
	}

	public String getKsccName() {
		return ksccName;
	}

	public void setKsccName(String ksccName) {
		this.ksccName = ksccName;
	}

	public Date getKsrq() {
		return ksrq;
	}

	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

	private String jxmc;
	
	private String jxdm;
	
	private String xm;
	
	private String sfzmhm;
	
	private String ksddCode;
	
	private String ksddName;
	
	private String ksccCode;
	
	private String ksccName;
	
	private Date ksrq;
	
	private String lsh;

	/* (non-Javadoc)
	 * @see com.ett.model.BaseEntity#toXml()
	 */
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
