package com.ett.visual.biz.impl;

import java.io.File;
import java.util.Date;

import com.ett.visual.biz.BaseVisualBiz;
import com.ett.visual.biz.IDriverBiz;
import com.ett.visual.model.BaseVisualModel;
import com.ett.visual.model.driver.DriverFileModel;
import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.model.impl.BaseCurdBiz;
import com.smartken.toyz4j.model.impl.BaseModel;
import com.smartken.toyz4j.model.impl.ResultModel;

public class DriverBiz  extends BaseVisualBiz implements IDriverBiz{

	public ResultModel tranSaveSacnFile(byte[] rec, DriverInfoModel driver) {
		// TODO Auto-generated method stub
		ResultModel result=new ResultModel();
		DriverFileModel drvFile=new DriverFileModel();
		drvFile.setPk(BaseModel.generalPK());
		drvFile.setRec(rec);
		drvFile.setDriverPk(driver.getId());
		drvFile.setCreateDate(new Date());
		drvFile.setLastModifyDate(new Date());
		this.loadCrudMapper(DriverFileModel.class);
		this.addModel(drvFile);
		return null;
	}

}
