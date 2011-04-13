/**
 * 
 */
package com.ett.self;

import org.apache.struts2.ServletActionContext;

import com.ett.web.framework.struts2.AbstractStruts2BaseAction;
import com.ett.web.util.HttpUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author austin
 *
 */
public class BaseSelfAction extends AbstractStruts2BaseAction {
	/**
	 * 自助终端的用户Session中的key
	 */
	public static final String Self_User_Constant="self_user_constant";
	
	public SelfDeviceUser getUser()
	{
		Object obj=ServletActionContext.getRequest().getSession().getAttribute(Self_User_Constant);
		if(obj==null)
		{
			return null;
		}
		return (SelfDeviceUser)obj;
		
	}
	
	public void setUser(SelfDeviceUser user)
	{
		ServletActionContext.getRequest().getSession().setAttribute(Self_User_Constant, user);
	}

	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}

}
