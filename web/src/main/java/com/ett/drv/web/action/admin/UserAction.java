package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseAction;
import com.ett.drv.web.filter.AuthFilter;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class UserAction extends BaseAction implements ModelDriven<UserModel> {

	private UserModel _userModel;
	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}	
	public String do_login(){
		String loginName=this.getParameter(UserModel.F.CLoginName);
		String pwd=this.getParameter(UserModel.F.CPwd);
		_userModel=adminBiz.login(loginName, pwd);
		if(_userModel!=null){
		   this.setSessionAttribute(AuthFilter.AUTH_USER, _userModel);
		   return "login_success";
		}else {
		   return "login_fail";
		}
	}
	public UserModel getModel() {
		if(isGet()){
			int id=ObjectUtil.formatInt(this.getParameter("id"));
			if(id==0)
			{
				_userModel=new UserModel();
			}else{
				this.adminBiz.loadCrudMapper(UserModel.class);
				_userModel=(UserModel) this.adminBiz.getModelEqPk(id);
			}
		}
		return _userModel;
	}
	@SuppressWarnings("unchecked")
	public void datagrid_users(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		this.adminBiz.loadCrudMapper(UserModel.class);
		List list=this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());		
	}	
	public String to_editUser(){
	    return "jsp";
	}	
	public void  do_editUser(){
		int re=0;
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(UserModel.class);
			re+=this.adminBiz.modifyOrAddModel(_userModel);
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(_userModel.getId()==null){
				pattern="用户管理:{0}保存成功,再添加一个用户？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="用户管理:{0}保存成功";
			}
			resultModel.setMsg(pattern,re);;
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
    @SuppressWarnings("unchecked")
	public void do_deleteUser(){
    	//根据id删除User，，并输出json格式的保存结果
    	ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.adminBiz.loadCrudMapper(UserModel.class);
             re+=this.adminBiz.removeModelInPk(lListIds);
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个用户",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有用户被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   	
    }
    @SuppressWarnings("unchecked")
	public void combobox_deptid(){
    	ArrayList lListKscc = null;
		try {
			lListKscc = adminBiz.listSchool(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray lJsonKscc= ObjectUtil.toJsonArray(lListKscc);
		this.writePlainText(lJsonKscc.toString());
    }
}