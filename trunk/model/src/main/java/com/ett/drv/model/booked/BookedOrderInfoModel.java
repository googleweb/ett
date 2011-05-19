package com.ett.drv.model.booked;

import com.smartken.kia.core.model.impl.BaseModel;

public class BookedOrderInfoModel extends BaseModel {

	public static enum F{
		id,hmhp,ksccCode,kscc,ksddCode,ksdd,km,dateKsrq,datePxshrq,paibanid,jbr,
		dlrCode,dlr,jlyIdcard,jlyXm,kssj,lsh,checkOperator,checkDate,checked,xm,
		idcard,checkResult,zjcx
	}
	
	private Integer id;         //ID  NUMBER 38
	private String hmhp;         //C_HMHP  VARCHAR2 30
	private String ksccCode;         //C_KSCC_CODE  VARCHAR2 30
	private String kscc;         //C_KSCC  VARCHAR2 200
	private String ksddCode;         //C_KSDD_CODE  VARCHAR2 30
	private String ksdd;         //C_KSDD  VARCHAR2 200
	private Integer km;         //I_KM  NUMBER 38
	private String dateKsrq;         //DATE_KSRQ  VARCHAR2 30
	private String datePxshrq;         //DATE_PXSHRQ  VARCHAR2 30
	private Integer paibanid;         //I_PAIBANID  NUMBER 38
	private String jbr;         //C_JBR  VARCHAR2 30
	private String dlrCode;         //C_DLR_CODE  VARCHAR2 30
	private String dlr;         //C_DLR  VARCHAR2 200
	private String jlyIdcard;         //C_JLY_IDCARD  VARCHAR2 30
	private String jlyXm;         //C_JLY_XM  VARCHAR2 30
	private String kssj;         //C_KSSJ  VARCHAR2 20
	private String lsh;         //C_LSH  VARCHAR2 20
	private String checkOperator;         //C_CHECK_OPERATOR  VARCHAR2 30
	private String checkDate;         //C_CHECK_DATE  VARCHAR2 30
	private Integer checked;         //I_CHECKED  NUMBER 38
	private String xm;         //C_XM  VARCHAR2 30
	private String idcard;         //C_IDCARD  VARCHAR2 30
	private String checkResult;         //C_CHECK_RESULT  VARCHAR2 1,000
	private String zjcx;         //C_ZJCX  VARCHAR2 30
	
	
	
	
	
	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getHmhp() {
		return hmhp;
	}





	public void setHmhp(String hmhp) {
		this.hmhp = hmhp;
	}





	public String getKsccCode() {
		return ksccCode;
	}





	public void setKsccCode(String ksccCode) {
		this.ksccCode = ksccCode;
	}





	public String getKscc() {
		return kscc;
	}





	public void setKscc(String kscc) {
		this.kscc = kscc;
	}





	public String getKsddCode() {
		return ksddCode;
	}





	public void setKsddCode(String ksddCode) {
		this.ksddCode = ksddCode;
	}





	public String getKsdd() {
		return ksdd;
	}





	public void setKsdd(String ksdd) {
		this.ksdd = ksdd;
	}





	public Integer getKm() {
		return km;
	}





	public void setKm(Integer km) {
		this.km = km;
	}





	public String getDateKsrq() {
		return dateKsrq;
	}





	public void setDateKsrq(String dateKsrq) {
		this.dateKsrq = dateKsrq;
	}





	public String getDatePxshrq() {
		return datePxshrq;
	}





	public void setDatePxshrq(String datePxshrq) {
		this.datePxshrq = datePxshrq;
	}





	public Integer getPaibanid() {
		return paibanid;
	}





	public void setPaibanid(Integer paibanid) {
		this.paibanid = paibanid;
	}





	public String getJbr() {
		return jbr;
	}





	public void setJbr(String jbr) {
		this.jbr = jbr;
	}





	public String getDlrCode() {
		return dlrCode;
	}





	public void setDlrCode(String dlrCode) {
		this.dlrCode = dlrCode;
	}





	public String getDlr() {
		return dlr;
	}





	public void setDlr(String dlr) {
		this.dlr = dlr;
	}





	public String getJlyIdcard() {
		return jlyIdcard;
	}





	public void setJlyIdcard(String jlyIdcard) {
		this.jlyIdcard = jlyIdcard;
	}





	public String getJlyXm() {
		return jlyXm;
	}





	public void setJlyXm(String jlyXm) {
		this.jlyXm = jlyXm;
	}





	public String getKssj() {
		return kssj;
	}





	public void setKssj(String kssj) {
		this.kssj = kssj;
	}





	public String getLsh() {
		return lsh;
	}





	public void setLsh(String lsh) {
		this.lsh = lsh;
	}





	public String getCheckOperator() {
		return checkOperator;
	}





	public void setCheckOperator(String checkOperator) {
		this.checkOperator = checkOperator;
	}





	public String getCheckDate() {
		return checkDate;
	}





	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}





	public Integer getChecked() {
		return checked;
	}





	public void setChecked(Integer checked) {
		this.checked = checked;
	}





	public String getXm() {
		return xm;
	}





	public void setXm(String xm) {
		this.xm = xm;
	}





	public String getIdcard() {
		return idcard;
	}





	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}





	public String getCheckResult() {
		return checkResult;
	}





	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}





	public String getZjcx() {
		return zjcx;
	}





	public void setZjcx(String zjcx) {
		this.zjcx = zjcx;
	}
	
	
	
	
	
	
}
