package com.ett.drv.model.booked;

import com.smartken.kia.core.model.impl.BaseModel;

public class ExtraAssignModel extends BaseModel {

	 public static enum F { 
		  Id,IKm,CSchoolCode,CSchoolName,DateKsrq,CKsccCode,CKscc,CKsddCode,CKsdd,ITotal,COperator  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private Integer IKm;         //I_KM  NUMBER 38
		private String CSchoolCode;         //C_SCHOOL_CODE  VARCHAR2 20
		private String CSchoolName;         //C_SCHOOL_NAME  VARCHAR2 200
		private String DateKsrq;         //DATE_KSRQ  VARCHAR2 10
		private String CKsccCode;         //C_KSCC_CODE  VARCHAR2 20
		private String CKscc;         //C_KSCC  VARCHAR2 200
		private String CKsddCode;         //C_KSDD_CODE  VARCHAR2 10
		private String CKsdd;         //C_KSDD  VARCHAR2 200
		private Integer ITotal;         //I_TOTAL  NUMBER 38
		private String COperator;         //C_OPERATOR  VARCHAR2 30
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
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
		public String getCOperator() {
			return COperator;
		}
		public void setCOperator(String cOperator) {
			COperator = cOperator;
		}
		
		
		

}
