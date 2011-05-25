package com.ett.drv.model.self;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.smartken.kia.core.model.impl.BaseModel;

public class FeeReconModel extends BaseModel {

	
	private Date createDate;
	private int tranCount=0;
    private int posTotal=0;
    private int cashTotal=0;
    private int syn=1;
	
	
	public FeeReconModel(Date createDate, List<FeeLogModel> listFeeLog){
		this.createDate=createDate;
		this.tranCount=listFeeLog.size();
		for (FeeLogModel feeLogModel : listFeeLog) {
			//String busType=feeLogModel.getBustype();
//			if(feeLogModel.getSyn()==0){
//				syn=0;
//			}
			if(feeLogModel.getMoney()==null){
				continue;
			}
			String feewayType=feeLogModel.getBustype();
			if("现金缴费".equalsIgnoreCase(feewayType)){
				cashTotal+=feeLogModel.getMoney();
			}else if("银联pos缴费".equalsIgnoreCase(feewayType)){
				posTotal+=feeLogModel.getMoney();
			}else{
				cashTotal+=feeLogModel.getMoney();
			}
		}
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}



	public int getTranCount() {
		return tranCount;
	}




	public int getPosTotal() {
		return posTotal;
	}


	public int getCashTotal() {
		return cashTotal;
	}


	public String getSyn() {
		if(this.syn==0){
			return "未对账";
		}else {
			return "已对账";
		}
	}



	
	
	
}
