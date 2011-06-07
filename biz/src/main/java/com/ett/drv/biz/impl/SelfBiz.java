package com.ett.drv.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		query.setTCreatetime(createDate);
		try {
			List<FeeLogModel> listPreasignRecord=this.feeLogMapper.select(query);
			for (FeeLogModel feeLogModel : listPreasignRecord) {
				feeLogModel.setISyn(1);
				synCount+= this.feeLogMapper.updateOne(feeLogModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return synCount;
		}
		return synCount;
	}

	public byte[] getSelfResource(String flowNo, String resName) {
		// TODO Auto-generated method stub
		byte[] bs=null;
		if(StringUtil.isBlank(flowNo)||StringUtil.isBlank(resName))return bs;
		try {
			TransactResourceModel trModel=this.transactResourceMapper.selectEqPk(flowNo);
			bs=(byte[]) trModel.eval(resName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bs;
	}
	
	
 	
}
