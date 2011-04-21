/**
 * 
 */
package com.ett.self.dao;

import com.ett.self.model.SelfDeviceSnObject;

/**
 * @author austin
 *
 */
public interface ISelfDeviceSnDao {
	
	/**
	 * @param ip 根据IP获取自助终端的相应接口的SN配置
	 * @param jkname 接口名称
	 * @return SN配置对象
	 */
	public SelfDeviceSnObject getSelfDeviceSn(String ip,String jkname);

}
