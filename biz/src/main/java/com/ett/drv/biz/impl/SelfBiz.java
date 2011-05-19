package com.ett.drv.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;



import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.mapper.self.IDeviceMapper;
import com.ett.drv.mapper.self.IDrivingLicenseMapper;
import com.ett.drv.mapper.self.IDrvFlowMapper;
import com.ett.drv.mapper.self.IFeeLogMapper;
import com.ett.drv.mapper.self.IKm1CheckRecordMapper;
import com.ett.drv.mapper.self.IKm1PreasignRecordMapper;
import com.ett.drv.mapper.self.ITerminalMapper;
import com.ett.drv.mapper.self.ITransactDriverMapper;
import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.mapper.self.ITransactVehicleMapper;
import com.ett.drv.mapper.self.IVehFlowMapper;
import com.ett.drv.mapper.self.IVehicleMapper;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.DeviceModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.FeeLogModel;
import com.ett.drv.model.self.Km1CheckRecordModel;
import com.ett.drv.model.self.Km1PreasignRecordModel;
import com.ett.drv.model.self.PersonModel;
import com.ett.drv.model.self.TerminalModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.StringUtil;

public class SelfBiz extends BaseDrvBiz implements ISelfBiz{

/**
	
	private IDeviceMapper<DeviceModel> deviceMapper;
	private ITerminalMapper<TerminalModel> terminalMapper;
	private ITransactDriverMapper<TransactDriverModel> transactDriverMapper;
	private ITransactVehicleMapper<TransactVehicleModel> transactVehicleMapper;
	private IDrivingLicenseMapper<DrivingLicenseModel> drivingLicenseMapper;
	private IVehicleMapper<VehicleModel> vehicleMapper;
	private IVehFlowMapper<VehFlowModel> vehFlowMapper;
	private IDrvFlowMapper<DrvFlowModel> drvFlowMapper;
	private ITransactResourceMapper<TransactResourceModel> transactResourceMapper;
	private IKm1CheckRecordMapper<Km1CheckRecordModel> km1CheckRecordMapper;
	private IKm1PreasignRecordMapper<Km1PreasignRecordModel> km1PreasignRecordMapper;
	private IFeeLogMapper<FeeLogModel> feeLogMapper;
	
	
	public void setDeviceMapper(IDeviceMapper<DeviceModel> deviceMapper) {
		this.deviceMapper = deviceMapper;
		this.addCrudMapper(DeviceModel.class, deviceMapper);
	}
	public void setTerminalMapper(ITerminalMapper<TerminalModel> terminalMapper) {
		this.terminalMapper = terminalMapper;
		this.addCrudMapper(TerminalModel.class, terminalMapper);
	}
	public void setTransactDriverMapper(
			ITransactDriverMapper<TransactDriverModel> transactDriverMapper) {
		this.transactDriverMapper = transactDriverMapper;
		this.addCrudMapper(TransactDriverModel.class, transactDriverMapper);
	}
	public void setTransactVehicleMapper(
			ITransactVehicleMapper<TransactVehicleModel> transactVehicleMapper) {
		this.transactVehicleMapper = transactVehicleMapper;
		this.addCrudMapper(TransactVehicleModel.class, transactVehicleMapper);
	}
	
	
	public void setDrivingLicenseMapper(
			IDrivingLicenseMapper<DrivingLicenseModel> drivingLicenseMapper) {
		this.drivingLicenseMapper = drivingLicenseMapper;
		this.addCrudMapper(DrivingLicenseModel.class, drivingLicenseMapper);
	}
	
	
	public void setVehicleMapper(IVehicleMapper<VehicleModel> vehicleMapper) {
		this.vehicleMapper = vehicleMapper;
		this.addCrudMapper(VehicleModel.class, vehicleMapper);
	}
	
	
	
	public void setVehFlowMapper(IVehFlowMapper<VehFlowModel> vehFlowMapper) {
		this.vehFlowMapper = vehFlowMapper;
		this.addCrudMapper(VehFlowModel.class, vehFlowMapper);
	}
	
	
	
	public void setDrvFlowMapper(IDrvFlowMapper<DrvFlowModel> drvFlowMapper) {
		this.drvFlowMapper = drvFlowMapper;
		this.addCrudMapper(DrvFlowModel.class, drvFlowMapper);
	}
	
	
	
	
	public void setTransactResourceMapper(
			ITransactResourceMapper<TransactResourceModel> transactResourceMapper) {
		this.transactResourceMapper = transactResourceMapper;
		this.addCrudMapper(TransactResourceModel.class, transactResourceMapper);
	}
	
	
	
	
	
	public void setKm1CheckRecordMapper(
			IKm1CheckRecordMapper<Km1CheckRecordModel> km1CheckRecordMapper) {
		this.km1CheckRecordMapper = km1CheckRecordMapper;
		this.addCrudMapper(Km1CheckRecordModel.class, km1CheckRecordMapper);
	}
	public void setKm1PreasignRecordMapper(
			IKm1PreasignRecordMapper<Km1PreasignRecordModel> km1PreasignRecordMapper) {
		this.km1PreasignRecordMapper = km1PreasignRecordMapper;
	    this.addCrudMapper(Km1PreasignRecordModel.class, km1PreasignRecordMapper);
	}
	public void setFeeLogMapper(IFeeLogMapper<FeeLogModel> feeLogMapper) {
		this.feeLogMapper = feeLogMapper;
		this.addCrudMapper(FeeLogModel.class, feeLogMapper);
	}

	**/

