package com.ett.drv.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.util.DateTimeUtil;

import com.ett.drv.biz.IBookedBiz;
import com.ett.drv.mapper.booked.ILimitMapper;
import com.ett.drv.mapper.booked.IOrderInfoMapper;
import com.ett.drv.mapper.booked.IWeekRecordMapper;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;

public class BookedBiz extends BaseDrvBiz implements IBookedBiz {

	/**
	private IWeekRecordMapper<BookedWeekRecordModel> weekRecordMapper;
	private ILimitMapper<BookedLimitModel> limitMapper;
	private IOrderInfoMapper<BookedOrderInfoModel> orderInfoMapper;
	
	
	
	public void setLimitMapper(ILimitMapper<BookedLimitModel> iLimitMapper) {
		this.limitMapper = iLimitMapper;
		this.addCrudMapper(BookedLimitModel.class, iLimitMapper);
	}
	

	public void setWeekRecordMapper(
			IWeekRecordMapper<BookedWeekRecordModel> weekRecordMapper) {
		this.weekRecordMapper = weekRecordMapper;
		this.addCrudMapper(BookedWeekRecordModel.class, weekRecordMapper);
	}


	public void setOrderInfoMapper(
			IOrderInfoMapper<BookedOrderInfoModel> orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
		this.addCrudMapper(BookedOrderInfoModel.class, orderInfoMapper);
	}

*/


	
	public BookedWeekRecordModel getWeekRecord(int weekNum) {
		// TODO Auto-generated method stub
		
		//int lIntWeek=DateTimeUtil.getWeekOfYear(pDate);
		BookedWeekRecordModel lWeekReurn=new BookedWeekRecordModel();
		lWeekReurn.setIWeekNum(weekNum);
		try {
		ArrayList<BookedWeekRecordModel> lListWeek= weekRecordMapper.select(lWeekReurn);
		lWeekReurn=lListWeek.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lWeekReurn;
	}
	
	
	public Map<String,BookedLimitModel> getLimits(int weekNum) throws Exception{
		Map<String, BookedLimitModel> lMapReturn=new HashMap<String, BookedLimitModel>();
		BookedLimitModel lLimit=new BookedLimitModel();
		lLimit.setIWeekNum(weekNum);
        ArrayList<BookedLimitModel> lListLimit=limitMapper.select(lLimit);
		for (BookedLimitModel bookedLimitModel : lListLimit) {
			   lMapReturn.put((String) bookedLimitModel.generalPK(), bookedLimitModel);	
		}
	   return lMapReturn;
	}

}
