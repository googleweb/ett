/**
 * 
 */
package com.ett.self.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.model.BaseEntity;

/**
 * @author austin
 * 自助设备对象
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_device")
public class SelfDeviceObject extends BaseEntity {
	
	
	
	/**
	 * @return 管理部门单位的名称
	 */
	@Column(name="c_glbm_name",nullable=true,columnDefinition=" varchar2(64)")
	public String getGlbmName() {
		return glbmName;
	}

	public void setGlbmName(String glbmName) {
		this.glbmName = glbmName;
	}
	
	private String glbmName;
	
	private boolean isPostFeeAll;
	
	private boolean isFeeATime;
	
	private boolean isFeeByVisaCard;
	
	private int allowPreasignDays;
	
	private boolean isPrintCompany;
	
	
	

	/**
	 * @return 打印凭条的时候是否打印公司名称！
	 */
	@Column(name="bool_is_print_company")
	public boolean isPrintCompany() {
		return isPrintCompany;
	}

	public void setPrintCompany(boolean isPrintCompany) {
		this.isPrintCompany = isPrintCompany;
	}

	/**
	 * @return 允许预约的天数
	 */
	@Column(name="i_allow_preasign_days")
	public int getAllowPreasignDays() {
		return allowPreasignDays;
	}

	public void setAllowPreasignDays(int allowPreasignDays) {
		this.allowPreasignDays = allowPreasignDays;
	}

	/**
	 * @return 是否允许快递一次上门收取全部费用
	 */
	@Column(name="bool_is_post_fee_all")
	public boolean isPostFeeAll() {
		return isPostFeeAll;
	}

	public void setPostFeeAll(boolean isPostFeeAll) {
		this.isPostFeeAll = isPostFeeAll;
	}

	/**
	 * @return 是否一次全部收费，包含快递费
	 */
	@Column(name="bool_is_fee_a_time")
	public boolean isFeeATime() {
		return isFeeATime;
	}

	public void setFeeATime(boolean isFeeATime) {
		this.isFeeATime = isFeeATime;
	}

	/**
	 * @return 是否允许银联卡收费
	 */
	@Column(name="bool_is_fee_by_visacard")
	public boolean isFeeByVisaCard() {
		return isFeeByVisaCard;
	}

	public void setFeeByVisaCard(boolean isFeeByVisaCard) {
		this.isFeeByVisaCard = isFeeByVisaCard;
	}

	private String fzjg;
	
	/**
	 * @return 发证机关
	 */
	@Column(name="c_fzjg",nullable=true,columnDefinition=" varchar2(20)")
	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	
	private String machineName;
	
	/**
	 * @return 终端机器的名字
	 */
	@Column(name="c_machine_name",nullable=true,columnDefinition=" varchar2(50)")
	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	private String ip1;
	
	private String ip2;
	
	private String glbm;
	
	private boolean isPreasignAll;
	
	private String ksddCode;
	private String ksddName;
	
	private String defaulKsccCode;
	
	private String defaultKsccName;
	
	
	/**
	 * @return 默认的考试场次代码
	 */
	@Column(name="c_default_kscc_code",nullable=true,columnDefinition=" varchar2(20)")
	public String getDefaulKsccCode() {
		return defaulKsccCode;
	}

	public void setDefaulKsccCode(String defaulKsccCode) {
		this.defaulKsccCode = defaulKsccCode;
	}

	/**
	 * @return 默认的考试场次名称
	 */
	@Column(name="c_default_kscc_name",nullable=true,columnDefinition=" varchar2(64)")
	public String getDefaultKsccName() {
		return defaultKsccName;
	}

	public void setDefaultKsccName(String defaultKsccName) {
		this.defaultKsccName = defaultKsccName;
	}

	/**
	 * @return 考试地点代码
	 */
	@Column(name="c_ksdd_code",nullable=true,columnDefinition=" varchar2(20)")
	public String getKsddCode() {
		return ksddCode;
	}

	public void setKsddCode(String ksddCode) {
		this.ksddCode = ksddCode;
	}

	/**
	 * @return 考试地点名称
	 */
	@Column(name="c_ksdd_name",nullable=true,columnDefinition=" varchar2(64)")
	public String getKsddName() {
		return ksddName;
	}

	public void setKsddName(String ksddName) {
		this.ksddName = ksddName;
	}



	/**
	 * @return 终端对内IP
	 */
	@Column(name="c_ip1",nullable=true,columnDefinition=" varchar2(20)")
	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	/**
	 * @return 终端对外IP
	 */
	@Column(name="c_ip2",nullable=true,columnDefinition=" varchar2(20)")
	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	/**
	 * @return 管理部门代码
	 */
	@Column(name="c_glbm_code",nullable=false,columnDefinition=" varchar2(20)")
	public String getGlbm() {
		return glbm;
	}

	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}

	

	/**
	 * @return 是否允许预约全部场地，还是只能预约本考场
	 */
	@Column(name="bool_ispreasignall")
	public boolean isPreasignAll() {
		return isPreasignAll;
	}

	public void setPreasignAll(boolean isPreasignAll) {
		this.isPreasignAll = isPreasignAll;
	}
	private String catalog;

	/**
	 * @return 终端型号 比如单预约机等
	 */
	@Column(name="c_catalog",columnDefinition=" varchar2(64)")
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return MAC1地址
	 */
	@Column(name="c_mac1",columnDefinition=" varchar2(20)")
	public String getMac1() {
		return mac1;
	}

	public void setMac1(String mac1) {
		this.mac1 = mac1;
	}

	/**
	 * @return MAC2地址
	 */
	@Column(name="c_mc2",columnDefinition=" varchar2(20)")
	public String getMac2() {
		return mac2;
	}

	public void setMac2(String mac2) {
		this.mac2 = mac2;
	}

	/**
	 * @return 终端放置的位置
	 */
	@Column(name="c_place_address",columnDefinition=" varchar2(200)")
	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	/**
	 * @return 银联网关地址
	 */
	@Column(name="c_ylwg_url",columnDefinition=" varchar2(200)")
	public String getYlwgUrl() {
		return ylwgUrl;
	}

	public void setYlwgUrl(String ylwgUrl) {
		this.ylwgUrl = ylwgUrl;
	}

	/**
	 * @return 访问银行网关超时时间设置
	 */
	@Column(name="i_ylwg_timeout")
	public int getYlwgTimeout() {
		return ylwgTimeout;
	}

	public void setYlwgTimeout(int ylwgTimeout) {
		this.ylwgTimeout = ylwgTimeout;
	}

	/**
	 * @return 驾驶人服务接口地址
	 */
	@Column(name="c_drv_interface_url",columnDefinition=" varchar2(200)")
	public String getDrvInterfaceUrl() {
		return drvInterfaceUrl;
	}

	public void setDrvInterfaceUrl(String drvInterfaceUrl) {
		this.drvInterfaceUrl = drvInterfaceUrl;
	}

	/**
	 * @return 驾驶人服务超时时间设置
	 */
	@Column(name="i_drv_interface_timeout")
	public int getDrvInterfaceTimeout() {
		return drvInterfaceTimeout;
	}

	public void setDrvInterfaceTimeout(int drvInterfaceTimeout) {
		this.drvInterfaceTimeout = drvInterfaceTimeout;
	}

	/**
	 * @return 机动车服务接口地址
	 */
	@Column(name="c_veh_interface_url",columnDefinition=" varchar2(200)")
	public String getVehInterfaceUrl() {
		return vehInterfaceUrl;
	}

	public void setVehInterfaceUrl(String vehInterfaceUrl) {
		this.vehInterfaceUrl = vehInterfaceUrl;
	}

	/**
	 * @return 机动车服务超时时间设置
	 */
	@Column(name="i_veh_interface_timeout")
	public int getVehInterfaceTimeout() {
		return vehInterfaceTimeout;
	}

	public void setVehInterfaceTimeout(int vehInterfaceTimeout) {
		this.vehInterfaceTimeout = vehInterfaceTimeout;
	}

	/**
	 * @return 违法服务接口地址
	 */
	@Column(name="c_vio_interface_url",columnDefinition=" varchar2(200)")
	public String getVioInterfaceUrl() {
		return vioInterfaceUrl;
	}

	public void setVioInterfaceUrl(String vioInterfaceUrl) {
		this.vioInterfaceUrl = vioInterfaceUrl;
	}

	/**
	 * @return 违法服务超时时间设置
	 */
	@Column(name="i_vio_interface_timeout")
	public int getVioInterfaceTimeout() {
		return vioInterfaceTimeout;
	}

	public void setVioInterfaceTimeout(int vioInterfaceTimeout) {
		this.vioInterfaceTimeout = vioInterfaceTimeout;
	}
	
	/**
	 * @return 业务缴费服务地址
	 */
	@Column(name="c_fee_interface_url",columnDefinition=" varchar2(200)")
	public String getFeeInterfaceUrl() {
		return feeInterfaceUrl;
	}

	public void setFeeInterfaceUrl(String feeInterfaceUrl) {
		this.feeInterfaceUrl = feeInterfaceUrl;
	}
	/**
	 * @return 业务缴费服务超时时间设置
	 */
	@Column(name="i_fee_interface_timeout")
	public int getFeeInterfaceTimeout() {
		return feeInterfaceTimeout;
	}

	public void setFeeInterfaceTimeout(int feeInterfaceTimeout) {
		this.feeInterfaceTimeout = feeInterfaceTimeout;
	}

private String feeInterfaceUrl;
	
	private int feeInterfaceTimeout;

	private String mac1;
	private String mac2;
	
	private String placeAddress;
	
	private String ylwgUrl;
	private int ylwgTimeout;
	
	private String drvInterfaceUrl;
	private int drvInterfaceTimeout;
	
	private String vehInterfaceUrl;
	private int vehInterfaceTimeout;
	private String vioInterfaceUrl;
	private int vioInterfaceTimeout;
	
	

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