	public String saveTransactAndFlow(TransactVehicleModel trModel,VehFlowModel flowModel) {
		// TODO Auto-generated method stub
		String flowNo="";
		//trModel.setCreateDate(new Date());
		flowModel.setSqrq(trModel.getCreateDate());
    	Random ran=new Random();
    	int randomNo=ran.nextInt(100000);
    	String code=String.valueOf(randomNo);
    	int re=0;
    	try{
             flowNo=BaseTransactModel.generalFlowNo(TransactVehicleModel.CODE, null,code );
		     trModel.setFlowNo(flowNo);
		     re+=transactVehicleMapper.insertOne(trModel);
		     //flowModel.setLsh(flowNo);
		     //re+=vehFlowMapper.insertOne(flowModel);
	    }catch(Exception ex){ex.printStackTrace();}
	    return flowNo;
	}
	
	public String saveTransactAndFlow(TransactDriverModel trModel,
			DrvFlowModel flowModel) {
		// TODO Auto-generated method stub
		String flowNo="";
		//trModel.setCreateDate(new Date());
    	Random ran=new Random();
    	int randomNo=ran.nextInt(100000);
    	String code=String.valueOf(randomNo);
    	int re=0;
    	try{
		   flowNo=BaseTransactModel.generalFlowNo(TransactDriverModel.CODE, null, code);
		   trModel.setFlowNo(flowNo);
		   re+=transactDriverMapper.insertOne((TransactDriverModel)trModel);
		   //flowModel.setLsh(flowNo);
		   //re+=drvFlowMapper.insertOne(flowModel);
	    }catch(Exception ex){ex.printStackTrace();}
	    return flowNo;
	}

	public int doSynFeelog(Date createDate) {
		// TODO Auto-generated method stub
		FeeLogModel query=new FeeLogModel();
        if(createDate==null) return 0;
        int synCount=0;
		query.setCreatetime(createDate);
		try {
			ArrayList<FeeLogModel> listPreasignRecord=this.feeLogMapper.select(query);
			for (FeeLogModel feeLogModel : listPreasignRecord) {
				feeLogModel.setSyn(1);
				synCount+= this.feeLogMapper.updateOne(feeLogModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return synCount;
		}
		return synCount;
	}
	
	
 	
}
