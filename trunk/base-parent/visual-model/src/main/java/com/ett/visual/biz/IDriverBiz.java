package com.ett.visual.biz;

import java.io.File;

import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.model.IBaseCrudBiz;
import com.smartken.toyz4j.model.impl.ResultModel;

public interface IDriverBiz extends IBaseCrudBiz {

	
	public ResultModel tranSaveSacnFile(byte[] rec, DriverInfoModel driver);
}
