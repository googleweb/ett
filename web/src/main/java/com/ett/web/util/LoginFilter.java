/**
 * 
 */
package com.ett.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;


/**
 * @author chen
 * 
 */
public class LoginFilter implements Filter {
	
	protected Logger log = Logger.getLogger(this.getClass());

	private static String[] excludes = null; // 不用做权限判断的URL

	private static String[] suffixes = null;// 需要验证的后缀
	
	private static String loginUrl="/login.action";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		Assert.notEmpty(excludes);
		Assert.notEmpty(suffixes);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean haveFind = false;
		String uri = req.getRequestURI();
		if(uri.endsWith(".js")||uri.endsWith(".gif")
				||uri.endsWith(".jpg")||uri.endsWith(".png")
				||uri.endsWith(".jpeg")||uri.endsWith(".css")||uri.endsWith(".ico"))
		{
			chain.doFilter(req, res);
		}
		else
		{
			log.debug("via the uri ->" + uri);
			for (int i = 0; i < excludes.length; i++) {
				if (uri.indexOf(excludes[i]) >= 0) {
					log
							.debug("find the uri in the excludes list index->" + i);
					haveFind = true;
					break;
				}
			}
			if (!haveFind) {
				boolean tmp = false;
				// System.out.println("req.getRequestURI()==="+req.getRequestURI());
				for (int i = 0; i < suffixes.length; i++) {
					if (uri.indexOf(suffixes[i]) >= 0) {
						log
								.debug("find the uri suffix in suffixes list->" + i);
						tmp = true;
						break;
	
					}
				}
				if (tmp) {
	
					// System.out.println("haveFind==="+haveFind);
	
					if (req.getSession().getAttribute(HttpUtil.Login_User_Constant) == null) {
						log
								.debug("the session can't find the loginuser attribute!");
						log.debug("开始跳转到"+req.getContextPath()
								+ this.loginUrl);
						res.sendRedirect(req.getContextPath()
								+ this.loginUrl);
						log.debug("跳转完成，返回");
						
						return;
						// System.out.println("----redirect----");
						//return;
					}
				}
			}
			chain.doFilter(req, res);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		String tmp = filterConfig.getInitParameter("excludes");
		String tmpSuffix = filterConfig.getInitParameter("suffixes");
		this.loginUrl=filterConfig.getInitParameter("loginurl");
		this.excludes = tmp.split(";");
		this.suffixes = tmpSuffix.split(";");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}
}
