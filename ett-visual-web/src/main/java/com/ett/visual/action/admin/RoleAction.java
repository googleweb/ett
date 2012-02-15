package com.ett.visual.action.admin;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.RoleModel;

public class RoleAction extends BaseVisualAction<RoleModel> {

	public RoleModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			return new RoleModel();
		}
		return _model;
	}

}
