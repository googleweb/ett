/**
 * 
 */
package com.ett.self.dao;

import java.util.List;

import com.ett.model.ComboxObject;
import com.ett.model.DrvUser;

/**
 * @author austin
 * 查询dao的接口
 */
public interface IDrvQueryHelperDao {
	
	public List<ComboxObject>  getDict(String xtlb,String type);
	
	public List<ComboxObject>  getDict(String xtlb,String type,String glbm);
	
	/**
	 * @return 获取的用户信息 没有取到用户信息说明用户还没有报考
	 */
	public DrvUser getDrvUser(String idcard,String glbm);
	
	public DrvUser getUserWithExamCard(String idcard,String glbm);
	
	public DrvUser getUserWithVehile(String idcard,String glbm);
	
	public DrvUser getUserWithLicense(String idcard,String glbm);

}
