package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class RoleAction extends BaseAction implements ModelDriven<RoleModel> {
	private RoleModel roleModel;

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public String to_index() {
		return "jsp";
	}

	public RoleModel getModel() {
		if (isGet()) {
			int id = ObjectUtil.formatInt(this.getParameter("id"));
			if (id == 0) {
				roleModel = new RoleModel();
			} else {
				this.adminBiz.loadCrudMapper(RoleModel.class);
				roleModel = (RoleModel) this.adminBiz.getModelEqPk(id);
			}
		}
		return roleModel;
	}
	@SuppressWarnings("unchecked")
	public void datagrid_role(){
		System.out.println("4");
		this.adminBiz.loadCrudMapper(RoleModel.class);
		List<IFormatterModel> list=(List<IFormatterModel>) this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());
	}
	public String to_addRole(){
		return "jsp";
	}
	public String to_modifyRole(){
		return "jsp";
	}
	public void  do_addRole(){
		int re=0;
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(RoleModel.class);
			re+=this.adminBiz.modifyOrAddModel(roleModel);
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			pattern="角色管理:{0}保存成功,再添加一个用户？";
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg(pattern,re);;
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void  do_modifyRole(){
		int re=0;
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(RoleModel.class);
			re+=this.adminBiz.modifyOrAddModel(roleModel);
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";			
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			pattern="用户管理:{0}保存成功";	
			resultModel.setMsg(pattern,re);;			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
		
	}
	public void  do_deleteRole(){
		ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.adminBiz.loadCrudMapper(RoleModel.class);
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
	@Override
	public void clear() {
	}
}
