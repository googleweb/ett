package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.DrvPreasignRequest;
import com.ett.drvinterface.entity.DrvtempMidRequest;
import com.ett.drvinterface.entity.drvphotoRequest;

/**
 * @author austin
 * 驾驶人接口帮助
 */
public class DrvServiceHelper extends BaseServiceHelper implements
		IDrvInterface {

	public BaseDrvResponse preasign(DrvPreasignRequest request) {
		
		return this.write(request);
	}

	public BaseDrvResponse preinput(DrvtempMidRequest request) {
		// TODO Auto-generated method stub
		return this.write(request);
	}

	public BaseDrvResponse photopreinput(drvphotoRequest request) {
		// TODO Auto-generated method stub
		return this.write(request);
	}

}
