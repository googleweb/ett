package com.ett.self.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_opt_log")
public class OperateLogObject extends BaseEntity {

	private String sfzmhm;
	
	private String detail;
	
	private String logType;
	
	/**
	 * @return 日志操作者的身份证明号码
	 */
	@Column(length=18)
	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	/**
	 * @return 具体的操作内容
	 */
	@Column(length=200)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return 操作的类型，由代码具体定义
	 */
	@Column
	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
