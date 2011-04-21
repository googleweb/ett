package com.ett.self.biz.test;

import com.ett.dao.DaoTestCase;
import com.ett.self.biz.IDeviceHelper;
import com.ett.self.model.SelfDeviceObject;

public class DeviceHelperTest extends DaoTestCase {
	
	protected IDeviceHelper iDeviceHelper;
	
	public void AtestGetDevice()
	{
		SelfDeviceObject obj=this.iDeviceHelper.getDevice("127.0.0.1");
		System.out.println("获取的设备内容为:"+obj);
	}
	
	public void testABC()
	{
		
	}

}
