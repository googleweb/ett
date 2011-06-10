package com.ett.drv.model.self;

import java.sql.Timestamp;

import com.smartken.kia.core.model.impl.BaseModel;

public class DeviceModel extends BaseModel {

	
	 public static enum F { 
		  Id,CCreateip,TCreatetime,CCreator,IIsdeleted,CDescription,CKeywords,CModifier,CModifyip,TModifytime,CCatalog,
		IDrvInterfaceTimeout,CDrvInterfaceUrl,CFzjg,CGlbmCode,CGlbmName,CIp1,CIp2,CKsddCode,CKsddName,CMac1,
		CMac2,CMachineName,CPlaceAddress,BoolIspreasignall,IVehInterfaceTimeout,CVehInterfaceUrl,IVioInterfaceTimeout,CVioInterfaceUrl,IYlwgTimeout,CYlwgUrl,
		IAllowPreasignDays,BoolIsFeeATime,BoolIsFeeByVisacard,BoolIsPostFeeAll,BoolIsPrintCompany,CDefaultKsccCode,CDefaultKsccName,IFeeInterfaceTimeout,CFeeInterfaceUrl,Devicetype,
		CMc2  
		 } 

	 private Integer Id;         //ID  NUMBER 19
	 private String CCreateip;         //C_CREATEIP  VARCHAR2 1,020 设备Ip
	 private Timestamp TCreatetime;         //T_CREATETIME  TIMESTAMP 0
	 private String CCreator;         //C_CREATOR  VARCHAR2 120
	 private Integer IIsdeleted;         //I_ISDELETED  NUMBER 1
	 private String CDescription;         //C_DESCRIPTION  VARCHAR2 1,020
	 private String CKeywords;         //C_KEYWORDS  VARCHAR2 1,020
	 private String CModifier;         //C_MODIFIER  VARCHAR2 1,020
	 private String CModifyip;         //C_MODIFYIP  VARCHAR2 1,020
	 private Timestamp TModifytime;         //T_MODIFYTIME  TIMESTAMP 0
	 private String CCatalog;         //C_CATALOG  VARCHAR2 64 设备类型
	 private Integer IDrvInterfaceTimeout;         //I_DRV_INTERFACE_TIMEOUT  NUMBER 10 驾驶人接口timeout
	 private String CDrvInterfaceUrl;         //C_DRV_INTERFACE_URL  VARCHAR2 200 驾驶人接口URL
	 private String CFzjg;         //C_FZJG  VARCHAR2 20 发证机关
	 private String CGlbmCode;         //C_GLBM_CODE  VARCHAR2 20 管理部门代码
	 private String CGlbmName;         //C_GLBM_NAME  VARCHAR2 64 管理部门名称
	 private String CIp1;         //C_IP1  VARCHAR2 20 机器内网IP
	 private String CIp2;         //C_IP2  VARCHAR2 20外网IP
	 private String CKsddCode;         //C_KSDD_CODE  VARCHAR2 20 考试地点代码
	 private String CKsddName;         //C_KSDD_NAME  VARCHAR2 64考试地点名称
	 private String CMac1;         //C_MAC1  VARCHAR2 20 网卡地址
	 private String CMac2;         //C_MAC2  VARCHAR2 20网卡地址2
	 private String CMachineName;         //C_MACHINE_NAME  VARCHAR2 50 机器名
	 private String CPlaceAddress;         //C_PLACE_ADDRESS  VARCHAR2 200 放置地点
	 private Integer BoolIspreasignall;         //BOOL_ISPREASIGNALL  NUMBER 1 是否允许预约全部考场
	 private Integer IVehInterfaceTimeout;         //I_VEH_INTERFACE_TIMEOUT  NUMBER 10  机动车接口timeout
	 private String CVehInterfaceUrl;         //C_VEH_INTERFACE_URL  VARCHAR2 200 机动车接口URL
	 private Integer IVioInterfaceTimeout;         //I_VIO_INTERFACE_TIMEOUT  NUMBER 10  违法接口timeout
	 private String CVioInterfaceUrl;         //C_VIO_INTERFACE_URL  VARCHAR2 200 违法接口URL
	 private Integer IYlwgTimeout;         //I_YLWG_TIMEOUT  NUMBER 10
	 private String CYlwgUrl;         //C_YLWG_URL  VARCHAR2 200 网关地址
	 private Integer IAllowPreasignDays;         //I_ALLOW_PREASIGN_DAYS  NUMBER 10 允许预约的天数
	 private Integer BoolIsFeeATime;         //BOOL_IS_FEE_A_TIME  NUMBER 1 是否一次交费
	 private Integer BoolIsFeeByVisacard;         //BOOL_IS_FEE_BY_VISACARD  NUMBER 1 是否允许通过银联卡缴费
	 private Integer BoolIsPostFeeAll;         //BOOL_IS_POST_FEE_ALL  NUMBER 1  是否能允许邮政一次收费
	 private Integer BoolIsPrintCompany;         //BOOL_IS_PRINT_COMPANY  NUMBER 1 是否打印公司名称
	 private String CDefaultKsccCode;         //C_DEFAULT_KSCC_CODE  VARCHAR2 20 默认考试场次代码
	 private String CDefaultKsccName;         //C_DEFAULT_KSCC_NAME  VARCHAR2 64默认考试乘此名称
	 private Integer IFeeInterfaceTimeout;         //I_FEE_INTERFACE_TIMEOUT  NUMBER 10 缴费接口timeout
	 private String CFeeInterfaceUrl;         //C_FEE_INTERFACE_URL  VARCHAR2 200 缴费接口URL
	 private String Devicetype;         //DEVICETYPE  VARCHAR2 1,020 设备种类
	 private String CMc2;         //C_MC2  VARCHAR2 20
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
	public Timestamp getTModifytime() {
		return TModifytime;
	}
	public void setTModifytime(Timestamp tModifytime) {
		TModifytime = tModifytime;
	}
	public String getCCatalog() {
		return CCatalog;
	}
	public void setCCatalog(String cCatalog) {
		CCatalog = cCatalog;
	}
	public Integer getIDrvInterfaceTimeout() {
		return IDrvInterfaceTimeout;
	}
	public void setIDrvInterfaceTimeout(Integer iDrvInterfaceTimeout) {
		IDrvInterfaceTimeout = iDrvInterfaceTimeout;
	}
	public String getCDrvInterfaceUrl() {
		return CDrvInterfaceUrl;
	}
	public void setCDrvInterfaceUrl(String cDrvInterfaceUrl) {
		CDrvInterfaceUrl = cDrvInterfaceUrl;
	}
	public String getCFzjg() {
		return CFzjg;
	}
	public void setCFzjg(String cFzjg) {
		CFzjg = cFzjg;
	}
	public String getCGlbmCode() {
		return CGlbmCode;
	}
	public void setCGlbmCode(String cGlbmCode) {
		CGlbmCode = cGlbmCode;
	}
	public String getCGlbmName() {
		return CGlbmName;
	}
	public void setCGlbmName(String cGlbmName) {
		CGlbmName = cGlbmName;
	}
	public String getCIp1() {
		return CIp1;
	}
	public void setCIp1(String cIp1) {
		CIp1 = cIp1;
	}
	public String getCIp2() {
		return CIp2;
	}
	public void setCIp2(String cIp2) {
		CIp2 = cIp2;
	}
	public String getCKsddCode() {
		return CKsddCode;
	}
	public void setCKsddCode(String cKsddCode) {
		CKsddCode = cKsddCode;
	}
	public String getCKsddName() {
		return CKsddName;
	}
	public void setCKsddName(String cKsddName) {
		CKsddName = cKsddName;
	}
	public String getCMac1() {
		return CMac1;
	}
	public void setCMac1(String cMac1) {
		CMac1 = cMac1;
	}
	public String getCMac2() {
		return CMac2;
	}
	public void setCMac2(String cMac2) {
		CMac2 = cMac2;
	}
	public String getCMachineName() {
		return CMachineName;
	}
	public void setCMachineName(String cMachineName) {
		CMachineName = cMachineName;
	}
	public String getCPlaceAddress() {
		return CPlaceAddress;
	}
	public void setCPlaceAddress(String cPlaceAddress) {
		CPlaceAddress = cPlaceAddress;
	}
	public Integer getBoolIspreasignall() {
		return BoolIspreasignall;
	}
	public void setBoolIspreasignall(Integer boolIspreasignall) {
		BoolIspreasignall = boolIspreasignall;
	}
	public Integer getIVehInterfaceTimeout() {
		return IVehInterfaceTimeout;
	}
	public void setIVehInterfaceTimeout(Integer iVehInterfaceTimeout) {
		IVehInterfaceTimeout = iVehInterfaceTimeout;
	}
	public String getCVehInterfaceUrl() {
		return CVehInterfaceUrl;
	}
	public void setCVehInterfaceUrl(String cVehInterfaceUrl) {
		CVehInterfaceUrl = cVehInterfaceUrl;
	}
	public Integer getIVioInterfaceTimeout() {
		return IVioInterfaceTimeout;
	}
	public void setIVioInterfaceTimeout(Integer iVioInterfaceTimeout) {
		IVioInterfaceTimeout = iVioInterfaceTimeout;
	}
	public String getCVioInterfaceUrl() {
		return CVioInterfaceUrl;
	}
	public void setCVioInterfaceUrl(String cVioInterfaceUrl) {
		CVioInterfaceUrl = cVioInterfaceUrl;
	}
	public Integer getIYlwgTimeout() {
		return IYlwgTimeout;
	}
	public void setIYlwgTimeout(Integer iYlwgTimeout) {
		IYlwgTimeout = iYlwgTimeout;
	}
	public String getCYlwgUrl() {
		return CYlwgUrl;
	}
	public void setCYlwgUrl(String cYlwgUrl) {
		CYlwgUrl = cYlwgUrl;
	}
	public Integer getIAllowPreasignDays() {
		return IAllowPreasignDays;
	}
	public void setIAllowPreasignDays(Integer iAllowPreasignDays) {
		IAllowPreasignDays = iAllowPreasignDays;
	}
	public Integer getBoolIsFeeATime() {
		return BoolIsFeeATime;
	}
	public void setBoolIsFeeATime(Integer boolIsFeeATime) {
		BoolIsFeeATime = boolIsFeeATime;
	}
	public Integer getBoolIsFeeByVisacard() {
		return BoolIsFeeByVisacard;
	}
	public void setBoolIsFeeByVisacard(Integer boolIsFeeByVisacard) {
		BoolIsFeeByVisacard = boolIsFeeByVisacard;
	}
	public Integer getBoolIsPostFeeAll() {
		return BoolIsPostFeeAll;
	}
	public void setBoolIsPostFeeAll(Integer boolIsPostFeeAll) {
		BoolIsPostFeeAll = boolIsPostFeeAll;
	}
	public Integer getBoolIsPrintCompany() {
		return BoolIsPrintCompany;
	}
	public void setBoolIsPrintCompany(Integer boolIsPrintCompany) {
		BoolIsPrintCompany = boolIsPrintCompany;
	}
	public String getCDefaultKsccCode() {
		return CDefaultKsccCode;
	}
	public void setCDefaultKsccCode(String cDefaultKsccCode) {
		CDefaultKsccCode = cDefaultKsccCode;
	}
	public String getCDefaultKsccName() {
		return CDefaultKsccName;
	}
	public void setCDefaultKsccName(String cDefaultKsccName) {
		CDefaultKsccName = cDefaultKsccName;
	}
	public Integer getIFeeInterfaceTimeout() {
		return IFeeInterfaceTimeout;
	}
	public void setIFeeInterfaceTimeout(Integer iFeeInterfaceTimeout) {
		IFeeInterfaceTimeout = iFeeInterfaceTimeout;
	}
	public String getCFeeInterfaceUrl() {
		return CFeeInterfaceUrl;
	}
	public void setCFeeInterfaceUrl(String cFeeInterfaceUrl) {
		CFeeInterfaceUrl = cFeeInterfaceUrl;
	}
	public String getDevicetype() {
		return Devicetype;
	}
	public void setDevicetype(String devicetype) {
		Devicetype = devicetype;
	}
	public String getCMc2() {
		return CMc2;
	}
	public void setCMc2(String cMc2) {
		CMc2 = cMc2;
	}
	 
	 

	
	
	
}
