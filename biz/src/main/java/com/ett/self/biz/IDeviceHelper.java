package com.ett.self.biz;

import com.ett.self.model.SelfDeviceObject;
import com.ett.self.model.SelfHardObject;

/**
 * @author austin
 * 获取设备信息的接口
 */
public interface IDeviceHelper {
	
	public SelfDeviceObject getDevice(String ip);
	
	public SelfHardObject getIdCardReader(long parentId);
	
	public SelfHardObject getHotPrinter(long parentId);
	
	public SelfHardObject getNeedlePrinter(long parentId);
	
	
	public SelfHardObject getCashCode(long parentId);
	
	
	public SelfHardObject getFrontCapture(long parentId);
	
	public SelfHardObject getEndCapture(long parentId);
	
	public SelfHardObject getKeyboard(long parentId);
	
	public SelfHardObject getVisaCardReader(long parentId);

}
