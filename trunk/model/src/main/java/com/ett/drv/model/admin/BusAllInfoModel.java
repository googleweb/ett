package com.ett.drv.model.admin;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class BusAllInfoModel extends BaseModel {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum F { 
		  Id,CLsh,CDabh,CXm,CIdcardtype,CIdcard,CSex,CBirthday,CNation,CCarType,IState,
		COperator,Checkdate,Regdate,CRegareaCode,CRegarea,CPostcode,CPhone,CHeight,CZsl,CYsl,
		CBsl,CTl,CSz,CZxz,CYxz,CQgjb,CHospital,IPrintAdd,IPrintReturn,IsPrintAdd,
		IsPrintReturn  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CLsh;         //C_LSH  VARCHAR2 30
		private String CDabh;         //C_DABH  VARCHAR2 30
		private String CXm;         //C_XM  VARCHAR2 30
		private String CIdcardtype;         //C_IDCARDTYPE  VARCHAR2 30
		private String CIdcard;         //C_IDCARD  VARCHAR2 30
		private String CSex;         //C_SEX  VARCHAR2 8
		private String CBirthday;         //C_BIRTHDAY  VARCHAR2 30
		private String CNation;         //C_NATION  VARCHAR2 30
		private String CCarType;         //C_CAR_TYPE  VARCHAR2 8
		private Integer IState;         //I_STATE  NUMBER 38
		private String COperator;         //C_OPERATOR  VARCHAR2 30
		private String Checkdate;         //CHECKDATE  VARCHAR2 30
		private Date Regdate;         //REGDATE  DATE 0
		private String CRegareaCode;         //C_REGAREA_CODE  VARCHAR2 30
		private String CRegarea;         //C_REGAREA  VARCHAR2 100
		private String CPostcode;         //C_POSTCODE  VARCHAR2 20
		private String CPhone;         //C_PHONE  VARCHAR2 20
		private String CHeight;         //C_HEIGHT  VARCHAR2 8
		private String CZsl;         //C_ZSL  VARCHAR2 8
		private String CYsl;         //C_YSL  VARCHAR2 8
		private String CBsl;         //C_BSL  VARCHAR2 8
		private String CTl;         //C_TL  VARCHAR2 8
		private String CSz;         //C_SZ  VARCHAR2 8
		private String CZxz;         //C_ZXZ  VARCHAR2 8
		private String CYxz;         //C_YXZ  VARCHAR2 8
		private String CQgjb;         //C_QGJB  VARCHAR2 8
		private String CHospital;         //C_HOSPITAL  VARCHAR2 200
		private Integer IPrintAdd;         //I_PRINT_ADD  NUMBER 38
		private Integer IPrintReturn;         //I_PRINT_RETURN  NUMBER 38
		private Integer IsPrintAdd;         //IS_PRINT_ADD  NUMBER 38
		private Integer IsPrintReturn;         //IS_PRINT_RETURN  NUMBER 38
		private Date    beginDate;
		public Date getBeginDate() {
			return beginDate;
		}
		public void setBeginDate(Date beginDate) {
			this.beginDate = beginDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		private Date    endDate;
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCLsh() {
			return CLsh;
		}
		public void setCLsh(String cLsh) {
			CLsh = cLsh;
		}
		public String getCDabh() {
			return CDabh;
		}
		public void setCDabh(String cDabh) {
			CDabh = cDabh;
		}
		public String getCXm() {
			return CXm;
		}
		public void setCXm(String cXm) {
			CXm = cXm;
		}
		public String getCIdcardtype() {
			return CIdcardtype;
		}
		public void setCIdcardtype(String cIdcardtype) {
			CIdcardtype = cIdcardtype;
		}
		public String getCIdcard() {
			return CIdcard;
		}
		public void setCIdcard(String cIdcard) {
			CIdcard = cIdcard;
		}
		public String getCSex() {
			return CSex;
		}
		public void setCSex(String cSex) {
			CSex = cSex;
		}
		public String getCBirthday() {
			return CBirthday;
		}
		public void setCBirthday(String cBirthday) {
			CBirthday = cBirthday;
		}
		public String getCNation() {
			return CNation;
		}
		public void setCNation(String cNation) {
			CNation = cNation;
		}
		public String getCCarType() {
			return CCarType;
		}
		public void setCCarType(String cCarType) {
			CCarType = cCarType;
		}
		public Integer getIState() {
			return IState;
		}
		public void setIState(Integer iState) {
			IState = iState;
		}
		public String getCOperator() {
			return COperator;
		}
		public void setCOperator(String cOperator) {
			COperator = cOperator;
		}
		public String getCheckdate() {
			return Checkdate;
		}
		public void setCheckdate(String checkdate) {
			Checkdate = checkdate;
		}
		public Date getRegdate() {
			return Regdate;
		}
		public void setRegdate(Date regdate) {
			Regdate = regdate;
		}
		public String getCRegareaCode() {
			return CRegareaCode;
		}
		public void setCRegareaCode(String cRegareaCode) {
			CRegareaCode = cRegareaCode;
		}
		public String getCRegarea() {
			return CRegarea;
		}
		public void setCRegarea(String cRegarea) {
			CRegarea = cRegarea;
		}
		public String getCPostcode() {
			return CPostcode;
		}
		public void setCPostcode(String cPostcode) {
			CPostcode = cPostcode;
		}
		public String getCPhone() {
			return CPhone;
		}
		public void setCPhone(String cPhone) {
			CPhone = cPhone;
		}
		public String getCHeight() {
			return CHeight;
		}
		public void setCHeight(String cHeight) {
			CHeight = cHeight;
		}
		public String getCZsl() {
			return CZsl;
		}
		public void setCZsl(String cZsl) {
			CZsl = cZsl;
		}
		public String getCYsl() {
			return CYsl;
		}
		public void setCYsl(String cYsl) {
			CYsl = cYsl;
		}
		public String getCBsl() {
			return CBsl;
		}
		public void setCBsl(String cBsl) {
			CBsl = cBsl;
		}
		public String getCTl() {
			return CTl;
		}
		public void setCTl(String cTl) {
			CTl = cTl;
		}
		public String getCSz() {
			return CSz;
		}
		public void setCSz(String cSz) {
			CSz = cSz;
		}
		public String getCZxz() {
			return CZxz;
		}
		public void setCZxz(String cZxz) {
			CZxz = cZxz;
		}
		public String getCYxz() {
			return CYxz;
		}
		public void setCYxz(String cYxz) {
			CYxz = cYxz;
		}
		public String getCQgjb() {
			return CQgjb;
		}
		public void setCQgjb(String cQgjb) {
			CQgjb = cQgjb;
		}
		public String getCHospital() {
			return CHospital;
		}
		public void setCHospital(String cHospital) {
			CHospital = cHospital;
		}
		public Integer getIPrintAdd() {
			return IPrintAdd;
		}
		public void setIPrintAdd(Integer iPrintAdd) {
			IPrintAdd = iPrintAdd;
		}
		public Integer getIPrintReturn() {
			return IPrintReturn;
		}
		public void setIPrintReturn(Integer iPrintReturn) {
			IPrintReturn = iPrintReturn;
		}
		public Integer getIsPrintAdd() {
			return IsPrintAdd;
		}
		public void setIsPrintAdd(Integer isPrintAdd) {
			IsPrintAdd = isPrintAdd;
		}
		public Integer getIsPrintReturn() {
			return IsPrintReturn;
		}
		public void setIsPrintReturn(Integer isPrintReturn) {
			IsPrintReturn = isPrintReturn;
		}
	
 
  
}
