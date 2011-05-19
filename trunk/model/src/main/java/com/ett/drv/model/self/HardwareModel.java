package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class HardwareModel extends BaseModel {

	 public static enum F { 
		  id,createip,createtime,creator,isdeleted,description,keywords,modifier,modifyip,modifytime,baud,
		brand,catalog,com,deviceId,stopbits  
		 } 
	 
	 

		@Override
	public Enum[] enumFields() {
		// TODO Auto-generated method stub
		return HardwareModel.F.values();
	}
		private Integer id;         //ID  NUMBER 19
		private String createip;         //C_CREATEIP  VARCHAR2 1,020
		private Timestamp createtime;         //T_CREATETIME  TIMESTAMP 0
		private String creator;         //C_CREATOR  VARCHAR2 120
		private Integer isdeleted;         //I_ISDELETED  NUMBER 1
		private String description;         //C_DESCRIPTION  VARCHAR2 1,020
		private String keywords;         //C_KEYWORDS  VARCHAR2 1,020
		private String modifier;         //C_MODIFIER  VARCHAR2 1,020
		private String modifyip;         //C_MODIFYIP  VARCHAR2 1,020
		private Timestamp modifytime;         //T_MODIFYTIME  TIMESTAMP 0
		private Integer baud;         //I_BAUD  NUMBER 10
		private String brand;         //C_BRAND  VARCHAR2 64
		private String catalog;         //C_CATALOG  VARCHAR2 64
		private Integer com;         //I_COM  NUMBER 10
		private Integer deviceId;         //I_DEVICE_ID  NUMBER 19
		private Integer stopbits;         //I_STOPBITS  NUMBER 10
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCreateip() {
			return createip;
		}
		public void setCreateip(String createip) {
			this.createip = createip;
		}
		public Timestamp getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Timestamp createtime) {
			this.createtime = createtime;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public Integer getIsdeleted() {
			return isdeleted;
		}
		public void setIsdeleted(Integer isdeleted) {
			this.isdeleted = isdeleted;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public String getModifier() {
			return modifier;
		}
		public void setModifier(String modifier) {
			this.modifier = modifier;
		}
		public String getModifyip() {
			return modifyip;
		}
		public void setModifyip(String modifyip) {
			this.modifyip = modifyip;
		}
		public Timestamp getModifytime() {
			return modifytime;
		}
		public void setModifytime(Timestamp modifytime) {
			this.modifytime = modifytime;
		}
		public Integer getBaud() {
			return baud;
		}
		public void setBaud(Integer baud) {
			this.baud = baud;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getCatalog() {
			return catalog;
		}
		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}
		public Integer getCom() {
			return com;
		}
		public void setCom(Integer com) {
			this.com = com;
		}
		public Integer getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(Integer deviceId) {
			this.deviceId = deviceId;
		}
		public Integer getStopbits() {
			return stopbits;
		}
		public void setStopbits(Integer stopbits) {
			this.stopbits = stopbits;
		}
		
		
		
}
