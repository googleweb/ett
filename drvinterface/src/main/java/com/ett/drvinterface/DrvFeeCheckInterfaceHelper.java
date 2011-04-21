/**
 * 
 */
package com.ett.drvinterface;

import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;

/**
 * @author austin
 *
 */
public class DrvFeeCheckInterfaceHelper extends BaseServiceHelper implements
		IDrvFeeCheckInterface {
	
	

	/* (non-Javadoc)
	 * @see com.ett.drvinterface.IDrvFeeCheckInterface#deleteVehCheck(com.ett.drvinterface.entity.VehCheckRequest)
	 */
	public void deleteVehCheck(VehCheckRequest request)  {
		//JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		//Client client =  dcf.createClient(this.getUrl());
		//Object[] result = client.invoke("invoke",request.toDeleteXml());
		//System.out.println(result[0]);

		
		//throw new Exception("未实现具体的接口方法");

	}

	/* (non-Javadoc)
	 * @see com.ett.drvinterface.IDrvFeeCheckInterface#deleteDrvCheck(com.ett.drvinterface.entity.DrvCheckRequest)
	 */
	public void deleteDrvCheck(DrvCheckRequest request) {
		// TODO Auto-generated method stub
		//throw new Exception("未实现具体的接口方法");

	}

}
