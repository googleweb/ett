package com.austin.base.biz.test;

import com.austin.base.dao.IBaseDao;
import com.austin.base.test.DaoTestCase;
import com.austin.webapp.blog.model.TestUser;


public class HiberanteBaseBizTest extends DaoTestCase {
	
	protected IBaseDao baseBiz;
	public void testTestUserInsert()
	{
		TestUser user=null;
		for(int i=0;i<15;i++)
		{
			user=new TestUser();
			user.setCreator("testcase");
			user.setDeptName("部门"+String.valueOf(i));
			user.setUserName("用户"+String.valueOf(i));
			this.baseBiz.saveOrUpdate(user);
		}
		this.setComplete();
	}

}
