package com.ett.self.fee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_fee_log")
public class FeeObject  extends BaseEntity {
	
	public static final String CashFee="现金缴费";
	public static final String VisaFee="银联卡缴费";
	public static final String GuiTaiFee="柜台缴费";
	
	public static final String PersonBusFee="驾驶人业务";
	public static final String VehicleBusFee="机动车业务";
	public static final String VioBusFee="违法业务";
	
	private String xm;
	
	private String sfzmhm;
	
	private String detail;
	
	private String busType;
	
	private String feeType;
	
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
	 * @return 缴费方式 1、银联卡 2、现金
	 */
	@Column(length=30)
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
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

	private int money;

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
