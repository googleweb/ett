package com.ett.drv.biz;

import com.ett.dao.DaoTestCase;
import com.ett.model.DrvUser;

public class DrvQueryHelperImpTest extends DaoTestCase {
	
	protected IDrvQueryHelper iDrvQueryHelper;
	
	public void AtestGetDevice()
	{
		System.out.println("注入的iDrvQueryHelper-》"+iDrvQueryHelper);
		DrvUser obj=this.iDrvQueryHelper.getDrvUser("350128198403194910", "4405");
		System.out.println("获取的驾驶人内容为:"+obj);
	}
	public void testABC()
	{
		
	}

}
