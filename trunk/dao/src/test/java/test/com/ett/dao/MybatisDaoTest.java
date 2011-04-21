package test.com.ett.dao;

import org.springframework.util.Assert;

import com.ett.dao.DaoTestCase;
import com.ett.model.DrvUser;
import com.ett.self.dao.IDrvQueryHelperDao;

public class MybatisDaoTest extends DaoTestCase {
	
	protected IDrvQueryHelperDao drvQueryHelperMybatisDaoImp;
	
	public void ttestMybatis()
	{
		System.out.println("注入的iDrvQueryHelperJdbcDao->"+drvQueryHelperMybatisDaoImp);
		DrvUser user=this.drvQueryHelperMybatisDaoImp.getDrvUser("350128198403194910", "4405");
		System.out.println("获取的用户对象为->"+user);
		System.out.println("获取用户的姓名为："+user.getXm());
		Assert.notNull(user);
	}
	
	public void testABC()
	{
		
	}

}
