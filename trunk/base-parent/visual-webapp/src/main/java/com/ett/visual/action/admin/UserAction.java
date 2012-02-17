package com.ett.visual.action.admin;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.UserModel;


public class UserAction extends BaseVisualAction<UserModel>{

	public UserModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model=new UserModel();
		}
		return _model;
	
	}

}
