package com.ett.drv.model.self;

import java.sql.Timestamp;
import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class Km1PreasignRecordModel extends BaseModel {

	 public static enum F { 
		  Id,CCreateip,TCreatetime,CCreator,IIsdeleted,CDescription,CKeywords,CModifier,CModifyip,TModifytime,Jxdm,
		Jxmc,Kscccode,Ksccname,Ksddcode,Ksddname,Ksrq,Lsh,Sfzmhm,Xm  
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
	 private String Jxdm;         //JXDM  VARCHAR2 1,020
	 private String Jxmc;         //JXMC  VARCHAR2 1,020
	 private String Kscccode;         //KSCCCODE  VARCHAR2 1,020
	 private String Ksccname;         //KSCCNAME  VARCHAR2 1,020
	 private String Ksddcode;         //KSDDCODE  VARCHAR2 1,020
	 private String Ksddname;         //KSDDNAME  VARCHAR2 1,020
	 private Timestamp Ksrq;         //KSRQ  TIMESTAMP 0
	 private String Lsh;         //LSH  VARCHAR2 1,020
	 private String Sfzmhm;         //SFZMHM  VARCHAR2 1,020
	 private String Xm;         //XM  VARCHAR2 1,020
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
		public String getJxdm() {
			return Jxdm;
		}
		public void setJxdm(String jxdm) {
			Jxdm = jxdm;
		}
		public String getJxmc() {
			return Jxmc;
		}
		public void setJxmc(String jxmc) {
			Jxmc = jxmc;
		}
		public String getKscccode() {
			return Kscccode;
		}
		public void setKscccode(String kscccode) {
			Kscccode = kscccode;
		}
		public String getKsccname() {
			return Ksccname;
		}
		public void setKsccname(String ksccname) {
			Ksccname = ksccname;
		}
		public String getKsddcode() {
			return Ksddcode;
		}
		public void setKsddcode(String ksddcode) {
			Ksddcode = ksddcode;
		}
		public String getKsddname() {
			return Ksddname;
		}
		public void setKsddname(String ksddname) {
			Ksddname = ksddname;
		}
		public Timestamp getKsrq() {
			return Ksrq;
		}
		public void setKsrq(Timestamp ksrq) {
			Ksrq = ksrq;
		}
		public String getLsh() {
			return Lsh;
		}
		public void setLsh(String lsh) {
			Lsh = lsh;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getXm() {
			return Xm;
		}
		public void setXm(String xm) {
			Xm = xm;
		}
	
	
	
	
	
}
