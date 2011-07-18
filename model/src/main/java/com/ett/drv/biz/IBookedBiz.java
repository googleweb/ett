package com.ett.drv.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.impl.ResultModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;

public interface IBookedBiz extends IBaseCrudBiz{

	//public BookedWeekRecordModel getWeekRecord(Date pDate);
	public BookedWeekRecordModel getWeekRecord(int year,int weekNum);
	
	public Map<String,BookedLimitModel> getLimits(int year,int weekNum) throws Exception;
	
	
	public ResultModel tranExamPreasgin(BookedOrderInfoModel orderInfoModel,BookedLimitModel limitModel);
	
	public ResultModel tranSaveWeekPb(BookedWeekRecordModel weekPb);
	
	public ResultModel tranVerifyOrderInfo(List<String> listPk);
}
