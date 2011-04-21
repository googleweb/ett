package com.ett.drv.biz;

import java.util.List;

import com.ett.model.ComboxObject;
import com.ett.model.DrvUser;

public interface IDrvQueryHelper {
	
	public List<ComboxObject>  getDict(String xtlb,String type);
	
	public List<ComboxObject>  getDict(String xtlb,String type,String glbm);
	
	/**
	 * @return 获取的用户信息 没有取到用户信息说明用户还没有报考
	 */
	public DrvUser getDrvUser(String idcard,String glbm);
	
	public DrvUser getUserWithExamCard(DrvUser user);
	
	public DrvUser getUserWithVehile(DrvUser user);
	
	public DrvUser getUserWithLicense(DrvUser user);

}
