package com.ett.visual.action.driver;

import java.io.File;
import java.io.IOException;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import com.smartken.toyz4j.util.FileUtil;

public class DriverInfoAction extends BaseVisualAction<DriverInfoModel> {

	
	
	public DriverInfoModel getModel() {
		// TODO Auto-generated method stub
		if(_model==null){
			_model=new DriverInfoModel();
		}
		return _model;
	}


}
