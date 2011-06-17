package com.ett.drv.web.action.preinput;

import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.admin.DictModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.util.EasyUiUtil;

public class ListAction<StudentApplyInfoModel> extends BaseAction implements ModelDriven<StudentApplyInfoModel>{

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String to_detail(){
	    return "jsp";
	}

	public StudentApplyInfoModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void datagrid_list(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		this.adminBiz.loadCrudMapper(DictModel.class);
		List list=this.adminBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(jsonDG.toString());		
	}

}
