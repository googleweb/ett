package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.DrvPreasignRequest;

/**
 * @author austin
 * 驾驶人接口帮助
 */
public class DrvServiceHelper extends BaseServiceHelper implements
		IDrvInterface {

	public BaseDrvResponse preasign(DrvPreasignRequest request) {
		return this.write(request);
	}

}
