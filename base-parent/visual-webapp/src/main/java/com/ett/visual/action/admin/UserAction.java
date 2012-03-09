package com.ett.visual.action.admin;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.UserModel;
import com.ett.visual.model.admin.MenuModel.SimpleQueryModel;
import com.smartken.toyz4j.model.impl.BaseModel;


public class UserAction extends BaseVisualAction<UserModel>{

	public UserModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model=new UserModel();
		}
		return _model;
	
	}

	@Override
	protected BaseModel newSimpleQueryModel() {
		// TODO Auto-generated method stub
		return getModel();
	}

}
