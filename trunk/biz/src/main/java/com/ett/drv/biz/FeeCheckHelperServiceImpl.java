/**
 * 
 */
package com.ett.drv.biz;

import com.ett.drvinterface.IDrvFeeCheckInterface;
import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;

/**
 * @author austin
 *
 */
public class FeeCheckHelperServiceImpl implements IFeeCheckHelper {

	private IDrvFeeCheckInterface iDrvFeeCheckInterface;
	public IDrvFeeCheckInterface getiDrvFeeCheckInterface() {
		return iDrvFeeCheckInterface;
	}

	public void setiDrvFeeCheckInterface(IDrvFeeCheckInterface iDrvFeeCheckInterface) {
		this.iDrvFeeCheckInterface = iDrvFeeCheckInterface;
	}

	/* (non-Javadoc)
	 * @see com.ett.drv.biz.IFeeCheckHelper#deleteVehCheck(com.ett.drvinterface.entity.VehCheckRequest)
	 */
	public void deleteVehCheck(VehCheckRequest request) {
		this.iDrvFeeCheckInterface.deleteVehCheck(request);

	}

	/* (non-Javadoc)
	 * @see com.ett.drv.biz.IFeeCheckHelper#deleteDrvCheck(com.ett.drvinterface.entity.DrvCheckRequest)
	 */
	public void deleteDrvCheck(DrvCheckRequest request) {
		this.iDrvFeeCheckInterface.deleteDrvCheck(request);

	}

}
