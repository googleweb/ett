package com.ett.visual.action.admin;

import java.util.List;

import org.json.JSONObject;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.RoleModel;
import com.smartken.toyz4j.util.EasyUiUtil;

public class RoleAction extends BaseVisualAction<RoleModel> {

	public RoleModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model= new RoleModel();
		}
		return _model;
		
	}

	
}
