package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class DeviceSnModel extends BaseModel {


	 public static enum F { 
		  Id,CCreateip,TCreatetime,CCreator,IIsdeleted,CDescription,CKeywords,CModifier,CModifyip,TModifytime,CDeviceIp,
		CJkname,CJkid,CJkxlh,CSn,CXtlb  
		 } 

		private Double Id;         //ID  NUMBER 19
		private String CCreateip;         //C_CREATEIP  VARCHAR2 1,020
		private Timestamp TCreatetime;         //T_CREATETIME  TIMESTAMP 0
		private String CCreator;         //C_CREATOR  VARCHAR2 120
		private Double IIsdeleted;         //I_ISDELETED  NUMBER 1
		private String CDescription;         //C_DESCRIPTION  VARCHAR2 1,020
		private String CKeywords;         //C_KEYWORDS  VARCHAR2 1,020
		private String CModifier;         //C_MODIFIER  VARCHAR2 1,020
		private String CModifyip;         //C_MODIFYIP  VARCHAR2 1,020
		private Timestamp TModifytime;         //T_MODIFYTIME  TIMESTAMP 0
		private String CDeviceIp;         //C_DEVICE_IP  VARCHAR2 64
		private String CJkname;         //C_JKNAME  VARCHAR2 64
		private String CJkid;         //C_JKID  VARCHAR2 64
		private String CJkxlh;         //C_JKXLH  VARCHAR2 64
		private String CSn;         //C_SN  VARCHAR2 64
		private String CXtlb;         //C_XTLB  VARCHAR2 64
		public Double getId() {
			return Id;
		}
		public void setId(Double id) {
			Id = id;
		}
		public String getCCreateip() {
			return CCreateip;
		}
		public void setCCreateip(String cCreateip) {
			CCreateip = cCreateip;
		}
		public Timestamp getTCreatetime() {
			return TCreatetime;
		}
		public void setTCreatetime(Timestamp tCreatetime) {
			TCreatetime = tCreatetime;
		}
		public String getCCreator() {
			return CCreator;
		}
		public void setCCreator(String cCreator) {
			CCreator = cCreator;
		}
		public Double getIIsdeleted() {
			return IIsdeleted;
		}
		public void setIIsdeleted(Double iIsdeleted) {
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
		public Timestamp getTModifytime() {
			return TModifytime;
		}
		public void setTModifytime(Timestamp tModifytime) {
			TModifytime = tModifytime;
		}
		public String getCDeviceIp() {
			return CDeviceIp;
		}
		public void setCDeviceIp(String cDeviceIp) {
			CDeviceIp = cDeviceIp;
		}
		public String getCJkname() {
			return CJkname;
		}
		public void setCJkname(String cJkname) {
			CJkname = cJkname;
		}
		public String getCJkid() {
			return CJkid;
		}
		public void setCJkid(String cJkid) {
			CJkid = cJkid;
		}
		public String getCJkxlh() {
			return CJkxlh;
		}
		public void setCJkxlh(String cJkxlh) {
			CJkxlh = cJkxlh;
		}
		public String getCSn() {
			return CSn;
		}
		public void setCSn(String cSn) {
			CSn = cSn;
		}
		public String getCXtlb() {
			return CXtlb;
		}
		public void setCXtlb(String cXtlb) {
			CXtlb = cXtlb;
		}
		
		
		
	
}
