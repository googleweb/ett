/**
 * 
 */
package com.ett.drv.biz;

import org.apache.log4j.Logger;

import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;
import com.ett.self.dao.IDrvFeeCheckDao;

/**
 * @author austin
 *
 */
public class FeeCheckHelperDaoImpl implements IFeeCheckHelper {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(FeeCheckHelperDaoImpl.class);
	
	private IDrvFeeCheckDao iDrvFeeCheckDao;

	public IDrvFeeCheckDao getiDrvFeeCheckDao() {
		return iDrvFeeCheckDao;
	}

	public void setiDrvFeeCheckDao(IDrvFeeCheckDao iDrvFeeCheckDao) {
		this.iDrvFeeCheckDao = iDrvFeeCheckDao;
	}

	/* (non-Javadoc)
	 * @see com.ett.drv.biz.IFeeCheckHelper#deleteVehCheck(com.ett.drvinterface.entity.VehCheckRequest)
	 */
	public void deleteVehCheck(VehCheckRequest request) {
		logger.debug("注入的缴费biz类的dao为 "+this.iDrvFeeCheckDao);
		this.iDrvFeeCheckDao.deleteVehCheck(request);
		
	}

	/* (non-Javadoc)
	 * @see com.ett.drv.biz.IFeeCheckHelper#deleteDrvCheck(com.ett.drvinterface.entity.DrvCheckRequest)
	 */
	public void deleteDrvCheck(DrvCheckRequest request) {
		this.iDrvFeeCheckDao.deleteDrvCheck(request);

	}

}
