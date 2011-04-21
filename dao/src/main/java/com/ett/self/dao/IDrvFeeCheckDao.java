/**
 * 
 */
package com.ett.self.dao;

import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;

/**
 * @author austin
 * 业务缴费删除表记录
 */
public interface IDrvFeeCheckDao {
	
	public void deleteVehCheck(VehCheckRequest request);
	
	public void deleteDrvCheck(DrvCheckRequest request);

}
