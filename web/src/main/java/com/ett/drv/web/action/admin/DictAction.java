package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.DictTypeModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class DictAction extends BaseAction implements ModelDriven<DictModel>{
	private DictModel _dictModel;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	

	public DictModel get_dictModel() {
		return _dictModel;
	}


	public void set_dictModel(DictModel dictModel) {
		_dictModel = dictModel;
	}


	public DictModel getModel() {
		// TODO Auto-generated method stub
		if(isGet()){
			int id=ObjectUtil.formatInt(this.getParameter("id"));
			if(id==0)
			{
				_dictModel=new DictModel();
			}else{
				this.adminBiz.loadCrudMapper(DictModel.class);
				_dictModel=(DictModel) this.adminBiz.getModelEqPk(id);
			}
		}
		return _dictModel;
	}
	public void datagrid_dicts(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		this.adminBiz.loadCrudMapper(DictModel.class);
		List list=this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());		
	}
	public String to_editDict(){
	    return "jsp";
	}
	public void  do_editDict(){
		int re=0;
		
		if(this.isPost()){
			
			this.adminBiz.loadCrudMapper(DictModel.class);
			re+=this.adminBiz.modifyOrAddModel(_dictModel).getRe();
			
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(_dictModel.getId()==null){
				pattern="字典管理:{0}保存成功,再添加一个用户？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="字典管理:{0}保存成功";
			}
			resultModel.setMsg(pattern,re);;
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void do_deleteDict(){
    	//根据id删除User，，并输出json格式的保存结果
    	ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.adminBiz.loadCrudMapper(DictModel.class);
             re+=this.adminBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个字典",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有字典被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   	
    }
	public void combobox_DictType(){
		List listDictType=new ArrayList<DictTypeModel>();
		JSONArray jarr=new JSONArray();
		try {
			listDictType=this.adminBiz.listDictType();
			jarr=ObjectUtil.toJsonArray(listDictType);
		} catch (Exception e) {e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
}
