/**
 * 
 */
package com.ett.drvinterface.entity;

/**
 * @author austin
 *
 */
public class VehCheckRequest extends BaseFeeDrvRequest {

	/* (non-Javadoc)
	 * @see com.ett.drvinterface.entity.BaseDrvRequest#toXml()
	 */
	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer();
		this.appendTag(sb, "lsh", this.getLsh());
		this.appendTag(sb, "deptcode", this.getDeptCode());
		this.appendTag(sb, "usercode", this.getUserCode());
		this.appendTag(sb, "userip", this.getUserIp());
		return sb.toString();
	}
	
	public String toDeleteXml()
	{
		StringBuffer sb=new StringBuffer();
		this.appendTag(sb, "lsh", this.getLsh());
		this.appendTag(sb, "deptcode", this.getDeptCode());
		this.appendTag(sb, "usercode", this.getUserCode());
		this.appendTag(sb, "userip", this.getUserIp());
		return this.getHeader(BaseFeeDrvRequest.delete_VEH_VALIDATE)+sb.toString()+this.getEnd();
	}
}
