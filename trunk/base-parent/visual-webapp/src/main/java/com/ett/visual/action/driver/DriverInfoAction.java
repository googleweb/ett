package com.ett.visual.action.driver;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.driver.DriverInfoModel;

public class DriverInfoAction extends BaseVisualAction<DriverInfoModel> {

	public DriverInfoModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model=new DriverInfoModel();
		}
		return _model;
	}

}
