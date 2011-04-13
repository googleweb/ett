package com.ett.self;

public interface ISelfBiz {
	
	/**
	 * @return 获取操作自助终端的用户信息
	 */
	public SelfDeviceUser getUser(String idcard);
	
	public void getUserExamCard(SelfDeviceUser user);
	
	public void getUserVehile(SelfDeviceUser user);

}
