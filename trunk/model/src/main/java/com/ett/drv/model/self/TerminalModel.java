package com.ett.drv.model.self;

import com.smartken.kia.core.model.impl.BaseModel;

public class TerminalModel extends BaseModel {

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
	@Override
	public Enum[] enumFields() {
		// TODO Auto-generated method stub
		return TerminalModel.F.values();
	}





	public static enum F{
		id,glbm,fzjg,name,catalog,mac1,mac2,ip1,ip2,address,ylwgUrl,
		ylwgTimout,driverUrl,driverTimeout,carUrl,carTimeout,vioUrl,vioTimeout,descp
	}
	
	
	
	

	private Integer id;         //ID  NUMBER 5
	private String glbm;         //GLBM  VARCHAR2 12
	private String fzjg;         //FZJG  VARCHAR2 15
	private String name;         //NAME  VARCHAR2 32
	private String catalog;         //CATALOG  VARCHAR2 32
	private String mac1;         //MAC1  VARCHAR2 20
	private String mac2;         //MAC2  VARCHAR2 20
	private String ip1;         //IP1  VARCHAR2 20
	private String ip2;         //IP2  VARCHAR2 20
	private String address;         //ADDRESS  VARCHAR2 150
	private String ylwgUrl;         //YLWG_URL  VARCHAR2 50
	private Integer ylwgTimout;         //YLWG_TIMOUT  NUMBER 5
	private String driverUrl;         //DRIVER_URL  VARCHAR2 150
	private Integer driverTimeout;         //DRIVER_TIMEOUT  NUMBER 5
	private String carUrl;         //CAR_URL  VARCHAR2 150
	private Integer carTimeout;         //CAR_TIMEOUT  NUMBER 5
	private String vioUrl;         //VIO_URL  VARCHAR2 150
	private Integer vioTimeout;         //VIO_TIMEOUT  NUMBER 5
	private String descp;         //DESCP  VARCHAR2 150
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getYlwgUrl() {
		return ylwgUrl;
	}
	public void setYlwgUrl(String ylwgUrl) {
		this.ylwgUrl = ylwgUrl;
	}
	public Integer getYlwgTimout() {
		return ylwgTimout;
	}
	public void setYlwgTimout(Integer ylwgTimout) {
		this.ylwgTimout = ylwgTimout;
	}
	public String getDriverUrl() {
		return driverUrl;
	}
	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}
	public Integer getDriverTimeout() {
		return driverTimeout;
	}
	public void setDriverTimeout(Integer driverTimeout) {
		this.driverTimeout = driverTimeout;
	}
	public String getCarUrl() {
		return carUrl;
	}
	public void setCarUrl(String carUrl) {
		this.carUrl = carUrl;
	}
	public Integer getCarTimeout() {
		return carTimeout;
	}
	public void setCarTimeout(Integer carTimeout) {
		this.carTimeout = carTimeout;
	}
	public String getVioUrl() {
		return vioUrl;
	}
	public void setVioUrl(String vioUrl) {
		this.vioUrl = vioUrl;
	}
	public Integer getVioTimeout() {
		return vioTimeout;
	}
	public void setVioTimeout(Integer vioTimeout) {
		this.vioTimeout = vioTimeout;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	
	
	
}
