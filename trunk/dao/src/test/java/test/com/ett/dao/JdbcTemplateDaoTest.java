/**
 * 
 */
package test.com.ett.dao;

import org.springframework.util.Assert;

import com.ett.dao.DaoTestCase;
import com.ett.model.DrvUser;
import com.ett.self.dao.IDrvQueryHelperDao;

/**
 * @author austin
 *
 */
public class JdbcTemplateDaoTest extends DaoTestCase {
	
	protected IDrvQueryHelperDao iDrvQueryHelperJdbcDao;
	
	public void etestQueryUser()
	{
		System.out.println("注入的iDrvQueryHelperJdbcDao->"+iDrvQueryHelperJdbcDao);
		DrvUser user=this.iDrvQueryHelperJdbcDao.getDrvUser("350128198403194910", "4405");
		System.out.println("获取的用户对象为->"+user);
		System.out.println("获取用户的姓名为："+user.getXm());
		Assert.notNull(user);
	}
	
	public void testABC()
	{
		
	}


}
