package com.ett.drv.web.action.admin;

import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseAction;
import com.ett.drv.web.filter.AuthFilter;

public class UserAction extends BaseAction implements ModelDriven<UserModel> {

	private UserModel _userModel;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	
	public String do_login(){
		String loginName=this.getParameter(UserModel.F.loginName);
		String pwd=this.getParameter(UserModel.F.pwd);
		_userModel=adminBiz.login(loginName, pwd);
		if(_userModel!=null){
		   this.setSessionAttribute(AuthFilter.AUTH_USER, _userModel);
		   return "login_success";
		}else {
		   return "login_fail";
		}
	}


	public UserModel getModel() {
		// TODO Auto-generated method stub
		return _userModel;
	}
}
