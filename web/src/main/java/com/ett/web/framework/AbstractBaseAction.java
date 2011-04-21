/**
 * 
 */
package com.ett.web.framework;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author austin
 *
 */
public abstract class AbstractBaseAction  implements IBaseAction {
	public abstract String getRemoteAddr();


	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AbstractBaseAction.class);

	

	

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#renderHtml(java.lang.String)
	 */
	public void renderHtml(String text) {
		if (logger.isDebugEnabled()) {
			logger.debug("renderHtml(String) - start");
		}

		render(text,"text/html;charset=UTF-8");

		if (logger.isDebugEnabled()) {
			logger.debug("renderHtml(String) - end");
		}
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#renderXML(java.lang.String)
	 */
	public void renderXML(String text) {
		if (logger.isDebugEnabled()) {
			logger.debug("renderXML(String) - start");
		}

		render(text,"text/xml;charset=UTF-8");

		if (logger.isDebugEnabled()) {
			logger.debug("renderXML(String) - end");
		}
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#renderText(java.lang.String)
	 */
	public void renderText(String text) {
		if (logger.isDebugEnabled()) {
			logger.debug("renderText(String) - start");
		}

		render(text,"text/plain;charset=UTF-8");

		if (logger.isDebugEnabled()) {
			logger.debug("renderText(String) - end");
		}
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#render(java.lang.String, java.lang.String)
	 */
	public void render(String text, String contentType) {
		if (logger.isDebugEnabled()) {
			logger.debug("render(String, String) - start");
		}

		try {
			HttpServletResponse response=this.getCurrentResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			logger.error("render(String, String)", e);
			
			//logger.error(e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("render(String, String) - end");
		}
	}


	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getRealPath(java.lang.String)
	 */
	public  String getRealPath(String relativePath)
	{
		return this.getHttpSession().getServletContext().getRealPath(relativePath);
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getSession()
	 */
	public  HttpSession getHttpSession()
	{
		return this.getCurrentRequest().getSession();
	}

	public abstract boolean checkUserRight(String rightId);

	public void setHttpSession(String key, Object value) {
		this.getHttpSession().setAttribute(key, value);
		
	}
	public void getHttpSession(String key) {
		this.getHttpSession().getAttribute(key);
		
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#clearHttpSession()
	 */
	public void clearHttpSession() {
		this.getHttpSession().invalidate();
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#removeHttpSession(java.lang.String)
	 */
	public void removeHttpSession(String key) {
		this.getHttpSession().removeAttribute(key);
		
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#setHtmlAttribute(java.lang.String, java.lang.Object)
	 */
	public void setHtmlAttribute(String key, Object value) {
		this.getCurrentRequest().setAttribute(key, value);
		
	}

	
	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getAttributeOrParamter(java.lang.String)
	 */
	public String getHtmlAttributeOrParamter(String key) {
		Object obj=this.getHtmlAttribute(key);
		if(obj!=null)
			return obj.toString();
		else
			return this.getParamter(key);
		// TODO Auto-generated method stub

		
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getAttribute(java.lang.String)
	 */
	public Object getHtmlAttribute(String key) {
		
		return this.getCurrentRequest().getAttribute(key);
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getParamter(java.lang.String)
	 */
	public String getParamter(String key) {
		
		return this.getCurrentRequest().getParameter(key);
	}

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#setFailerrors(java.lang.String)
	 */
	public String goFailPage(String failerrors) {
		this.success=false;
       this.hintMsg=failerrors;
       return ErrorPage;
       
	}
	
	

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#goSuccessPage(java.lang.String)
	 */
	public String goSuccessPage(String successHint) {
		this.success=true;
		this.hintMsg=successHint;
		return HintPage;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getCurrentResponse()
	 */
	public abstract HttpServletResponse getCurrentResponse();
	
	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#getCurrentRequest()
	 */
	public abstract HttpServletRequest getCurrentRequest();
	

	/* (non-Javadoc)
	 * @see com.ett.web.framework.IBaseAction#checkRight(java.lang.String)
	 */
	public boolean checkRight(String rightId) {
		if (logger.isDebugEnabled()) {
			logger.debug("checkRight(String) - start");
		}

		// TODO Auto-generated method stub

		if (logger.isDebugEnabled()) {
			logger.debug("checkRight(String) - end");
		}
		return true;
	}
	
	
	private boolean success=true;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 提示语
	 */
	public String getHintMsg() {
		return hintMsg;
	}

	/**
	 * 提示语
	 */
	public void setHintMsg(String hintMsg) {
		this.hintMsg = hintMsg;
	}

	/**
	 * 提示语
	 */
	private String hintMsg="";

	
	
}
