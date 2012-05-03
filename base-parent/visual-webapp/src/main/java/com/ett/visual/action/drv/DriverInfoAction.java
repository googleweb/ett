package com.ett.visual.action.drv;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.drv.DriverInfoModel;

public class DriverInfoAction extends BaseVisualAction<DriverInfoModel> {

	@Override
	public Object createBaseCondition() {
		// TODO Auto-generated method stub
		return new DriverInfoModel().new Query();
	}

}
