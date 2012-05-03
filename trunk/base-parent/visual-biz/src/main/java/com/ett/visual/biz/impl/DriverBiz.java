package com.ett.visual.biz.impl;

import java.io.File;
import java.util.Date;

import com.ett.visual.biz.BaseVisualBiz;
import com.ett.visual.biz.IDriverBiz;
import com.ett.visual.model.BaseVisualModel;
import com.ett.visual.model.drv.DriverFileModel;
import com.ett.visual.model.drv.DriverInfoModel;

import com.smartken.toyz4j.model.impl.BaseModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import com.smartken.toyz4j.util.ObjectUtil;

public class DriverBiz  extends BaseVisualBiz implements IDriverBiz{

	public ResultModel tranSaveSacnFile(byte[] rec, DriverInfoModel driver) {
		// TODO Auto-generated method stub
		ResultModel result=new ResultModel();
		DriverFileModel drvFile=new DriverFileModel();
		try {
			drvFile.genPk();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//drvFile.setRec(rec);
		//drvFile.setDriverPk(driver.getId());
		//drvFile.setCreateDate(new Date());
		//drvFile.setLastModifyDate(new Date());
		//this.loadCrudMapper(DriverFileModel.class);
	   // result= this.addModel(drvFile);
		return result;
	}

}
