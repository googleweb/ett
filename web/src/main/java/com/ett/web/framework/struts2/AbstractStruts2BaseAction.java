/**
 * 
 */
package com.ett.web.framework.struts2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.ett.common.exception.NoRightException;
import com.ett.web.framework.AbstractBaseAction;
import com.ett.web.framework.IBaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author chen
 * 抽象的基本Struts2Action的基类，不断增强中
 */
public abstract class AbstractStruts2BaseAction extends AbstractBaseAction {

	@Override
	public String getRemoteAddr() {
		
		return this.getCurrentRequest().getRemoteAddr();
	}

	@Override
	public HttpServletResponse getCurrentResponse() {
		
		return ServletActionContext.getResponse();
	}

	@Override
	public HttpServletRequest getCurrentRequest() {
		return ServletActionContext.getRequest();
	}
	
	//return ServletActionContext.getRequest();

}
