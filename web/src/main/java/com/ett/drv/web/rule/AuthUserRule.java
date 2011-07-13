package com.ett.drv.web.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ett.drv.model.admin.UserModel;
import com.smartken.kia.core.filter.IVerifyRule;
import com.smartken.kia.core.util.StringUtil;

public class AuthUserRule implements IVerifyRule {

	public static String AUTH_USER="authUser";
	
	public boolean doVerifyRule(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		boolean isVerify=false;
		try{
		Object obj=req.getSession().getAttribute(AUTH_USER);
		UserModel user=(UserModel)obj;
		if(user!=null&&StringUtil.isNotBlank(user.getCLoginName())){
			isVerify=true;
		}
		}catch (Exception e) {
			// TODO: handle exception
			isVerify=false;
		}
		return isVerify;
	}

}
