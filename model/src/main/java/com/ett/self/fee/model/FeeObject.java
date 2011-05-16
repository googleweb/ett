package com.ett.self.fee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

/**
 * @author austin
 * 缴费对象
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_fee_log")
public class FeeObject  extends BaseEntity {
	
	
	
	private String relationId;
	
	@Column
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	private String xm;
	
	private String sfzmhm;
	
	private String detail;
	
	private String busType;
	
	private String feeWayType;
	
	private String visaCard;
	
	private String feeLsh;
	
	@Column(length=264)
	public String getFeeLsh() {
		return feeLsh;
	}

	public void setFeeLsh(String feeLsh) {
		this.feeLsh = feeLsh;
	}

	/**
	 * @return 缴费人姓名
	 */
	@Column(length=30)
	public String getXm() {
		return xm;
	}

	/**
	 * @param xm
	 */
	
	public void setXm(String xm) {
		this.xm = xm;
	}

	/**
	 * @return 缴费人身份证明号码
	 */
	@Column(length=18)
	public String getSfzmhm() {
		return sfzmhm;
	}

	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}

	/**
	 * @return 缴费针对的流水号或者相应的处罚决定书编号
	 */
	@Column(length=200)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return 缴费的业务类型 1、机动车，2。驾驶证、3、违法
	 * 具体类型由写入的时候定好
	 */
	@Column(length=30)
	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	

	/**
	 * @return 缴费方式，现金，银联，柜台
	 */
	@Column(length=30)
	public String getFeeWayType() {
		return feeWayType;
	}

	public void setFeeWayType(String feeWayType) {
		this.feeWayType = feeWayType;
	}

	/**
	 * @return 缴费的银联卡的卡号
	 */
	@Column(length=30)
	public String getVisaCard() {
		return visaCard;
	}

	public void setVisaCard(String visaCard) {
		this.visaCard = visaCard;
	}

	/**
	 * @return 缴费的金额
	 */
	@Column
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	private int postFee;

	/**
	 * @return 邮寄的金额费用
	 */
	@Column
	public int getPostFee() {
		return postFee;
	}

	public void setPostFee(int postFee) {
		this.postFee = postFee;
	}

	private int money;

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
