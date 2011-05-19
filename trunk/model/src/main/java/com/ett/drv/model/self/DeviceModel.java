package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class DeviceModel extends BaseModel {

	public static enum F { 
		  id,createip,createtime,creator,isdeleted,description,keywords,modifier,modifyip,modifytime,catalog,
		drvInterfaceTimeout,drvInterfaceUrl,fzjg,glbmCode,glbmName,ip1,ip2,ksddCode,ksddName,mac1,
		mac2,machineName,placeAddress,boolIspreasignall,vehInterfaceTimeout,vehInterfaceUrl,vioInterfaceTimeout,vioInterfaceUrl,ylwgTimeout,ylwgUrl,
		allowPreasignDays,boolIsFeeATime,boolIsFeeByVisacard,boolIsPostFeeAll,boolIsPrintCompany,defaultKsccCode,defaultKsccName,feeInterfaceTimeout,feeInterfaceUrl,devicetype,
		mc2  
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
		private String catalog;         //C_CATALOG  VARCHAR2 64
		private Integer drvInterfaceTimeout;         //I_DRV_INTERFACE_TIMEOUT  NUMBER 10
		private String drvInterfaceUrl;         //C_DRV_INTERFACE_URL  VARCHAR2 200
		private String fzjg;         //C_FZJG  VARCHAR2 20
		private String glbmCode;         //C_GLBM_CODE  VARCHAR2 20
		private String glbmName;         //C_GLBM_NAME  VARCHAR2 64
		private String ip1;         //C_IP1  VARCHAR2 20
		private String ip2;         //C_IP2  VARCHAR2 20
		private String ksddCode;         //C_KSDD_CODE  VARCHAR2 20
		private String ksddName;         //C_KSDD_NAME  VARCHAR2 64
		private String mac1;         //C_MAC1  VARCHAR2 20
		private String mac2;         //C_MAC2  VARCHAR2 20
		private String machineName;         //C_MACHINE_NAME  VARCHAR2 50
		private String placeAddress;         //C_PLACE_ADDRESS  VARCHAR2 200
		private Integer boolIspreasignall;         //BOOL_ISPREASIGNALL  NUMBER 1
		private Integer vehInterfaceTimeout;         //I_VEH_INTERFACE_TIMEOUT  NUMBER 10
		private String vehInterfaceUrl;         //C_VEH_INTERFACE_URL  VARCHAR2 200
		private Integer vioInterfaceTimeout;         //I_VIO_INTERFACE_TIMEOUT  NUMBER 10
		private String vioInterfaceUrl;         //C_VIO_INTERFACE_URL  VARCHAR2 200
		private Integer ylwgTimeout;         //I_YLWG_TIMEOUT  NUMBER 10
		private String ylwgUrl;         //C_YLWG_URL  VARCHAR2 200
		private Integer allowPreasignDays;         //I_ALLOW_PREASIGN_DAYS  NUMBER 10
		private Integer boolIsFeeATime;         //BOOL_IS_FEE_A_TIME  NUMBER 1
		private Integer boolIsFeeByVisacard;         //BOOL_IS_FEE_BY_VISACARD  NUMBER 1
		private Integer boolIsPostFeeAll;         //BOOL_IS_POST_FEE_ALL  NUMBER 1
		private Integer boolIsPrintCompany;         //BOOL_IS_PRINT_COMPANY  NUMBER 1
		private String defaultKsccCode;         //C_DEFAULT_KSCC_CODE  VARCHAR2 20
		private String defaultKsccName;         //C_DEFAULT_KSCC_NAME  VARCHAR2 64
		private Integer feeInterfaceTimeout;         //I_FEE_INTERFACE_TIMEOUT  NUMBER 10
		private String feeInterfaceUrl;         //C_FEE_INTERFACE_URL  VARCHAR2 200
		private String devicetype;         //DEVICETYPE  VARCHAR2 1,020
		private String mc2;         //C_MC2  VARCHAR2 20
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
		public String getCatalog() {
			return catalog;
		}
		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}
		public Integer getDrvInterfaceTimeout() {
			return drvInterfaceTimeout;
		}
		public void setDrvInterfaceTimeout(Integer drvInterfaceTimeout) {
			this.drvInterfaceTimeout = drvInterfaceTimeout;
		}
		public String getDrvInterfaceUrl() {
			return drvInterfaceUrl;
		}
		public void setDrvInterfaceUrl(String drvInterfaceUrl) {
			this.drvInterfaceUrl = drvInterfaceUrl;
		}
		public String getFzjg() {
			return fzjg;
		}
		public void setFzjg(String fzjg) {
			this.fzjg = fzjg;
		}
		public String getGlbmCode() {
			return glbmCode;
		}
		public void setGlbmCode(String glbmCode) {
			this.glbmCode = glbmCode;
		}
		public String getGlbmName() {
			return glbmName;
		}
		public void setGlbmName(String glbmName) {
			this.glbmName = glbmName;
		}
		public String getIp1() {
			return ip1;
		}
		public void setIp1(String ip1) {
			this.ip1 = ip1;
		}
		public String getIp2() {
			return ip2;
		}
		public void setIp2(String ip2) {
			this.ip2 = ip2;
		}
		public String getKsddCode() {
			return ksddCode;
		}
		public void setKsddCode(String ksddCode) {
			this.ksddCode = ksddCode;
		}
		public String getKsddName() {
			return ksddName;
		}
		public void setKsddName(String ksddName) {
			this.ksddName = ksddName;
		}
		public String getMac1() {
			return mac1;
		}
		public void setMac1(String mac1) {
			this.mac1 = mac1;
		}
		public String getMac2() {
			return mac2;
		}
		public void setMac2(String mac2) {
			this.mac2 = mac2;
		}
		public String getMachineName() {
			return machineName;
		}
		public void setMachineName(String machineName) {
			this.machineName = machineName;
		}
		public String getPlaceAddress() {
			return placeAddress;
		}
		public void setPlaceAddress(String placeAddress) {
			this.placeAddress = placeAddress;
		}
		public Integer getBoolIspreasignall() {
			return boolIspreasignall;
		}
		public void setBoolIspreasignall(Integer boolIspreasignall) {
			this.boolIspreasignall = boolIspreasignall;
		}
		public Integer getVehInterfaceTimeout() {
			return vehInterfaceTimeout;
		}
		public void setVehInterfaceTimeout(Integer vehInterfaceTimeout) {
			this.vehInterfaceTimeout = vehInterfaceTimeout;
		}
		public String getVehInterfaceUrl() {
			return vehInterfaceUrl;
		}
		public void setVehInterfaceUrl(String vehInterfaceUrl) {
			this.vehInterfaceUrl = vehInterfaceUrl;
		}
		public Integer getVioInterfaceTimeout() {
			return vioInterfaceTimeout;
		}
		public void setVioInterfaceTimeout(Integer vioInterfaceTimeout) {
			this.vioInterfaceTimeout = vioInterfaceTimeout;
		}
		public String getVioInterfaceUrl() {
			return vioInterfaceUrl;
		}
		public void setVioInterfaceUrl(String vioInterfaceUrl) {
			this.vioInterfaceUrl = vioInterfaceUrl;
		}
		public Integer getYlwgTimeout() {
			return ylwgTimeout;
		}
		public void setYlwgTimeout(Integer ylwgTimeout) {
			this.ylwgTimeout = ylwgTimeout;
		}
		public String getYlwgUrl() {
			return ylwgUrl;
		}
		public void setYlwgUrl(String ylwgUrl) {
			this.ylwgUrl = ylwgUrl;
		}
		public Integer getAllowPreasignDays() {
			return allowPreasignDays;
		}
		public void setAllowPreasignDays(Integer allowPreasignDays) {
			this.allowPreasignDays = allowPreasignDays;
		}
		public Integer getBoolIsFeeATime() {
			return boolIsFeeATime;
		}
		public void setBoolIsFeeATime(Integer boolIsFeeATime) {
			this.boolIsFeeATime = boolIsFeeATime;
		}
		public Integer getBoolIsFeeByVisacard() {
			return boolIsFeeByVisacard;
		}
		public void setBoolIsFeeByVisacard(Integer boolIsFeeByVisacard) {
			this.boolIsFeeByVisacard = boolIsFeeByVisacard;
		}
		public Integer getBoolIsPostFeeAll() {
			return boolIsPostFeeAll;
		}
		public void setBoolIsPostFeeAll(Integer boolIsPostFeeAll) {
			this.boolIsPostFeeAll = boolIsPostFeeAll;
		}
		public Integer getBoolIsPrintCompany() {
			return boolIsPrintCompany;
		}
		public void setBoolIsPrintCompany(Integer boolIsPrintCompany) {
			this.boolIsPrintCompany = boolIsPrintCompany;
		}
		public String getDefaultKsccCode() {
			return defaultKsccCode;
		}
		public void setDefaultKsccCode(String defaultKsccCode) {
			this.defaultKsccCode = defaultKsccCode;
		}
		public String getDefaultKsccName() {
			return defaultKsccName;
		}
		public void setDefaultKsccName(String defaultKsccName) {
			this.defaultKsccName = defaultKsccName;
		}
		public Integer getFeeInterfaceTimeout() {
			return feeInterfaceTimeout;
		}
		public void setFeeInterfaceTimeout(Integer feeInterfaceTimeout) {
			this.feeInterfaceTimeout = feeInterfaceTimeout;
		}
		public String getFeeInterfaceUrl() {
			return feeInterfaceUrl;
		}
		public void setFeeInterfaceUrl(String feeInterfaceUrl) {
			this.feeInterfaceUrl = feeInterfaceUrl;
		}
		public String getDevicetype() {
			return devicetype;
		}
		public void setDevicetype(String devicetype) {
			this.devicetype = devicetype;
		}
		public String getMc2() {
			return mc2;
		}
		public void setMc2(String mc2) {
			this.mc2 = mc2;
		}
	
	
	
	
}
