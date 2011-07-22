package test.com.ett.dao;

import com.ett.dao.DaoTestCase;
import com.ett.dao.IBaseDao;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.model.SelfHardObject;

public class InitDeviceObject extends DaoTestCase {
	
	protected IBaseDao baseDao;
	
	public void etestInitDevice()
	{
		SelfDeviceObject device=new SelfDeviceObject();
		device.setIp1("192.168.1.150");
		device.setCatalog("全功能自助终端");
		device.setFzjg("粤D");
		device.setGlbm("4405");
		device.setGlbmName("汕头市龙湖区车辆管理所");
		device.setKsddCode("4405001");
		device.setKsddName("汕头大学路考场");
		device.setMachineName("Self-CGS");
		device.setPreasignAll(false);
		device.setPlaceAddress("汕头大学路考场内");
		baseDao.save(device);
		SelfHardObject hard=new SelfHardObject();
		//hard.setDeviceId(device.getId());
		hard.setBaud(9600);
		hard.setCatalog("CVR-100U");
		hard.setBrand("二代证阅读器");
		hard.setCom(1);
		hard.setStopBits(1);
		baseDao.save(hard);
		
		
		hard=new SelfHardObject();
		//hard.setDeviceId(device.getId());
		hard.setBaud(9600);
		hard.setCatalog("EPSON 532");
		hard.setBrand("热敏打印机");
		hard.setCom(1);
		hard.setStopBits(1);
		baseDao.save(hard);
		
		hard=new SelfHardObject();
		//hard.setDeviceId((long)device.getId());
		hard.setBaud(9600);
		hard.setCatalog("EPSON 110");
		hard.setBrand("针式打印机");
		hard.setCom(1);
		hard.setStopBits(1);
		baseDao.save(hard);
		
		hard=new SelfHardObject();
		//hard.setDeviceId(device.getId());
		hard.setBaud(9600);
		hard.setCatalog("FRONT Camero");
		hard.setBrand("前置摄像头");
		hard.setCom(1);
		hard.setStopBits(1);
		baseDao.save(hard);
		
		this.setComplete();
		
	}
	
	public void testABC()
	{
		
	}


}
