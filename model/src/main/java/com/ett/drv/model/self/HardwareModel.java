package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class HardwareModel extends BaseModel {


	 
		@Override
	public Enum[] enumFields() {
		// TODO Auto-generated method stub
		return HardwareModel.F.values();
	}

		
		 public static enum F { 
			  Id,CCreateip,TCreatetime,CCreator,IIsdeleted,CDescription,CKeywords,CModifier,CModifyip,TModifytime,IBaud,
			CBrand,CCatalog,ICom,IDeviceId,IStopbits  
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
			private Double IBaud;         //I_BAUD  NUMBER 10
			private String CBrand;         //C_BRAND  VARCHAR2 64
			private String CCatalog;         //C_CATALOG  VARCHAR2 64
			private Double ICom;         //I_COM  NUMBER 10
			private Double IDeviceId;         //I_DEVICE_ID  NUMBER 19
			private Double IStopbits;         //I_STOPBITS  NUMBER 10
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
			public Double getIBaud() {
				return IBaud;
			}
			public void setIBaud(Double iBaud) {
				IBaud = iBaud;
			}
			public String getCBrand() {
				return CBrand;
			}
			public void setCBrand(String cBrand) {
				CBrand = cBrand;
			}
			public String getCCatalog() {
				return CCatalog;
			}
			public void setCCatalog(String cCatalog) {
				CCatalog = cCatalog;
			}
			public Double getICom() {
				return ICom;
			}
			public void setICom(Double iCom) {
				ICom = iCom;
			}
			public Double getIDeviceId() {
				return IDeviceId;
			}
			public void setIDeviceId(Double iDeviceId) {
				IDeviceId = iDeviceId;
			}
			public Double getIStopbits() {
				return IStopbits;
			}
			public void setIStopbits(Double iStopbits) {
				IStopbits = iStopbits;
			}
			
			
			
		
}
