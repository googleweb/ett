package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.DrvPreasignRequest;
import com.ett.drvinterface.entity.DrvtempMidRequest;
import com.ett.drvinterface.entity.HealthBeanRequest;
import com.ett.drvinterface.entity.DrvphotoRequest;

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

	public BaseDrvResponse photopreinput(DrvphotoRequest request) {
		// TODO Auto-generated method stub
		return this.write(request);
	}

	public BaseDrvResponse drvphoto(DrvphotoRequest request) {
		// TODO Auto-generated method stub
		return this.write(request);
	}

	public BaseDrvResponse healthBean(HealthBeanRequest request) {
		// TODO Auto-generated method stub
		return this.write(request);
	}

}
