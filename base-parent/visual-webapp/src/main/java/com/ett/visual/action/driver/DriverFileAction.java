package com.ett.visual.action.driver;

import java.io.File;
import java.io.IOException;

import com.ett.visual.action.BaseVisualAction;
import com.ett.visual.model.admin.MenuModel.SimpleQueryModel;
import com.ett.visual.model.driver.DriverFileModel;
import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.enums.EResult;
import com.smartken.toyz4j.model.impl.BaseAction;
import com.smartken.toyz4j.model.impl.BaseModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import com.smartken.toyz4j.util.FileUtil;

public class DriverFileAction extends BaseVisualAction<DriverFileModel> {

	private File tempFile;
	
	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}

	public DriverFileModel getModel() {
		// TODO Auto-generated method stub
		return new DriverFileModel();
	}

	public String to_scan(){
		return EResult.jsp.name();
	}
	
	
	public void do_saveScanFile(){
		ResultModel re=new ResultModel();
		if(tempFile==null)return; 
		byte[] rec=null;
		try {
			rec = FileUtil.toBytes(tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driverId=GetParameter("DriverPk");
		//this.driverBiz.loadCrudMapper(DriverInfoModel.class);
		//DriverInfoModel drvInfo=(DriverInfoModel) this.driverBiz.getModelEqPk(driverId);
		//re=this.driverBiz.tranSaveSacnFile(rec, drvInfo);
		WritePlainText(re.toJson().toString());
	}

	@Override
	public Object newQueryModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
