package com.ett.drv.web.action.admin;

import java.util.ArrayList;

import org.json.JSONObject;

import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseAction;
import com.ett.drv.web.filter.AuthFilter;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.util.EasyUiUtil;

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
	
	public void datagrid_users(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		this.adminBiz.loadCrudMapper(UserModel.class);
		ArrayList list=this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());
		
	}
	
	public String to_editUser(){
		//根据id查出一个User，跳到用户编辑页面
		this.adminBiz.loadCrudMapper(UserModel.class);
		this.adminBiz.getModel();
	    return "jsp";
	}
	
	public void to_saveUser(){
		//保存post进来的User到数据，并输出json格式的保存结果
	}
	
    public void to_removeUser(){
    	//根据id删除User，，并输出json格式的保存结果
    }
}
