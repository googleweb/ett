/**
 * 
 */
package com.ett.self.fee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

/**
 * @author austin
 * 收费标准对象
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_fee_standard")
public class FeeStandard extends BaseEntity {
	
	public  int ywlx;
	
	public  String ywlxName;
	
	public String description;
	
	public int money;

	/**
	 * @return 业务类型代码
	 */
	@Column
	public int getYwlx() {
		return ywlx;
	}

	public void setYwlx(int ywlx) {
		this.ywlx = ywlx;
	}

	/**
	 * @return 业务类型名称
	 */
	@Column
	public String getYwlxName() {
		return ywlxName;
	}

	public void setYwlxName(String ywlxName) {
		this.ywlxName = ywlxName;
	}

	/**
	 * @return 备注
	 */
	@Column(length=300)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 业务金额
	 */
	@Column
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
