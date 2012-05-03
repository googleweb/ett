package com.ett.visual.action.drv;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.drv.DriverFileModel;

public class DriverFileAction extends BaseVisualAction<DriverFileModel> {

	@Override
	public Object createBaseCondition() {
		// TODO Auto-generated method stub
		return new DriverFileModel().new Query();
	}

}
