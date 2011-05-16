package com.ett.self.biz;

import java.util.List;

import com.ett.AbstractBaseBiz;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.model.SelfHardObject;

/**
 * @author austin
 * 获取设备信息的接口实现类
 */
public class DeviceHelper extends AbstractBaseBiz implements IDeviceHelper {

	public SelfDeviceObject getDevice(String ip) {
		
		String hql=" from SelfDeviceObject where ip1='"+ip+"'";
		List lists=this.getBaseDao().getAll(hql);

		return (SelfDeviceObject)lists.get(0);
		
		
	}

	public SelfHardObject getIdCardReader(long parentId) {
		String hql=" from SelfHardObject where brand='二代证阅读器' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getHotPrinter(long parentId) {
		String hql=" from SelfHardObject where brand='热敏打印机' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getNeedlePrinter(long parentId) {
		String hql=" from SelfHardObject where brand='针式打印机' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getCashCode(long parentId) {
		String hql=" from SelfHardObject where brand='现金阅读器' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getFrontCapture(long parentId) {
		String hql=" from SelfHardObject where brand='前置摄像头' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getEndCapture(long parentId) {
		String hql=" from SelfHardObject where brand='后置摄像头' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getKeyboard(long parentId) {
		String hql=" from SelfHardObject where brand='金属密码键盘' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	public SelfHardObject getVisaCardReader(long parentId) {
		String hql=" from SelfHardObject where brand='银联读卡器' and deviceId="+parentId+"";
		return (SelfHardObject)this.getBaseDao().getAll(hql).get(0);
	}

	

}
