package com.ett.visual.biz;

import java.io.File;

import com.ett.visual.model.driver.DriverInfoModel;


import com.smartken.toyz4j.biz.IToyzBiz;
import com.smartken.toyz4j.model.impl.ResultModel;

public interface IDriverBiz extends IToyzBiz {

	
	public ResultModel tranSaveSacnFile(byte[] rec, DriverInfoModel driver);
}
