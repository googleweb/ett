package com.ett.drv.model.booked;

import java.math.BigDecimal;
import java.text.MessageFormat;

import com.smartken.kia.core.model.impl.BaseModel;

public class BookedLimitModel extends BaseModel{

	 
	 public static enum F { 
		  Id,IWeekNum,CCarType,IDayofweek,IKm,CSchoolCode,CSchoolName,DateKsrq,CKsccCode,CKscc,CKsddCode,
		CKsdd,ITotal,IUsedNum,ICheckedNum,ITptotal,ITpusedNum,ITpcheckedNum,COperator  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private Integer IWeekNum;         //I_WEEK_NUM  NUMBER 38
		private String CCarType;         //C_CAR_TYPE  VARCHAR2 30
		private Integer IDayofweek;         //I_DAYOFWEEK  NUMBER 38
		private Integer IKm;         //I_KM  NUMBER 38
		private String CSchoolCode;         //C_SCHOOL_CODE  VARCHAR2 20
		private String CSchoolName;         //C_SCHOOL_NAME  VARCHAR2 200
		private String DateKsrq;         //DATE_KSRQ  VARCHAR2 10
		private String CKsccCode;         //C_KSCC_CODE  VARCHAR2 20
		private String CKscc;         //C_KSCC  VARCHAR2 200
		private String CKsddCode;         //C_KSDD_CODE  VARCHAR2 20
		private String CKsdd;         //C_KSDD  VARCHAR2 200
		private Integer ITotal;         //I_TOTAL  NUMBER 38
		private Integer IUsedNum;         //I_USED_NUM  NUMBER 38
		private Integer ICheckedNum;         //I_CHECKED_NUM  NUMBER 38
		private Integer ITptotal;         //I_TPTOTAL  NUMBER 38
		private Integer ITpusedNum;         //I_TPUSED_NUM  NUMBER 38
		private Integer ITpcheckedNum;         //I_TPCHECKED_NUM  NUMBER 38
		private String COperator;         //C_OPERATOR  VARCHAR2 30

	
		public void init(){
			this.IUsedNum=0;
			this.ICheckedNum=0;
			this.ITptotal=0;
			this.ITpcheckedNum=0;
			this.ITotal=0;
			this.ITpusedNum=0;
		}
		

	public Integer getId() {
			return Id;
		}





		public void setId(Integer id) {
			Id = id;
		}





		public Integer getIWeekNum() {
			return IWeekNum;
		}





		public void setIWeekNum(Integer iWeekNum) {
			IWeekNum = iWeekNum;
		}





		public String getCCarType() {
			return CCarType;
		}





		public void setCCarType(String cCarType) {
			CCarType = cCarType;
		}





		public Integer getIDayofweek() {
			return IDayofweek;
		}





		public void setIDayofweek(Integer iDayofweek) {
			IDayofweek = iDayofweek;
		}





		public Integer getIKm() {
			return IKm;
		}





		public void setIKm(Integer iKm) {
			IKm = iKm;
		}





		public String getCSchoolCode() {
			return CSchoolCode;
		}





		public void setCSchoolCode(String cSchoolCode) {
			CSchoolCode = cSchoolCode;
		}





		public String getCSchoolName() {
			return CSchoolName;
		}





		public void setCSchoolName(String cSchoolName) {
			CSchoolName = cSchoolName;
		}





		public String getDateKsrq() {
			return DateKsrq;
		}





		public void setDateKsrq(String dateKsrq) {
			DateKsrq = dateKsrq;
		}





		public String getCKsccCode() {
			return CKsccCode;
		}





		public void setCKsccCode(String cKsccCode) {
			CKsccCode = cKsccCode;
		}





		public String getCKscc() {
			return CKscc;
		}





		public void setCKscc(String cKscc) {
			CKscc = cKscc;
		}





		public String getCKsddCode() {
			return CKsddCode;
		}





		public void setCKsddCode(String cKsddCode) {
			CKsddCode = cKsddCode;
		}





		public String getCKsdd() {
			return CKsdd;
		}





		public void setCKsdd(String cKsdd) {
			CKsdd = cKsdd;
		}





		public Integer getITotal() {
			return ITotal;
		}





		public void setITotal(Integer iTotal) {
			ITotal = iTotal;
		}





		public Integer getIUsedNum() {
			return IUsedNum;
		}





		public void setIUsedNum(Integer iUsedNum) {
			IUsedNum = iUsedNum;
		}





		public Integer getICheckedNum() {
			return ICheckedNum;
		}





		public void setICheckedNum(Integer iCheckedNum) {
			ICheckedNum = iCheckedNum;
		}





		public Integer getITptotal() {
			return ITptotal;
		}





		public void setITptotal(Integer iTptotal) {
			ITptotal = iTptotal;
		}





		public Integer getITpusedNum() {
			return ITpusedNum;
		}





		public void setITpusedNum(Integer iTpusedNum) {
			ITpusedNum = iTpusedNum;
		}





		public Integer getITpcheckedNum() {
			return ITpcheckedNum;
		}





		public void setITpcheckedNum(Integer iTpcheckedNum) {
			ITpcheckedNum = iTpcheckedNum;
		}





		public String getCOperator() {
			return COperator;
		}





		public void setCOperator(String cOperator) {
			COperator = cOperator;
		}





	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
        String key=MessageFormat.format("{0}_{1}_{2}_{3}_{4}_{5}",
        		this.IWeekNum,  //0
        		this.IDayofweek,  //1
        		this.IKm,   //2
        		this.CKsccCode,  //3
        		this.CKsddCode,  //4
        		this.CSchoolCode  //5
        );
        //this.setPk(key);
		return key;
	}

	
	
	
}
