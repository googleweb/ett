/**
 * 
 */
package com.ett.drvinterface;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;

import com.ett.common.exception.NetworkException;
import com.ett.drvinterface.entity.BaseDrvRequest;
import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.second.TmriOutAccessSoapBindingStub;

/**
 * @author austin
 *
 */
public class BaseServiceHelper implements IBaseDrvInterface {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BaseServiceHelper.class);

	/**
	 * Logger for this class
	 */

	
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public boolean isMock() {
		return isMock;
	}

	public void setMock(boolean isMock) {
		this.isMock = isMock;
	}
	private int timeout;
	protected boolean isMock=false;
	public BaseServiceHelper()
	{
		//this.isMock=new Boolean(WebPropertyConfig.getNormalValue("isMock")).booleanValue();
	}
	
	public BaseServiceHelper(boolean isMock)
	{
		this.isMock=isMock;
	}
	
	 protected String MockBegin()
	 {
		 return "<?xml version=\"1.0\" encoding=\"GBK\" ?> "
	+"<response><head><code>0</code><message>成功</message></head><body>";
	 }
	 
	 protected String MockValue(String key,String value)
	 {
		 return "<"+key+">"+value+"</"+key+">";
	 }
	 protected String MockEnd()
	 {
		 return "</body></response>";
	 }
	 
	 private TmriOutAccessSoapBindingStub stub = null;
	 
	 private void ensureStub() throws MalformedURLException, AxisFault
		{
			if(stub==null)
			{
				//String webserviceURL = url;
			    
				URL url = new URL(this.url);
				Service service = new Service();
				stub = new TmriOutAccessSoapBindingStub(url, service);
				stub.setTimeout(timeout);
			}
		}

	public BaseDrvResponse query(BaseDrvRequest request) {
		BaseDrvResponse response=new BaseDrvResponse();
		try{
		this.ensureStub();
		String xml=stub.queryObject(request.getXtlb(),request.getJkxlh(),request.getJkid(),request.toXml());
		
		response.fromXml(xml);
		
		}
		catch(Exception ex)
		{
			
			logger.info(ex.toString());
			throw new NetworkException("网络异常，无法进行业务办理！");
		}
		return response;
	}

	public BaseDrvResponse write(BaseDrvRequest request) {
		BaseDrvResponse response=new BaseDrvResponse();
		try{
		this.ensureStub();
		logger.debug("请求的service的url为:"+this.url);
		logger.debug("请求的service的timeout为:"+this.timeout);
		logger.debug("请求的service的xtlb为:"+request.getXtlb());
		logger.debug("请求的service的jkxlh为:"+request.getJkxlh());
		logger.debug("请求的service的jkid为:"+request.getJkid());
		logger.debug("请求的request对象toXml为:"+request.toXml());
		String xml=stub.writeObject(request.getXtlb(),request.getJkxlh(),request.getJkid(),request.toXml());
		
		response.fromXml(xml);
		
		}
		catch(Exception ex)
		{
			logger.info(ex.toString());
			throw new NetworkException("网络异常，无法进行业务办理！");
		}
		return response;
	}
	

}
