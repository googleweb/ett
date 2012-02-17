package com.ett.visual.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.RoleModel;
import com.smartken.toyz4j.util.EasyUiUtil;
import com.smartken.toyz4j.util.ObjectUtil;

public class RoleAction extends BaseVisualAction<RoleModel> {
	
	




	public RoleModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model= new RoleModel();
		}
		return _model;
		
	}

	
	public void combobox_list(){
		this.adminBiz.loadCrudMapper(RoleModel.class);
		List list=this.adminBiz.getModel();
		List<String> fields=new ArrayList<String>();
		fields.add(RoleModel.F.Id.name());
		fields.add(RoleModel.F.Name.name());
		JSONArray jarr= ObjectUtil.toJsonArrayInclude(list,fields);
		this.writePlainText(jarr.toString());
	}
	
}
