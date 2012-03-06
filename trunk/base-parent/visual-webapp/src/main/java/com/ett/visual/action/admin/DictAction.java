package com.ett.visual.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.DictModel;
import com.ett.visual.model.admin.RoleModel;
import com.smartken.toyz4j.util.EasyUiUtil;
import com.smartken.toyz4j.util.ObjectUtil;

public class DictAction extends BaseVisualAction<DictModel> {
	
	




	public DictModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model= new DictModel();
		}
		return _model;
		
	}

	
	
}
