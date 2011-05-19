package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class DeviceSnModel extends BaseModel {


	 public static enum F { 
		  id,createip,createtime,creator,isdeleted,description,keywords,modifier,modifyip,modifytime,deviceIp,
		jkname,jkid,jkxlh,sn,xtlb  
		 } 
	 
	 

		@Override
	public Enum[] enumFields() {
		// TODO Auto-generated method stub
		return DeviceModel.F.values();
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
		private String deviceIp;         //C_DEVICE_IP  VARCHAR2 64
		private String jkname;         //C_JKNAME  VARCHAR2 64
		private String jkid;         //C_JKID  VARCHAR2 64
		private String jkxlh;         //C_JKXLH  VARCHAR2 64
		private String sn;         //C_SN  VARCHAR2 64
		private String xtlb;         //C_XTLB  VARCHAR2 64
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
		public String getDeviceIp() {
			return deviceIp;
		}
		public void setDeviceIp(String deviceIp) {
			this.deviceIp = deviceIp;
		}
		public String getJkname() {
			return jkname;
		}
		public void setJkname(String jkname) {
			this.jkname = jkname;
		}
		public String getJkid() {
			return jkid;
		}
		public void setJkid(String jkid) {
			this.jkid = jkid;
		}
		public String getJkxlh() {
			return jkxlh;
		}
		public void setJkxlh(String jkxlh) {
			this.jkxlh = jkxlh;
		}
		public String getSn() {
			return sn;
		}
		public void setSn(String sn) {
			this.sn = sn;
		}
		public String getXtlb() {
			return xtlb;
		}
		public void setXtlb(String xtlb) {
			this.xtlb = xtlb;
		}
	
	
}
