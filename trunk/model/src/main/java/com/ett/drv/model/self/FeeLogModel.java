package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class FeeLogModel extends BaseModel {

	 public static enum F { 
		  Id,CCreateip,TCreatetime,CCreator,IIsdeleted,CDescription,CKeywords,CModifier,CModifyip,TModifytime,Bustype,
		Detail,Feetype,Money,Sfzmhm,Visacard,Xm,Feelsh,Postfee,Feewaytype,Relationid,
		ISyn  
		 } 

	 private Integer Id;         //ID  NUMBER 19
	 private String CCreateip;         //C_CREATEIP  VARCHAR2 1,020
	 private Date TCreatetime;         //T_CREATETIME  DATE 0
	 private String CCreator;         //C_CREATOR  VARCHAR2 120
	 private Integer IIsdeleted;         //I_ISDELETED  NUMBER 1
	 private String CDescription;         //C_DESCRIPTION  VARCHAR2 1,020
	 private String CKeywords;         //C_KEYWORDS  VARCHAR2 1,020
	 private String CModifier;         //C_MODIFIER  VARCHAR2 1,020
	 private String CModifyip;         //C_MODIFYIP  VARCHAR2 1,020
	 private Date TModifytime;         //T_MODIFYTIME  DATE 0
	 private String Bustype;         //BUSTYPE  VARCHAR2 120
	 private String Detail;         //DETAIL  VARCHAR2 800
	 private String Feetype;         //FEETYPE  VARCHAR2 120
	 private Integer Money;         //MONEY  NUMBER 10
	 private String Sfzmhm;         //SFZMHM  VARCHAR2 72
	 private String Visacard;         //VISACARD  VARCHAR2 120
	 private String Xm;         //XM  VARCHAR2 120
	 private String Feelsh;         //FEELSH  VARCHAR2 1,056
	 private Integer Postfee;         //POSTFEE  NUMBER 10
	 private String Feewaytype;         //FEEWAYTYPE  VARCHAR2 120
	 private String Relationid;         //RELATIONID  VARCHAR2 1,020
	 private Integer ISyn;         //I_SYN  NUMBER 1
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCCreateip() {
			return CCreateip;
		}
		public void setCCreateip(String cCreateip) {
			CCreateip = cCreateip;
		}
		public Date getTCreatetime() {
			return TCreatetime;
		}
		public void setTCreatetime(Date tCreatetime) {
			TCreatetime = tCreatetime;
		}
		public String getCCreator() {
			return CCreator;
		}
		public void setCCreator(String cCreator) {
			CCreator = cCreator;
		}
		public Integer getIIsdeleted() {
			return IIsdeleted;
		}
		public void setIIsdeleted(Integer iIsdeleted) {
			IIsdeleted = iIsdeleted;
		}
		public String getCDescription() {
			return CDescription;
		}
		public void setCDescription(String cDescription) {
			CDescription = cDescription;
		}
		public String getCKeywords() {
			return CKeywords;
		}
		public void setCKeywords(String cKeywords) {
			CKeywords = cKeywords;
		}
		public String getCModifier() {
			return CModifier;
		}
		public void setCModifier(String cModifier) {
			CModifier = cModifier;
		}
		public String getCModifyip() {
			return CModifyip;
		}
		public void setCModifyip(String cModifyip) {
			CModifyip = cModifyip;
		}
		public Date getTModifytime() {
			return TModifytime;
		}
		public void setTModifytime(Date tModifytime) {
			TModifytime = tModifytime;
		}
		public String getBustype() {
			return Bustype;
		}
		public void setBustype(String bustype) {
			Bustype = bustype;
		}
		public String getDetail() {
			return Detail;
		}
		public void setDetail(String detail) {
			Detail = detail;
		}
		public String getFeetype() {
			return Feetype;
		}
		public void setFeetype(String feetype) {
			Feetype = feetype;
		}
		public Integer getMoney() {
			return Money;
		}
		public void setMoney(Integer money) {
			Money = money;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getVisacard() {
			return Visacard;
		}
		public void setVisacard(String visacard) {
			Visacard = visacard;
		}
		public String getXm() {
			return Xm;
		}
		public void setXm(String xm) {
			Xm = xm;
		}
		public String getFeelsh() {
			return Feelsh;
		}
		public void setFeelsh(String feelsh) {
			Feelsh = feelsh;
		}
		public Integer getPostfee() {
			return Postfee;
		}
		public void setPostfee(Integer postfee) {
			Postfee = postfee;
		}
		public String getFeewaytype() {
			return Feewaytype;
		}
		public void setFeewaytype(String feewaytype) {
			Feewaytype = feewaytype;
		}
		public String getRelationid() {
			return Relationid;
		}
		public void setRelationid(String relationid) {
			Relationid = relationid;
		}
		public Integer getISyn() {
			return ISyn;
		}
		public void setISyn(Integer iSyn) {
			ISyn = iSyn;
		}
	
	
	
}
