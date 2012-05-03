package com.ett.visual.biz;

import java.io.File;

import com.ett.visual.model.drv.DriverInfoModel;



import com.smartken.toyz4j.biz.IDataBiz;
import com.smartken.toyz4j.model.impl.ResultModel;

public interface IDriverBiz extends IDataBiz {

	
	public ResultModel tranSaveSacnFile(byte[] rec, DriverInfoModel driver);
}
