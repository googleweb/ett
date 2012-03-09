package com.ett.visual.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.DictModel;
import com.ett.visual.model.admin.DictTypeModel;
import com.ett.visual.model.admin.RoleModel;
import com.ett.visual.model.admin.MenuModel.SimpleQueryModel;
import com.smartken.toyz4j.model.impl.BaseModel;
import com.smartken.toyz4j.util.EasyUiUtil;
import com.smartken.toyz4j.util.ObjectUtil;

public class DictTypeAction extends BaseVisualAction<DictTypeModel> {
	
	




	public DictTypeModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model= new DictTypeModel();
		}
		return _model;
		
	}

	@Override
	protected BaseModel newSimpleQueryModel() {
		// TODO Auto-generated method stub
		return getModel().new SimpleQueryModel();
	}

	

	

	
	
}
