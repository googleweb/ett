/**
 * 
 */
package com.ett.drvinterface.first;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.client.Service;
import org.codehaus.plexus.util.xml.XmlUtil;

import com.ett.drvinterface.BaseServiceHelper;

/**
 * @author austin
 * 老接口的服务对象
 */
public class DrvServiceHelper extends BaseServiceHelper {
	
	
	public String getPersonPhoto(String sfzmmc,String sfzmhm,String sn) throws MalformedURLException, RemoteException
	{
		String result="";

		
		 
		    DrvSoapBindingStub stup = null;
			URL url = new URL(this.getUrl());
			Service service = new Service();
			//service.setTimeout(this.getTimeout());
			stup = new DrvSoapBindingStub(url, service);
			  //用户IP地址，系统名称
			result = stup.getDrvImage(sfzmmc, sfzmhm,sn);
//XmlUtil.isXml(arg0)
		return result;
	}

}
