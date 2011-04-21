/**
 * 
 */
package com.ett.self.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ett.drvinterface.entity.BaseDrvRequest;
import com.ett.model.BaseEntity;

/**
 * @author austin
 * 放置自助终端需要调用接口的各种sn的表
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_self_device_sn")
public class SelfDeviceSnObject extends BaseEntity {
	
	/**
	 * @param request 把接口的SN赋值给基本的webservice请求
	 */
	public void CopyToBaseDrvRequest(BaseDrvRequest request)
	{
	    request.setJkid(this.getJkid());
	    request.setJkxlh(this.getJkxlh());
	    request.setSn(this.getSn());
	    request.setXtlb(this.getXtlb());
	}
	
	public static final String Preasign="考试预约";
	
	public static final String PersonApply="驾驶人预录入";
	
	public static final String VehicleApply="机动车预录入";
	
	public static final String PersonPhotoWrite="写入驾驶人照片";
	
	public static final String PersonPhotoRead="读取驾驶人照片";
	
	public static final String FeeWrite="缴费写入接口";
	public static final String FeeRead="缴费记录查询";
	public static final String VioQuery="违法信息查询";
	public static final String VioProcess="违法处理";
	
	private String deviceIp;
	private String jkName;
	
	/**
	 * @return 设备IP
	 */
	@Column(name="c_device_ip",nullable=true,columnDefinition=" varchar2(64)")
	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	/**
	 * @return 返回接口的名称
	 */
	@Column(name="c_jkName",nullable=true,columnDefinition=" varchar2(64)")
	public String getJkName() {
		return jkName;
	}

	public void setJkName(String jkName) {
		this.jkName = jkName;
	}

	/**
	 * @return 系统类别
	 */
	@Column(name="c_xtlb",nullable=true,columnDefinition=" varchar2(64)")
	public String getXtlb() {
		return xtlb;
	}

	public void setXtlb(String xtlb) {
		this.xtlb = xtlb;
	}

	/**
	 * @return 接口序列号
	 */
	@Column(name="c_jkxlh",nullable=true,columnDefinition=" varchar2(64)")
	public String getJkxlh() {
		return jkxlh;
	}

	public void setJkxlh(String jkxlh) {
		this.jkxlh = jkxlh;
	}

	/**
	 * @return 接口ID
	 */
	@Column(name="c_jkid",nullable=true,columnDefinition=" varchar2(64)")
	public String getJkid() {
		return jkid;
	}

	public void setJkid(String jkid) {
		this.jkid = jkid;
	}

	/**
	 * @return 接口用到的sn
	 */
	@Column(name="c_sn",nullable=true,columnDefinition=" varchar2(64)")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	private String xtlb;
	
	private String jkxlh;
	private String jkid;
	private String sn;

	/* (non-Javadoc)
	 * @see com.ett.model.BaseEntity#toXml()
	 */
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
