package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.DrvPreasignRequest;

/**
 * @author austin
 * webservices接口，供驾驶人使用 
 */
public interface IDrvInterface extends IBaseDrvInterface{
	
	public BaseDrvResponse preasign(DrvPreasignRequest request);
	
	

}
