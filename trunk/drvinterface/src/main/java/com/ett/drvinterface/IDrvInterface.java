package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.DrvPreasignRequest;
import com.ett.drvinterface.entity.DrvtempMidRequest;

/**
 * @author austin
 * webservices接口，供驾驶人使用 
 */
public interface IDrvInterface extends IBaseDrvInterface{
	
	public BaseDrvResponse preasign(DrvPreasignRequest request);
	
	public BaseDrvResponse preinput(DrvtempMidRequest request );

}
