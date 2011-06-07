package com.ett.drv.biz;

import java.util.Date;

import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.PersonModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IMapper;

public interface ISelfBiz extends IBaseCrudBiz{

	public String saveTransactAndFlow(TransactVehicleModel trModel,VehFlowModel flowModel);
	public String saveTransactAndFlow(TransactDriverModel trModel,DrvFlowModel flowModel);
	
	
	public int doSynFeelog(Date createDate);
	
	
	public byte[] getSelfResource(String flowNo,String resName);
}
