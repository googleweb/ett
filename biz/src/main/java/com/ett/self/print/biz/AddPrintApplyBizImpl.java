package com.ett.self.print.biz;

import com.ett.dao.IDao;
import com.ett.model.DrvUser;
import com.ett.self.model.PrintObject;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.print.model.AddPrintApplyObject;
import com.ett.self.print.model.PrintBusType;

public class AddPrintApplyBizImpl  extends PrintBizImpl implements IAddPrintApplyBiz{
	
	private IDao addPrintApplyDao;
	

	public IDao getAddPrintApplyDao() {
		return addPrintApplyDao;
	}

	public void setAddPrintApplyDao(IDao addPrintApplyDao) {
		this.addPrintApplyDao = addPrintApplyDao;
	}

	public AddPrintApplyObject addHospitalPrint(DrvUser user, SelfDeviceObject device,
			String lsh,int lineupid) {
		 AddPrintApplyObject print=new AddPrintApplyObject();
		 PrintObject obj=this.getHospitalPrintObject(lsh);
		 print.setAddress(device.getPlaceAddress());
		 print.setCreateIp(device.getIp1());
		 print.setCreator(user.getXm());
		 print.setSfzmhm(user.getSfzmhm());
		 print.setDevice(device.getMachineName());
		 print.setPrinted(false);
		 print.setLsh(lsh);
		 //print.setLineUpid(print.)
		 print.setLineUpid(lineupid);
		 print.setBusType(PrintBusType.Hospital_Print);
		 this.addPrintApplyDao.save(print);
		 return print;
		 
	}

	public AddPrintApplyObject addVioPrint(DrvUser user, SelfDeviceObject device, String jdsbh,int lineupid) {
		AddPrintApplyObject print=new AddPrintApplyObject();
		PrintObject obj=this.getVioPrintObject(jdsbh);
		print.setAddress(device.getPlaceAddress());
		print.setCreateIp(device.getIp1());
		print.setCreator(user.getXm());
		print.setSfzmhm(user.getSfzmhm());
		print.setDevice(device.getMachineName());
		print.setPrinted(false);
		print.setLsh(jdsbh);
		 //print.setLsh(lsh);
		print.setLineUpid(lineupid);
		print.setBusType(PrintBusType.Vio_Add_Print);
		this.addPrintApplyDao.save(print);
		return print;
		
		
	}

}
