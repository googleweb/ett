/**
 * 
 */
package com.ett.self.dao.impl;

import java.util.List;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.dao.BaseDaoHibernateImpl;
import com.ett.self.dao.ISelfDeviceSnDao;
import com.ett.self.model.SelfDeviceSnObject;

/**
 * @author austin
 *
 */
public class SelfDeviceSnDaoImpl extends BaseDaoHibernateImpl implements
		ISelfDeviceSnDao {

	/* (non-Javadoc)
	 * @see com.ett.self.dao.ISelfDeviceSnDao#getSelfDeviceSn(java.lang.String, java.lang.String)
	 */
	public SelfDeviceSnObject getSelfDeviceSn(String ip, String jkname) {
		String sql=" from SelfDeviceSnObject where jkName='"+jkname+"' and deviceIp='"+ip+"'";
		List list= this.getAll(sql);
		if(list==null||list.size()==0)
		{
			throw new ObjectDontExistException("对不起，没找到相应的设备的接口配置");
		}
		return (SelfDeviceSnObject)list.get(0);
	}

}
