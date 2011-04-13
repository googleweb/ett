/**
 * 
 */
package com.ett.model;

import javax.persistence.*;

/**
 * @author austin
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_person")
public class Person extends BaseEntity {
	
	private String fullName = "";
	private String nickName = "";
	private String pwd="";
	/**
	 * @return 用户全名
	 */
	@Column
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return 用户登录用的昵称
	 */
	@Column
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return 用户的密码
	 */
	@Column
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/* (non-Javadoc)
	 * @see com.ett.model.BaseEntity#toXml()
	 */
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String phone="";
	private String mobile="";
	private String computerIp="";
	
	
	private boolean lockIp;
	private String lockIpBegin="";
	private String lockIpEnd="";
	private boolean lockIpRange;
	
	private String address;
	
	/**
	 * @return 联系的固定电话
	 */
	@Column
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return 联系的移动电话
	 */
	@Column
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**

	 * @return 锁定范围的IP地址，先根据isLockIp判断
	 */
	@Column
	public String getComputerIp() {
		return computerIp;
	}
	public void setComputerIp(String computerIp) {
		this.computerIp = computerIp;
	}
	/**
	 * @return 是否锁定登陆用户的IP地址
	 */
	@Column
	public boolean isLockIp() {
		return lockIp;
	}
	public void setLockIp(boolean lockIp) {
		this.lockIp = lockIp;
	}
	/**
	 * @return 锁定范围的IP开始地址，先根据isLockIpRange判断
	 */
	@Column
	public String getLockIpBegin() {
		return lockIpBegin;
	}
	public void setLockIpBegin(String lockIpBegin) {
		this.lockIpBegin = lockIpBegin;
	}
	/**
	 * @return 锁定范围的IP结束地址，先根据isLockIpRange判断
	 */
	@Column
	public String getLockIpEnd() {
		return lockIpEnd;
	}
	public void setLockIpEnd(String lockIpEnd) {
		this.lockIpEnd = lockIpEnd;
	}
	/**
	 * @return 是否用锁定范围的IP用户才能登陆
	 */
	@Column
	public boolean isLockIpRange() {
		return lockIpRange;
	}
	public void setLockIpRange(boolean lockIpRange) {
		this.lockIpRange = lockIpRange;
	}
	/**
	 * @return 用户联系地址
	 */
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return 用户在公司的工号
	 */
	@Column
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	/**
	 * @return 部门ID
	 */
	@Column
	public long getDepId() {
		return depId;
	}
	public void setDepId(long depId) {
		this.depId = depId;
	}
	/**
	 * @return 部门名称
	 */
	@Column
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	/**
	 * @return 用户属于的角色Id
	 */
	@Column
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return 用户所属于的角色名字
	 */
	@Column
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String workId;
	
	private long depId;
	
	private String depName;
	
	private long roleId;
	
	private String roleName;
	
	

}
