package com.ett.drv.model.self;

import java.util.Date;

import com.ett.drv.model.self.TransactVehicleModel.ETransact;
import com.smartken.kia.core.model.impl.BaseModel;

public class TransactDriverModel extends BaseTransactModel {

	public static int CODE=1;
	
	
	public static enum ETransact {
		exchange_driver_license,lost_driver_license,destroy_driver_license
	}
	
	  public static class Transacts{
		  public static String EXCHANGE_DRIVER_LICENSE="期满";
		  public static String LOST_DRIVER_LICENSE="遗失";
		  public static String DESTROY_DRIVER_LICENSE="损坏";
	  }
	  
	
	
	public static enum F{
		LicenseNo
	}


	private String LicenseNo;         //LICENSE_NO  VARCHAR2 100


	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.LicenseNo = licenseNo;
	}
	
	@Override
	public void setTransact(String transact) {
		// TODO Auto-generated method stub
		if(ETransact.exchange_driver_license.name().equalsIgnoreCase(transact)){
			this.Transact=TransactDriverModel.Transacts.EXCHANGE_DRIVER_LICENSE;
		}else if(ETransact.destroy_driver_license.name().equalsIgnoreCase(transact)){
			this.Transact=TransactDriverModel.Transacts.DESTROY_DRIVER_LICENSE;
		}else if(ETransact.lost_driver_license.name().equalsIgnoreCase(transact)){
			this.Transact=TransactDriverModel.Transacts.LOST_DRIVER_LICENSE;
		}else {
			this.Transact=transact;
		}
	}
}
