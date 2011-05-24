package com.ett.drv.model.booked;

import java.math.BigDecimal;
import java.text.MessageFormat;

import com.smartken.kia.core.model.impl.BaseModel;

public class BookedLimitModel extends BaseModel{

	 public static enum F { 
		  id,iweekNum,ccarType,idayofweek,ikm,cschoolCode,cschoolName,dateKsrq,cksccCode,ckscc,cksddCode,
		cksdd,itotal,iusedNum,icheckedNum,itptotal,itpusedNum,itpcheckedNum,coperator  
		 } 

		private Integer id;         //ID  NUMBER 38
		private Integer iweekNum;         //I_WEEK_NUM  NUMBER 38
		private String ccarType;         //C_CAR_TYPE  VARCHAR2 30
		private Integer idayofweek;         //I_DAYOFWEEK  NUMBER 38
		private Integer ikm;         //I_KM  NUMBER 38
		private String cschoolCode;         //C_SCHOOL_CODE  VARCHAR2 20
		private String cschoolName;         //C_SCHOOL_NAME  VARCHAR2 200
		private String dateKsrq;         //DATE_KSRQ  VARCHAR2 10
		private String cksccCode;         //C_KSCC_CODE  VARCHAR2 20
		private String ckscc;         //C_KSCC  VARCHAR2 200
		private String cksddCode;         //C_KSDD_CODE  VARCHAR2 20
		private String cksdd;         //C_KSDD  VARCHAR2 200
		private Integer itotal;         //I_TOTAL  NUMBER 38
		private Integer iusedNum;         //I_USED_NUM  NUMBER 38
		private Integer icheckedNum;         //I_CHECKED_NUM  NUMBER 38
		private Integer itptotal;         //I_TPTOTAL  NUMBER 38
		private Integer itpusedNum;         //I_TPUSED_NUM  NUMBER 38
		private Integer itpcheckedNum;         //I_TPCHECKED_NUM  NUMBER 38
		private String coperator;         //C_OPERATOR  VARCHAR2 30

	
		
		
	public Integer getId() {
			return id;
		}




		public void setId(Integer id) {
			this.id = id;
		}




		public Integer getIweekNum() {
			return iweekNum;
		}




		public void setIweekNum(Integer iweekNum) {
			this.iweekNum = iweekNum;
		}




		public String getCcarType() {
			return ccarType;
		}




		public void setCcarType(String ccarType) {
			this.ccarType = ccarType;
		}




		public Integer getIdayofweek() {
			return idayofweek;
		}




		public void setIdayofweek(Integer idayofweek) {
			this.idayofweek = idayofweek;
		}




		public Integer getIkm() {
			return ikm;
		}




		public void setIkm(Integer ikm) {
			this.ikm = ikm;
		}




		public String getCschoolCode() {
			return cschoolCode;
		}




		public void setCschoolCode(String cschoolCode) {
			this.cschoolCode = cschoolCode;
		}




		public String getCschoolName() {
			return cschoolName;
		}




		public void setCschoolName(String cschoolName) {
			this.cschoolName = cschoolName;
		}




		public String getDateKsrq() {
			return dateKsrq;
		}




		public void setDateKsrq(String dateKsrq) {
			this.dateKsrq = dateKsrq;
		}




		public String getCksccCode() {
			return cksccCode;
		}




		public void setCksccCode(String cksccCode) {
			this.cksccCode = cksccCode;
		}




		public String getCkscc() {
			return ckscc;
		}




		public void setCkscc(String ckscc) {
			this.ckscc = ckscc;
		}




		public String getCksddCode() {
			return cksddCode;
		}




		public void setCksddCode(String cksddCode) {
			this.cksddCode = cksddCode;
		}




		public String getCksdd() {
			return cksdd;
		}




		public void setCksdd(String cksdd) {
			this.cksdd = cksdd;
		}




		public Integer getItotal() {
			return itotal;
		}




		public void setItotal(Integer itotal) {
			this.itotal = itotal;
		}




		public Integer getIusedNum() {
			return iusedNum;
		}




		public void setIusedNum(Integer iusedNum) {
			this.iusedNum = iusedNum;
		}




		public Integer getIcheckedNum() {
			return icheckedNum;
		}




		public void setIcheckedNum(Integer icheckedNum) {
			this.icheckedNum = icheckedNum;
		}




		public Integer getItptotal() {
			return itptotal;
		}




		public void setItptotal(Integer itptotal) {
			this.itptotal = itptotal;
		}




		public Integer getItpusedNum() {
			return itpusedNum;
		}




		public void setItpusedNum(Integer itpusedNum) {
			this.itpusedNum = itpusedNum;
		}




		public Integer getItpcheckedNum() {
			return itpcheckedNum;
		}




		public void setItpcheckedNum(Integer itpcheckedNum) {
			this.itpcheckedNum = itpcheckedNum;
		}




		public String getCoperator() {
			return coperator;
		}




		public void setCoperator(String coperator) {
			this.coperator = coperator;
		}




	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
        String key=MessageFormat.format("{0}_{1}_{2}_{3}_{4}_{5}",
        		this.iweekNum,  //0
        		this.idayofweek,  //1
        		this.ikm,   //2
        		this.cksccCode,  //3
        		this.cksddCode,  //4
        		this.cschoolCode  //5
        );
        //this.setPk(key);
		return key;
	}

	
	
	
}
