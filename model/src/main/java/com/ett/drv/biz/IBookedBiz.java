package com.ett.drv.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.smartken.kia.core.model.IBaseCrudBiz;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;

public interface IBookedBiz extends IBaseCrudBiz{

	//public BookedWeekRecordModel getWeekRecord(Date pDate);
	public BookedWeekRecordModel getWeekRecord(int weekNum);
	
	public Map<String,BookedLimitModel> getLimits(int weekNum) throws Exception;
	
}
