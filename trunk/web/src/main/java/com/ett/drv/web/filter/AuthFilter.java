package com.ett.drv.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ett.drv.model.admin.UserModel;

public class AuthFilter implements Filter {

	public static String AUTH_USER="authUser";
	
	
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest req=(HttpServletRequest) arg0;
		 HttpServletResponse rep=(HttpServletResponse) arg1;
		 String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
		 String loginName=req.getParameter("loginName");
		 String pwd=req.getParameter("pwd");
		 try{
         UserModel userModel=(UserModel) req.getSession(true).getAttribute(AUTH_USER);
         if(loginName!=null&&pwd!=null)
         {}
         else  if(userModel.getCLoginName()==null||userModel.getCPwd()==null){       	 
             rep.sendRedirect(basePath+"login.jsp");
         }
		 }catch(NullPointerException ex){
			 rep.sendRedirect(basePath+"login.jsp");
		 }
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
