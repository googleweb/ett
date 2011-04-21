/**
 * 
 */
package com.ett.drv.biz;

import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;

/**
 * @author austin
 *
 */
public interface IFeeCheckHelper {
	
	public void deleteVehCheck(VehCheckRequest request);
	
	public void deleteDrvCheck(DrvCheckRequest request);

}
