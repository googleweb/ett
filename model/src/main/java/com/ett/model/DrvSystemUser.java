/**
 * 
 */
package com.ett.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author austin
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_drv_system_user")
public class DrvSystemUser extends Person {
	
	private String mangeVehicle;
	
	/**
	 * @return 用户主要负责的车辆类型有哪些
	 */
	@Column
	public String getMangeVehicle() {
		return mangeVehicle;
	}
	public void setMangeVehicle(String mangeVehicle) {
		this.mangeVehicle = mangeVehicle;
	}
	private int manageKm;
	
	/**
	 * @return 用户主要负责的管理科目
	 */
	@Column
	public int getManageKm() {
		return manageKm;
	}
	public void setManageKm(int manageKm) {
		this.manageKm = manageKm;
	}
	private String glbm = "";
	/**
	 * @return 用户所属的管理部门代码
	 */
	@Column
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	/**
	 * @return 用户所属的发证机关
	 */
	@Column
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	private String fzjg="";
	

}
