/**
 * 
 */
package com.ett.self.print.model;

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
@Table(name="table_print_log")
public class PrintLog extends BaseEntity {
	
	private String idCard;
	private String name;
	private String yxlsh;
	@Column
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getYxlsh() {
		return yxlsh;
	}
	public void setYxlsh(String yxlsh) {
		this.yxlsh = yxlsh;
	}
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
