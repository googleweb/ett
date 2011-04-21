/**
 * 
 */
package com.ett.drvinterface.entity;

/**
 * @author austin
 *
 */
public class BaseFeeDrvRequest extends BaseDrvRequest {
	
	public static final String delete_VEH_VALIDATE="delete_VEH_VALIDATE";
	public static final String write_VEH_VALIDATE="write_VEH_VALIDATE";
	public static final String update_VEH_VALIDATE="update_VEH_VALIDATE";
	
	public static final String write_drv_Check="write_drv_Check";
	public static final String update_drv_Check="update_drv_Check";
	public static final String delete_drv_Check="delete_drv_Check";
	
	public String getHeader(String operation)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("<request><head><encode>UTF-8</encode><target>Police</target><operation>");
		sb.append(operation);
		sb.append("</operation></head><body><fields>");
		return sb.toString();
	}
	
	public String getEnd()
	{
		return "</fields></body></request>";
	}
	
	private String userIp;
	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	private String userCode;
	
	private String deptCode;

	/* (non-Javadoc)
	 * @see com.ett.drvinterface.entity.BaseDrvRequest#toXml()
	 */
	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
