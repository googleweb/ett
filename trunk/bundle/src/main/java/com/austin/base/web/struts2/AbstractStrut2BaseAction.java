/**
 * 
 */
package com.austin.base.web.struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.austin.base.web.AbstractBaseAction;

/**
 * @author austin
 *
 */
public abstract class AbstractStrut2BaseAction extends AbstractBaseAction {
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

}
