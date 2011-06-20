package com.ett.drv.web.action.admin;

import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class DepartmentAction extends BaseDrvAction implements ModelDriven<DepartmentModel>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DepartmentModel  departmentModel;
	public void  setDepartmentModel(DepartmentModel departmentModel){
		this.departmentModel=departmentModel;
	}
	public DepartmentModel getDepartmentModel(){
		return this.departmentModel;
	}
	public DepartmentModel getModel() {
		if(isGet()){
			int id=ObjectUtil.formatInt(this.getParameter("id"));
			if(id==0)
			{
				departmentModel=new DepartmentModel();
			}else{
				this.adminBiz.loadCrudMapper(DepartmentModel.class);
				departmentModel=(DepartmentModel) this.adminBiz.getModelEqPk(id);
			}
		}
		return departmentModel;
	}
	@SuppressWarnings("unchecked")
	public void datagrid_department(){
		this.adminBiz.loadCrudMapper(DepartmentModel.class);
		List<IFormatterModel> list=this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writeHTML(jsonDG.toString());
		
	}
	public String to_modifyDepartment(){	
		return "jsp";
	}
	public String to_deleteDepartment(){
		return "jsp";
	}
	public  void  do_deleteDepartment(){
		int re=0;
		String ids=this.getParameter("ids");
		if(ids!=""){
			List<String> list=StringUtil.splitToList(ids, ",");
			re=this.adminBiz.removeModelInPk(list).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			resultModel.setMsg("成功删除{0}个部门",re);
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有部门被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   
	}
	public void  do_modifDepartment(){
		int re=0;
		ResultModel resultModel=new ResultModel();
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(DepartmentModel.class);
		    resultModel=this.adminBiz.modifyOrAddModel(departmentModel);
		}
		//ResultModel resultModel=new ResultModel();
		/*if(re>0){
			resultModel.setTitle("操作成功");
			resultModel.setMsg("成功保存{0}个部门",re);
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有被保存");
		}*/
		this.writePlainText(resultModel.toJson().toString());   
	}
	public void clear(){}
}
