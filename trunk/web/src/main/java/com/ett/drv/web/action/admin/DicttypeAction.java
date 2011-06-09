package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.admin.DictTypeModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class DicttypeAction extends BaseAction implements ModelDriven<DictTypeModel>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DictTypeModel dictTypeModel;


	public DictTypeModel getDictTypeModel() {
		return dictTypeModel;
	}

	public void setDictTypeModel(DictTypeModel dictTypeModel) {
		this.dictTypeModel = dictTypeModel;
	}

	public String to_index() {
		return "jsp";
	}

	public DictTypeModel getModel() {
		if (isGet()) {
			int id = ObjectUtil.formatInt(this.getParameter("id"));
			if (id == 0) {
				dictTypeModel = new DictTypeModel();
			} else {
				this.adminBiz.loadCrudMapper(DictTypeModel.class);
				dictTypeModel = (DictTypeModel) this.adminBiz.getModelEqPk(id);
			}
		}
		return dictTypeModel;
	}
	@SuppressWarnings("unchecked")
	public void datagrid_dict(){
		
		this.adminBiz.loadCrudMapper(DictTypeModel.class);
		List list=(List) this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());
	}
	public String to_addDict(){
		return "jsp";
	}
	public String to_modifyDict(){
		return "jsp";
	}
	public void  do_addDict(){
		int re=0;
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(DictTypeModel.class);
			re+=this.adminBiz.modifyOrAddModel(dictTypeModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			pattern="字典类型管理:保存成功";
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg(pattern,re);;
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void  do_modifyDict(){
		int re=0;
		if(this.isPost()){
			this.adminBiz.loadCrudMapper(DictTypeModel.class);
			re+=this.adminBiz.modifyOrAddModel(dictTypeModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";			
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			pattern="字典类型管理:保存成功";	
			resultModel.setMsg(pattern,re);;			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
		
	}
	public void  do_deleteDict(){
		List lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.adminBiz.loadCrudMapper(DictTypeModel.class);
             re+=this.adminBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个字典类型",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有字典类型被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
