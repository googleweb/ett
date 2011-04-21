package com.ett.drvinterface;

import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;

public interface IDrvFeeCheckInterface {
	
	public void deleteVehCheck(VehCheckRequest request);
	
	public void deleteDrvCheck(DrvCheckRequest request);

}
