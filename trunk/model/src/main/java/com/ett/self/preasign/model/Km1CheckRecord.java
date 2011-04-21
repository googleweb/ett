/**
 * 
 */
package com.ett.self.preasign.model;

import javax.persistence.Column;
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
@Table(name="table_self_km1_check_record")
public class Km1CheckRecord extends BaseEntity {
	
	
    private String sfzmhm;
    
    private String lsh;
    
    private String xm;
    
    private String ksdd;
    
    @Column(name="sfzmhm")
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	@Column(name="lsh")
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	@Column(name="xm")
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	@Column(name="ksdd")
	public String getKsdd() {
		return ksdd;
	}
	
	public void setKsdd(String ksdd) {
		this.ksdd = ksdd;
	}
	
	private String ksddName;
	@Column(name="c_ksddName")
	public String getKsddName() {
		return ksddName;
	}
	public void setKsddName(String ksddName) {
		this.ksddName = ksddName;
	}
	/* (non-Javadoc)
	 * @see com.ett.model.BaseEntity#toXml()
	 */
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
