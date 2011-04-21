package com.ett.drvinterface;

import com.ett.drvinterface.entity.BaseDrvRequest;
import com.ett.drvinterface.entity.BaseDrvResponse;

/**
 * @author austin
 * 新接口的基本写入读取接口
 */
public interface IBaseDrvInterface {
	
	public String getUrl();

	public void setUrl(String url);

	public int getTimeout();

	public void setTimeout(int timeout);

	public boolean isMock();

	public void setMock(boolean isMock);
	public BaseDrvResponse query(BaseDrvRequest request);
	
	public BaseDrvResponse write(BaseDrvRequest request);
	

}
